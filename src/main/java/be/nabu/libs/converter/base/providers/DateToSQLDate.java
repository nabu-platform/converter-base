package be.nabu.libs.converter.base.providers;

import java.util.Date;

import be.nabu.libs.converter.api.ConverterProvider;

public class DateToSQLDate implements ConverterProvider<Date, java.sql.Time> {

	@Override
	public java.sql.Time convert(Date instance) {
		return instance == null ? null : new java.sql.Time(instance.getTime());
	}

	@Override
	public Class<Date> getSourceClass() {
		return Date.class;
	}

	@Override
	public Class<java.sql.Time> getTargetClass() {
		return java.sql.Time.class;
	}

}
