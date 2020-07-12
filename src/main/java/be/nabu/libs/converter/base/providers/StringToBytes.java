package be.nabu.libs.converter.base.providers;

import java.nio.charset.Charset;

import be.nabu.libs.converter.api.ConverterProvider;

// this is not in line with the Bytes simple type that does base64 encoding/decoding
// this is partly by choice (this is much lower level and does not care about data types) and because of necessity (bringing this in line with that breaks _everything_)
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
