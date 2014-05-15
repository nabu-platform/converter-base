package be.nabu.libs.converter.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToFloat implements ConverterProvider<String, Float> {

	@Override
	public Float convert(String instance) {
		return instance == null ? null : new Float(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Float> getTargetClass() {
		return Float.class;
	}

}
