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

import be.nabu.libs.converter.api.ConverterProvider;

public class BooleanToFloat implements ConverterProvider<Boolean, Float> {

	@Override
	public Float convert(Boolean instance) {
		if (instance == null) {
			return null;
		}
		else if (instance) {
			return 1f;
		}
		else {
			return 0f;
		}
	}

	@Override
	public Class<Boolean> getSourceClass() {
		return Boolean.class;
	}

	@Override
	public Class<Float> getTargetClass() {
		return Float.class;
	}

}
