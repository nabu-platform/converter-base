package be.nabu.libs.converter.base.providers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import be.nabu.libs.converter.api.ConverterProvider;

public class InputStreamToBytes implements ConverterProvider<InputStream, byte[]> {

	@Override
	public byte[] convert(InputStream instance) {
		if (instance == null) {
			return null;
		}
		return toBytes(instance);
	}

	public static byte[] toBytes(InputStream instance) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int read = 0;
		byte [] buffer = new byte[8192];
		try {
			try {
				while ((read = instance.read(buffer)) > 0) {
					output.write(buffer, 0, read);
				}
			}
			finally {
				instance.close();
			}
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		return output.toByteArray();
	}

	@Override
	public Class<InputStream> getSourceClass() {
		return InputStream.class;
	}

	@Override
	public Class<byte[]> getTargetClass() {
		return byte[].class;
	}

}
