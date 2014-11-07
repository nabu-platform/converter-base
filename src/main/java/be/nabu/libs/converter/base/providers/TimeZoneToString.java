package be.nabu.libs.converter.base.providers;

import java.util.TimeZone;

import be.nabu.libs.converter.api.ConverterProvider;

public class TimeZoneToString implements ConverterProvider<TimeZone, String> {

	@Override
	public String convert(TimeZone instance) {
		return instance == null ? null : instance.getID();
	}

	@Override
	public Class<TimeZone> getSourceClass() {
		return TimeZone.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
