package be.nabu.libs.converter.base.providers;

import java.util.UUID;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToUUID implements ConverterProvider<String, UUID> {

	@Override
	public UUID convert(String arg0) {
		return arg0 == null ? null : UUID.fromString(arg0);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<UUID> getTargetClass() {
		return UUID.class;
	}

}
