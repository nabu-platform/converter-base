package be.nabu.libs.converter.base.providers;

import java.math.BigDecimal;
import java.math.BigInteger;

import be.nabu.libs.converter.api.ConverterProvider;

public class BigIntegerToBigDecimal implements ConverterProvider<BigInteger, BigDecimal> {

	@Override
	public BigDecimal convert(BigInteger instance) {
		return instance == null ? null : new BigDecimal(instance);
	}

	@Override
	public Class<BigInteger> getSourceClass() {
		return BigInteger.class;
	}

	@Override
	public Class<BigDecimal> getTargetClass() {
		return BigDecimal.class;
	}

}
