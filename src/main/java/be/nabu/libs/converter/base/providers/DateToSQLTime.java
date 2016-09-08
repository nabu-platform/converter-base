package be.nabu.libs.converter.base.providers;

import java.util.Date;

import be.nabu.libs.converter.api.ConverterProvider;

public class DateToSQLTime implements ConverterProvider<Date, java.sql.Date> {

	@Override
	public java.sql.Date convert(Date instance) {
		return instance == null ? null : new java.sql.Date(instance.getTime());
	}

	@Override
	public Class<Date> getSourceClass() {
		return Date.class;
	}

	@Override
	public Class<java.sql.Date> getTargetClass() {
		return java.sql.Date.class;
	}

}
