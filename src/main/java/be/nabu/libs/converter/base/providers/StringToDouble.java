package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToDouble implements ConverterProvider<String, Double> {

	@Override
	public Double convert(String instance) {
		return instance == null ? null : new Double(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Double> getTargetClass() {
		return Double.class;
	}

}
