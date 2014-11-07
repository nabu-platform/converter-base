package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToLong implements ConverterProvider<Number, Long> {

	@Override
	public Long convert(Number instance) {
		return instance == null ? null : instance.longValue();
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<Long> getTargetClass() {
		return Long.class;
	}

}
