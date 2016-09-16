package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToFloat implements ConverterProvider<Boolean, Float> {

	@Override
	public Float convert(Boolean instance) {
		if (instance == null) {
			return null;
		}
		else if (instance) {
			return 1f;
		}
		else {
			return 0f;
		}
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<Float> getTargetClass() {
		return Float.class;
	}

}
