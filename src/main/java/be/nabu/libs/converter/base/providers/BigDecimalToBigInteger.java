package be.nabu.libs.converter.base.providers;

import java.math.BigDecimal;
import java.math.BigInteger;

import be.nabu.libs.converter.api.ConverterProvider;

public class BigDecimalToBigInteger implements ConverterProvider<BigDecimal, BigInteger> {

	@Override
	public BigInteger convert(BigDecimal instance) {
		return instance == null ? null : instance.toBigInteger();
	}

	@Override
	public Class<BigDecimal> getSourceClass() {
		return BigDecimal.class;
	}

	@Override
	public Class<BigInteger> getTargetClass() {
		return BigInteger.class;
	}

}
