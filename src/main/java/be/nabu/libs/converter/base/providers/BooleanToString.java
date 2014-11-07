package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToString implements ConverterProvider<Boolean, String> {

	@Override
	public String convert(Boolean instance) {
		return instance == null ? null : instance.toString();
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
