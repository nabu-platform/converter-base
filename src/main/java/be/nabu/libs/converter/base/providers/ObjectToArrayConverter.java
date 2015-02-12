package be.nabu.libs.converter.base.providers;

import java.lang.reflect.Array;

import be.nabu.libs.converter.api.ConverterProvider;

public class ObjectToArrayConverter<A, B> implements ConverterProvider<A, B[]> {

	private ConverterProvider<A, B> singleConverter;
	private Class<B[]> targetClass;

	@SuppressWarnings("unchecked")
	public ObjectToArrayConverter(ConverterProvider<A, B> singleConverter) {
		this.singleConverter = singleConverter;
		targetClass = (Class<B[]>) Array.newInstance(singleConverter.getTargetClass(), 0).getClass();
	}

	@SuppressWarnings("unchecked")
	@Override
	public B[] convert(A instance) {
		Object [] array = instance instanceof Object[]
			? (Object[]) instance
			: new Object[] { instance };
		B[] result = (B[]) Array.newInstance(singleConverter.getTargetClass(), array.length);
		for (int i = 0; i < array.length; i++) {
			result[i] = singleConverter.convert((A) array[i]);
		}
		return result;
	}

	@Override
	public Class<A> getSourceClass() {
		return singleConverter.getSourceClass();
	}

	@Override
	public Class<B[]> getTargetClass() {
		return targetClass;
	}
}
