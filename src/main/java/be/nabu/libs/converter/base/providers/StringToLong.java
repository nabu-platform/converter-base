package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToLong implements ConverterProvider<String, Long> {

	@Override
	public Long convert(String instance) {
		return instance == null || instance.trim().isEmpty() ? null : new Long(instance);
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
