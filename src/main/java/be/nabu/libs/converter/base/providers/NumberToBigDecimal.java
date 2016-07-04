package be.nabu.libs.converter.base.providers;

import java.math.BigDecimal;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToBigDecimal implements ConverterProvider<Number, BigDecimal> {

	@Override
	public BigDecimal convert(Number instance) {
		return instance == null ? null : BigDecimal.valueOf(instance.doubleValue());
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<BigDecimal> getTargetClass() {
		return BigDecimal.class;
	}

}
