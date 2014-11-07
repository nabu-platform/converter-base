package be.nabu.libs.converter.base.providers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import be.nabu.libs.converter.api.ConverterProvider;

public class BytesToInputStream implements ConverterProvider<byte[], InputStream> {

	@Override
	public InputStream convert(byte[] instance) {
		return instance == null ? null : new ByteArrayInputStream(instance);
	}

	@Override
	public Class<byte[]> getSourceClass() {
		return byte[].class;
	}

	@Override
	public Class<InputStream> getTargetClass() {
		return InputStream.class;
	}

}
