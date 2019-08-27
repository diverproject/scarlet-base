package org.diverproject.scarlet.util.language;

import org.diverproject.scarlet.language.Language;
import org.diverproject.scarlet.language.LanguageAutoloader;

@LanguageAutoloader
public enum ArrayUtilsLanguage implements Language
{
	SUB_ARRAY_CLAZZ_NULL("cannot sub array with null type"),
	SUB_ARRAY_NULL("cannot sub null array"),
	SUB_ARRAY_OFFSET_INVALID("invalid offset (offset: %d)"),
	SUB_ARRAY_LENGTH_INVALID("invalid length (length: %d)"),
	SUB_ARRAY_OUT_OF_BOUNDS("invalid params (offset: %d, length: %d)");

	private String format;

	private ArrayUtilsLanguage(String format)
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
