package be.nabu.libs.converter.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToDouble implements ConverterProvider<Number, Double> {

	@Override
	public Double convert(Number instance) {
		return instance == null ? null : instance.doubleValue();
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<Double> getTargetClass() {
		return Double.class;
	}

}
