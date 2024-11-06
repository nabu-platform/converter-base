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

import java.util.UUID;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToUUID implements ConverterProvider<String, UUID> {

	@Override
	public UUID convert(String arg0) {
		// an unformatted UUID, add formatting to enable parsing
		if (arg0 != null && !arg0.trim().isEmpty() && arg0.indexOf('-') < 0) {
			arg0 = arg0.substring(0, 8) + "-" + arg0.substring(8, 12) + "-" + arg0.substring(12, 16) + "-" + arg0.substring(16, 20) + "-" + arg0.substring(20);
		}
		return arg0 == null || arg0.trim().isEmpty() ? null : UUID.fromString(arg0);
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<UUID> getTargetClass() {
		return UUID.class;
	}

}
