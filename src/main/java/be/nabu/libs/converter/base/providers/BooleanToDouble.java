package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToDouble implements ConverterProvider<Boolean, Double> {

	@Override
	public Double convert(Boolean instance) {
		if (instance == null) {
			return null;
		}
		else if (instance) {
			return 1d;
		}
		else {
			return 0d;
		}
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<Double> getTargetClass() {
		return Double.class;
	}

}
