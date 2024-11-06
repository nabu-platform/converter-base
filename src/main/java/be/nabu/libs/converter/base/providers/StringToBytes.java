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
