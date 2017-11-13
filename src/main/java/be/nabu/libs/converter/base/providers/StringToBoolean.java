package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToBoolean implements ConverterProvider<String, Boolean> {

	@Override
	public Boolean convert(String instance) {
		if (instance == null || instance.trim().isEmpty()) {
			return null;
		}
		else if (instance.matches("[0-9]+")) {
			return Integer.parseInt(instance) >= 1;
		}
		else {
			return Boolean.parseBoolean(instance);
		}
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Boolean> getTargetClass() {
		return Boolean.class;
	}

}
