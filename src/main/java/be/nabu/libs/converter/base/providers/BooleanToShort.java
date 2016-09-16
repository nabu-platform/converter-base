package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToShort implements ConverterProvider<Boolean, Short> {

	@Override
	public Short convert(Boolean instance) {
		if (instance == null) {
			return null;
		}
		else if (instance) {
			return (short) 1;
		}
		else {
			return (short) 0;
		}
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<Short> getTargetClass() {
		return Short.class;
	}

}
