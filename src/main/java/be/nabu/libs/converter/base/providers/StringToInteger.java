package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToInteger implements ConverterProvider<String, Integer> {

	@Override
	public Integer convert(String instance) {
		return instance == null ? null : new Integer(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Integer> getTargetClass() {
		return Integer.class;
	}

}
