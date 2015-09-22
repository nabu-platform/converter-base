package be.nabu.libs.converter.base.providers;

import java.util.UUID;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToUUID implements ConverterProvider<String, UUID> {

	@Override
	public UUID convert(String arg0) {
		// an unformatted UUID, add formatting to enable parsing
		if (arg0 != null && arg0.indexOf('-') < 0) {
			arg0 = arg0.substring(0, 8) + "-" + arg0.substring(8, 12) + "-" + arg0.substring(12, 16) + "-" + arg0.substring(16, 20) + "-" + arg0.substring(20);
		}
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
