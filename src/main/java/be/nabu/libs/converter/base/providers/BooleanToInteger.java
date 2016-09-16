package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToInteger implements ConverterProvider<Boolean, Integer> {

	@Override
	public Integer convert(Boolean instance) {
		if (instance == null) {
			return null;
		}
		else if (instance) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<Integer> getTargetClass() {
		return Integer.class;
	}

}
