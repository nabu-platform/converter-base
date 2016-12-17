package be.nabu.libs.converter.base.providers;

import java.sql.Clob;
import java.sql.SQLException;

import be.nabu.libs.converter.api.ConverterProvider;

public class ClobToString implements ConverterProvider<Clob, String> {

	@Override
	public String convert(Clob instance) {
		try {
			if (instance != null) {
				System.out.println("RECEIVED CLOB: " + instance.length() + ": " + instance.getSubString(1,  (int) instance.length()));
			}
			return instance == null ? null : instance.getSubString(1, (int) instance.length());
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Class<Clob> getSourceClass() {
		return Clob.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
