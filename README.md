This package provides base conversions for the converter-api package.

This package (and the converter api in general) provides basic conversion **without** additional metadata.
At the type level there is a typeconverter which adds metadata to a specific data type, allowing for conversions **with** more knowledge.
This enables some new conversions that are hard to do right without metadata (e.g. date to string)

# Marshalling

When the system is specifically converting from or to string, it can also use the marshallable and unmarshallable types through the use of the MarshallableSimpleTypeToString and UnmarshallableSimpleTypeFromString classes.

However note that both of these (from 31/05/2020 onwards, before that date _only_ the marshal had the lower priority which caused inconsistent behavior) have a lower priority so will only kick in if we have no direct converter.

Almost all conversions used marshalling are the same as the converter api, there is however one big discrepancy: bytes to string and string to bytes.

At the converter level this was implemented as one would expect as a java developer -> string.getbytes and new string(bytes). This is still what the converter implementation does. However, at the marshalling level this works differently because of the XML Schema spec which requires all binary content to be base64 encoded.

I tried changing this to bring it in line with the type level conversion but everything fails horribly, the assumption that this is the conversion path has been embedded at too many levels.

Type conversion however has the Bytes data type which will (in accordance with xml schema) be a base64Binary which means it will encode into base64 when byte->string conversion and decode base64 in reverse. For marshalling this is indeed the best option as you can't generally express most bytes as string and send them along.

the xml parser has explicitly used unmarshallable types since day 1 to support this specification. the json parser however was slightly lazier and simply set the string value into the target type. this would trigger (as per usual) a conversion that could bypass the base64 unmarshalling. On 31/05/2020 the json unmarshaller was updated to specifically use the unmarshallable types.