package be.nabu.libs.converter.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToBoolean implements ConverterProvider<String, Boolean> {

	@Override
	public Boolean convert(String instance) {
		return instance == null ? null : new Boolean(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Boolean> getTargetClass() {
		return Boolean.class;
	}

}
