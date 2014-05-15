package be.nabu.libs.converter.providers;

import java.util.Date;

import be.nabu.libs.converter.api.ConverterProvider;

public class DateToLong implements ConverterProvider<Date, Long> {

	@Override
	public Long convert(Date instance) {
		return instance == null ? null : instance.getTime();
	}

	@Override
	public Class<Date> getSourceClass() {
		return Date.class;
	}

	@Override
	public Class<Long> getTargetClass() {
		return Long.class;
	}

}
