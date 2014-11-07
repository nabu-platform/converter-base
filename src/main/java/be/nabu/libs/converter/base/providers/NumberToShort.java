package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToShort implements ConverterProvider<Number, Short> {

	@Override
	public Short convert(Number instance) {
		return instance == null ? null : instance.shortValue();
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<Short> getTargetClass() {
		return Short.class;
	}

}
