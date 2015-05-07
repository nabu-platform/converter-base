package be.nabu.libs.converter.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import be.nabu.libs.converter.api.Converter;
import be.nabu.libs.converter.api.ConverterProvider;
import be.nabu.libs.converter.base.providers.ObjectToArrayConverter;
import be.nabu.libs.converter.base.providers.StringToEnum;

public class ConverterImpl implements Converter {

	private Set<ConverterProvider<?, ?>> availableProviders = new HashSet<ConverterProvider<?, ?>>();
	
	@SuppressWarnings("rawtypes")
	private Map<Pair<Class<?>, Class<?>>, ConverterProvider> providers = new HashMap<Pair<Class<?>, Class<?>>, ConverterProvider>();
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object instance, Class<T> targetClass) {
		if (instance == null) {
			return null;
		}
		else if (instance.getClass().equals(targetClass)) {
			return (T) instance;
		}
		Pair<Class<?>, Class<?>> pair = new Pair<Class<?>, Class<?>>(instance.getClass(), targetClass);
		if (!providers.containsKey(pair)) {
			providers.put(pair, findBestProvider(pair.getFirst(), pair.getSecond()));
		}
		return providers.get(pair) == null ? null : (T) providers.get(pair).convert(instance);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ConverterProvider findBestProvider(Class<?> from, Class<?> to) {
		if (availableProviders.isEmpty()) {
			findProviders();
		}
		ConverterProvider current = null;
		// wrap it in a new collection to prevent concurrent modification
		for (ConverterProvider<?, ?> provider : new ArrayList<ConverterProvider<?, ?>>(availableProviders)) {
			if (provider.getSourceClass().isAssignableFrom(from) && provider.getTargetClass().equals(to)) {
				if (current == null || current.getSourceClass().isAssignableFrom(provider.getSourceClass())) {
					current = provider;
				}
			}
		}
		// if no provider was found AND the from is string AND the to is an enum, we have a dynamic transformation
		if (current == null && String.class.isAssignableFrom(from) && Enum.class.isAssignableFrom(to)) {
			current = new StringToEnum(to);
		}
		// otherwise, if we did not find a provider and the target is an array, check if we can convert to the component type
		if (current == null && to.isArray()) {
			ConverterProvider singleProvider = from.isArray() 
				? findBestProvider(from.getComponentType(), to.getComponentType()) 
				: findBestProvider(from, to.getComponentType());
			if (singleProvider != null) {
				current = new ObjectToArrayConverter(singleProvider);
			}
		}
		return current;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void findProviders() {
		if (availableProviders.isEmpty()) {
			synchronized(availableProviders) {
				if (availableProviders.isEmpty()) {		
					Set<ConverterProvider<?, ?>> availableProviders = new HashSet<ConverterProvider<?, ?>>();
					try {
						// let's try this with custom service loading based on a configuration
						Class<?> clazz = getClass().getClassLoader().loadClass("be.nabu.utils.services.ServiceLoader");
						Method declaredMethod = clazz.getDeclaredMethod("load", Class.class);
						availableProviders.addAll((Collection<? extends ConverterProvider<?, ?>>) declaredMethod.invoke(null, ConverterProvider.class));
					}
					catch (ClassNotFoundException e) {
						// ignore, the framework is not present
					}
					catch (NoSuchMethodException e) {
						// corrupt framework?
						throw new RuntimeException(e);
					}
					catch (SecurityException e) {
						throw new RuntimeException(e);
					}
					catch (IllegalAccessException e) {
						// ignore
					}
					catch (InvocationTargetException e) {
						// ignore
					}
					// only use SPI as a final fallback
					ServiceLoader<ConverterProvider> serviceLoader = ServiceLoader.load(ConverterProvider.class);
					for (ConverterProvider provider : serviceLoader) {
						availableProviders.add(provider);
					}
					this.availableProviders.addAll(availableProviders);
				}
			}
		}
	}
	
	public void addProvider(ConverterProvider<?, ?> provider) {
		synchronized(availableProviders) {
			availableProviders.add(provider);
		}
		// clear the currently mapped providers so the optimal ones are recalculated 
		providers.clear();
	}
	
	public void removeProvider(ConverterProvider<?, ?> provider) {
		synchronized(availableProviders) {
			availableProviders.remove(provider);
		}
	}
	
	private static class Pair<S, T> {
		private S first;
		private T second;
		
		public Pair(S first, T second) {
			this.first = first;
			this.second = second;
		}
		
		public S getFirst() {
			return first;
		}

		public T getSecond() {
			return second;
		}

		@Override
		public int hashCode() {
			int result = 1;
			result = 31 * result + ((first == null) ? 0 : first.hashCode());
			result = 31 * result + ((second == null) ? 0 : second.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object object) {
			return object instanceof Pair
				&& ((Pair<?, ?>) object).first.equals(first)
				&& ((Pair<?, ?>) object).second.equals(second);
		}
	}

	@Override
	public boolean canConvert(Class<?> instanceClass, Class<?> targetClass) {
		return findBestProvider(instanceClass, targetClass) != null;
	}
}
