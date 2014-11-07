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
