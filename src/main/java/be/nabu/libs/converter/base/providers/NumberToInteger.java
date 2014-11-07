package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToInteger implements ConverterProvider<Number, Integer> {

	@Override
	public Integer convert(Number instance) {
		return instance == null ? null : instance.intValue();
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<Integer> getTargetClass() {
		return Integer.class;
	}

}
