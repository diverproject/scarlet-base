package org.diverproject.scarlet.language;

@LanguageAutoloader
public enum LanguageTestIni implements Language
{
	FIRST_MESSAGE		("First"),
	SECOND_MESSAGE		("Second"),
	THIRD_MESSAGE		("Third"),
	FOURTH_MESSAGE		("Fourth"),

	;

	private String format;

	private LanguageTestIni(String format)
	{
		this.setFormat(format);
	}

	@Override
	public int getCode()
	{
		return this.ordinal();
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
}
