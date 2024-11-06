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

import java.math.BigDecimal;
import java.math.BigInteger;

import be.nabu.libs.converter.api.ConverterProvider;

public class BigDecimalToBigInteger implements ConverterProvider<BigDecimal, BigInteger> {

	@Override
	public BigInteger convert(BigDecimal instance) {
		return instance == null ? null : instance.toBigInteger();
	}

	@Override
	public Class<BigDecimal> getSourceClass() {
		return BigDecimal.class;
	}

	@Override
	public Class<BigInteger> getTargetClass() {
		return BigInteger.class;
	}

}
