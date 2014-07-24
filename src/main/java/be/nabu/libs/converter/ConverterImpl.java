package be.nabu.libs.converter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import be.nabu.libs.converter.api.Converter;
import be.nabu.libs.converter.api.ConverterProvider;

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
		if (!providers.containsKey(pair))
			providers.put(pair, findBestProvider(pair.getFirst(), pair.getSecond()));
		return providers.get(pair) == null ? null : (T) providers.get(pair).convert(instance);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ConverterProvider findBestProvider(Class<?> from, Class<?> to) {
		if (availableProviders.isEmpty())
			findProviders();
		ConverterProvider current = null;
		for (ConverterProvider<?, ?> provider : availableProviders) {
			if (provider.getSourceClass().isAssignableFrom(from) && provider.getTargetClass().equals(to)) {
				if (current == null || current.getSourceClass().isAssignableFrom(provider.getSourceClass()))
					current = provider;
			}
		}
		return current;
	}
	
	@SuppressWarnings("rawtypes")
	private void findProviders() {
		ServiceLoader<ConverterProvider> serviceLoader = ServiceLoader.load(ConverterProvider.class);
		for (ConverterProvider provider : serviceLoader)
			availableProviders.add(provider);
	}
	
	public void addProvider(ConverterProvider<?, ?> provider) {
		availableProviders.add(provider);
		// clear the currently mapped providers so the optimal ones are recalculated 
		providers.clear();
	}
	
	public void removeProvider(ConverterProvider<?, ?> provider) {
		availableProviders.remove(provider);
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
		public boolean equals(Object instance) {
			return instance instanceof Pair
					&& ((Pair<?, ?>) instance).first.equals(first)
					&& ((Pair<?, ?>) instance).second.equals(second);
		}
	}

	@Override
	public boolean canConvert(Class<?> instanceClass, Class<?> targetClass) {
		return findBestProvider(instanceClass, targetClass) != null;
	}
}
