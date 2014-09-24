package be.nabu.libs.converter.providers;

import java.util.UUID;

import be.nabu.libs.converter.api.ConverterProvider;

public class UUIDToString implements ConverterProvider<UUID, String> {

	@Override
	public String convert(UUID arg0) {
		return arg0 == null ? null : arg0.toString();
	}

	@Override
	public Class<UUID> getSourceClass() {
		return UUID.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}
}
