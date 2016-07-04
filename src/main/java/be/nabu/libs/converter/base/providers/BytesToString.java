package be.nabu.libs.converter.base.providers;

import java.nio.charset.Charset;

import be.nabu.libs.converter.api.ConverterProvider;

public class BytesToString implements ConverterProvider<byte[], String> {

	@Override
	public String convert(byte[] instance) {
		return instance == null ? null : new String(instance, Charset.defaultCharset());
	}

	@Override
	public Class<byte[]> getSourceClass() {
		return byte[].class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
