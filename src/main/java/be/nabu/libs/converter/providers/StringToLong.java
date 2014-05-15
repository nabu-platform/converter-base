package be.nabu.libs.converter.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToLong implements ConverterProvider<String, Long> {

	@Override
	public Long convert(String instance) {
		return instance == null ? null : new Long(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Long> getTargetClass() {
		return Long.class;
	}

}
