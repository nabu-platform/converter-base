package be.nabu.libs.converter.base.providers;

import java.net.URI;

import be.nabu.libs.converter.api.ConverterProvider;

public class URIToString implements ConverterProvider<URI, String> {

	@Override
	public String convert(URI instance) {
		return instance == null ? null : instance.toString();
	}

	@Override
	public Class<URI> getSourceClass() {
		return URI.class;
	}

	@Override
	public Class<String> getTargetClass() {
		return String.class;
	}

}
