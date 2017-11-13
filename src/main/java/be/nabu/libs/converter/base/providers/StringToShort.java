package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToShort implements ConverterProvider<String, Short> {

	@Override
	public Short convert(String instance) {
		return instance == null || instance.trim().isEmpty() ? null : new Short(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<Short> getTargetClass() {
		return Short.class;
	}

}
