package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class NumberToBoolean implements ConverterProvider<Number, Boolean> {

	@Override
	public Boolean convert(Number instance) {
		if (instance == null) {
			return null;
		}
		else if (instance.intValue() >= 1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Class<Number> getSourceClass() {
		return Number.class;
	}

	@Override
	public Class<Boolean> getTargetClass() {
		return Boolean.class;
	}

}
