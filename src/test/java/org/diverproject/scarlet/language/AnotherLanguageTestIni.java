package org.diverproject.scarlet.language;

@LanguageAutoloader
public enum AnotherLanguageTestIni implements Language
{
	FIRST_MESSAGE		("First"),
	SECOND_MESSAGE		("Second"),

	;

	private String format;

	private AnotherLanguageTestIni(String format)
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
