package be.nabu.libs.converter.base.providers;

import java.util.Date;

import be.nabu.libs.converter.api.ConverterProvider;

public class DateToSQLTimestamp implements ConverterProvider<Date, java.sql.Timestamp> {

	@Override
	public java.sql.Timestamp convert(Date instance) {
		return instance == null ? null : new java.sql.Timestamp(instance.getTime());
	}

	@Override
	public Class<Date> getSourceClass() {
		return Date.class;
	}

	@Override
	public Class<java.sql.Timestamp> getTargetClass() {
		return java.sql.Timestamp.class;
	}

}
