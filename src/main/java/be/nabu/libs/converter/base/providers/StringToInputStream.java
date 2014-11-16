package be.nabu.libs.converter.base.providers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToInputStream implements ConverterProvider<String, InputStream> {

	@Override
	public InputStream convert(String string) {
		return string == null ? null : new ByteArrayInputStream(string.getBytes(Charset.defaultCharset()));
	}
	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}
	@Override
	public Class<InputStream> getTargetClass() {
		return InputStream.class;
	}
	
}
