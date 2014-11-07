package be.nabu.libs.converter.base.providers;

import java.util.TimeZone;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToTimeZone implements ConverterProvider<String, TimeZone> {

	@Override
	public TimeZone convert(String instance) {
		return instance == null ? null : TimeZone.getTimeZone(instance);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<TimeZone> getTargetClass() {
		return TimeZone.class;
	}

}
