package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToFloat implements ConverterProvider<Number, Float> {

	@Override
	public Float convert(Number instance) {
		return instance == null ? null : instance.floatValue();
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<Float> getTargetClass() {
		return Float.class;
	}

}
