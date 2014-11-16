package be.nabu.libs.converter.base.providers;

import java.nio.charset.Charset;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToBytes implements ConverterProvider<String, byte[]> {

	@Override
	public byte[] convert(String string) {
		return string == null ? null : string.getBytes(Charset.defaultCharset());
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<byte[]> getTargetClass() {
		return byte[].class;
	}
}
