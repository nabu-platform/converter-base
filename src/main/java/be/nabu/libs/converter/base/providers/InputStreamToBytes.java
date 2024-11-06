/*
* Copyright (C) 2014 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

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
