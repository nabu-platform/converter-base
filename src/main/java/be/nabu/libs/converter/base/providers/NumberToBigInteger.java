package be.nabu.libs.converter.base.providers;

import java.math.BigInteger;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToBigInteger implements ConverterProvider<Number, BigInteger> {

	@Override
	public BigInteger convert(Number instance) {
		return instance == null ? null : BigInteger.valueOf(instance.longValue());
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<BigInteger> getTargetClass() {
		return BigInteger.class;
	}

}
