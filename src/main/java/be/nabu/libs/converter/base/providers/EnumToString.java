package be.nabu.libs.converter.base.providers;

import be.nabu.libs.converter.api.ConverterProvider;

@SuppressWarnings("rawtypes")
public class EnumToString implements ConverterProvider<Enum, String> {

	@Override
	public String convert(Enum arg0) {
		return arg0 == null ? null : arg0.toString();
	}

	@Override
	public Class<Enum> getSourceClass() {
		return Enum.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}
}
