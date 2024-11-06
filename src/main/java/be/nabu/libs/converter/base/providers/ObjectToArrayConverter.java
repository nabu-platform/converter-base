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

import java.lang.reflect.Array;

import be.nabu.libs.converter.api.ConverterProvider;

public class ObjectToArrayConverter<A, B> implements ConverterProvider<A, B[]> {

	private ConverterProvider<A, B> singleConverter;
	private Class<B[]> targetClass;

	@SuppressWarnings("unchecked")
	public ObjectToArrayConverter(ConverterProvider<A, B> singleConverter) {
		this.singleConverter = singleConverter;
		targetClass = (Class<B[]>) Array.newInstance(singleConverter.getTargetClass(), 0).getClass();
	}

	@SuppressWarnings("unchecked")
	@Override
	public B[] convert(A instance) {
		Object [] array = instance instanceof Object[]
			? (Object[]) instance
			: new Object[] { instance };
		B[] result = (B[]) Array.newInstance(singleConverter.getTargetClass(), array.length);
		for (int i = 0; i < array.length; i++) {
			result[i] = singleConverter.convert((A) array[i]);
		}
		return result;
	}

	@Override
	public Class<A> getSourceClass() {
		return singleConverter.getSourceClass();
	}

	@Override
	public Class<B[]> getTargetClass() {
		return targetClass;
	}
}
