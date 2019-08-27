package org.diverproject.scarlet.util.language;

import org.diverproject.scarlet.language.Language;
import org.diverproject.scarlet.language.LanguageAutoloader;

@LanguageAutoloader
public enum NumberUtilsLanguage implements Language
{
	HAS_INTEGER_LENGTH_MINMAX("min value is major then max value (min: %d, max: %d)"),

	BYTE_PARSER("failure on parse byte (str: %s)"),
	SHORT_PARSER("failure on parse short (str: %s)"),
	INTEGER_PARSER("failure on parse integer (str: %s)"),
	LONG_PARSER("failure on parse long (str: %s)"),
	FLOAT_PARSER("failure on parse float (str: %s)"),

	FLOAT_PARSER_PARSE("invalid float parse (str: %s)"),
	FLOAT_PARSER_PATTERN("unknow float type (floatType: %s)"),
	FLOAT_PARSER_EXPOENT("invalid float expoent (expoent: %d, min: %d, max: %d)"),
	FLOAT_PARSER_PRECISION("parsing safe float invalid precision (limit: %d, precision: %d)"),

	DOUBLE_PARSER_PARSE("invalid double parse (str: %s)"),
	DOUBLE_PARSER_PATTERN("unknow double type (floatType: %s)"),
	DOUBLE_PARSER_EXPOENT("invalid double expoent (expoent: %d, min: %d, max: %d)"),
	DOUBLE_PARSER_PRECISION("parsing safe double invalid precision (limit: %d, precision: %d)"),

	UNKNOW("unknow number utils error");

	private String format;

	private NumberUtilsLanguage(String format)
	{
		this.setFormat(format);
	}

	@Override
	public String getFormat()
	{
		return this.format;
	}

	@Override
	public void setFormat(String format)
	{
		this.format = format;
	}

	@Override
	public int getCode()
	{
		return this.ordinal();
	}
}
