package be.nabu.libs.converter.providers;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToEnum<E extends Enum<E>> implements ConverterProvider<String, E> {

	private Class<E> enumClass;
	
	public StringToEnum(Class<E> enumClass) {
		this.enumClass = enumClass;
	}

	@Override
	public E convert(String name) {
		return name == null ? null : Enum.valueOf(enumClass, name);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<E> getTargetClass() {
		return enumClass;
	}
}
