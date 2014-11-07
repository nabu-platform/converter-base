package be.nabu.libs.converter.base.providers;

import java.util.Date;

import be.nabu.libs.converter.api.ConverterProvider;

public class LongToDate implements ConverterProvider<Long, Date> {

	@Override
	public Date convert(Long instance) {
		return instance == null ? null : new Date(instance);
	}

	@Override
	public Class<Long> getSourceClass() {
		return Long.class;
	}

	@Override
	public Class<Date> getTargetClass() {
		return Date.class;
	}

}
