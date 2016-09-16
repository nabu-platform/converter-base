package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToLong implements ConverterProvider<Boolean, Long> {

	@Override
	public Long convert(Boolean instance) {
		if (instance == null) {
			return null;
		}
		else if (instance) {
			return 1l;
		}
		else {
			return 0l;
		}
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<Long> getTargetClass() {
		return Long.class;
	}

}
