package be.nabu.libs.converter;

import java.util.Date;

import junit.framework.TestCase;
import be.nabu.libs.converter.ConverterFactory;
import be.nabu.libs.converter.api.Converter;

public class TestConversions extends TestCase {
	
	private Converter converter = ConverterFactory.getInstance().getConverter();
	
	public void testIfPossible() {
		assertTrue(converter.canConvert(Boolean.class, String.class));
	}
	
	public void testStringToDouble() {
		assertEquals(1.0, converter.convert("1", Double.class));
	}
	
	public void testDoubleToString() {
		assertEquals("1.0", converter.convert(1.0, String.class));
	}
	
	public void testIntegerToString() {
		assertEquals("1", converter.convert(1, String.class));
	}
	
	public void testLongToString() {
		assertEquals("1", converter.convert(1L, String.class));
	}
	
	public void testDateToLong() {
		assertEquals(new Long(1), converter.convert(new Date(1), Long.class));
	}
	
	public void testLongToDate() {
		assertEquals(new Date(1), converter.convert(new Long(1), Date.class));
	}
	
	public void testNumberToDouble() {
		assertEquals(1.0, converter.convert(1, Double.class));
	}
	
	public void testNumberToFloat() {
		assertEquals(1.0f, converter.convert(1, Float.class));
	}

	public void testNumberToInteger() {
		assertEquals(new Integer(1), converter.convert(1L, Integer.class));
	}
	
	public void testNumberToShort() {
		assertEquals(new Short((short) 1), converter.convert(1L, Short.class));
	}
	
	public void testNumberToString() {
		assertEquals("1", converter.convert(1L, String.class));
	}
	
	public void testStringToBoolean() {
		assertTrue(converter.convert("true", Boolean.class));
		assertFalse(converter.convert("false", Boolean.class));
	}
}
