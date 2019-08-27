package org.diverproject.scarlet.language;

import org.diverproject.scarlet.ScarletException;

public class LanguageExcepion extends ScarletException
{
	private static final long serialVersionUID = -6658438626365742664L;

	private Language language;

	public LanguageExcepion(Language language)
	{
		super(language);
	}

	public LanguageExcepion(Language language, Object... args)
	{
		super(language, args);
	}

	public LanguageExcepion(Exception e)
	{
		super(e);
	}

	public LanguageExcepion(Exception e, Language language)
	{
		super(e, language);
	}

	public LanguageExcepion(Exception e, Language language, Object... args)
	{
		super(e, language, args);
	}

	@Override
	public int getCode()
	{
		return this.language.getCode();
	}
}
