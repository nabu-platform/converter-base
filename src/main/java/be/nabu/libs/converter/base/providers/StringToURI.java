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

import java.net.URI;
import java.net.URISyntaxException;

import be.nabu.libs.converter.api.ConverterProvider;

public class StringToURI implements ConverterProvider<String, URI> {

	@Override
	public URI convert(String instance) {
		try {
			return instance == null ? null : new URI(encodeURI(instance));
		}
		catch (URISyntaxException e) {
			return null;
		}
	}

	@Override
	public Class<String> getSourceClass() {
		return String.class;
	}

	@Override
	public Class<URI> getTargetClass() {
		return URI.class;
	}

	public static java.lang.String encodeURI(java.lang.String uri) {
		uri = uri.replace(" ", "%20");
		uri = uri.replace("{", "%7B");
		uri = uri.replace("}", "%7D");
		uri = uri.replace("|", "%7C");
		uri = uri.replace("^", "%5E");
		uri = uri.replace("[", "%5B");
		uri = uri.replace("]", "%5D");
		return uri;
	}
	
	public static java.lang.String decode(java.lang.String uri) {
		uri = uri.replace("%20", " ");
		uri = uri.replace("%7B", "{");
		uri = uri.replace("%7D", "}");
		uri = uri.replace("%7C", "|");
		uri = uri.replace("%5E", "^");
		uri = uri.replace("%5B", "[");
		uri = uri.replace("%5D", "]");
		return uri;
	}
}
