package be.nabu.libs.converter.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToShort implements ConverterProvider<String, Short> {

	@Override
	public Short convert(String instance) {
		return instance == null ? null : new Short(instance);
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
