package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToString implements ConverterProvider<Number, String> {

	@Override
	public String convert(Number instance) {
		return instance == null ? null : instance.toString();
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
