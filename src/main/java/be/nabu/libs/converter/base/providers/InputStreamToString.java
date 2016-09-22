package be.nabu.libs.converter.base.providers;

import java.io.InputStream;
import java.nio.charset.Charset;

import be.nabu.libs.converter.api.ConverterProvider;

public class InputStreamToString implements ConverterProvider<InputStream, String> {

	@Override
	public String convert(InputStream instance) {
		return instance == null ? null : new String(InputStreamToBytes.toBytes(instance), Charset.defaultCharset());
	}

	@Override
	public Class<InputStream> getSourceClass() {
		return InputStream.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
