package org.diverproject.scarlet.language;

import java.util.Map;
import java.util.TreeMap;

import org.diverproject.scarlet.util.StringUtils;

public class LanguageMapper
{
	private String classpath;
	private Map<String, String> messages;

	public LanguageMapper()
	{
		this.messages = new TreeMap<>();
	}

	public String getClasspath()
	{
		return this.classpath;
	}

	public void setClasspath(String classpath)
	{
		this.classpath = classpath;
	}

	public Map<String, String> getMessages()
	{
		return this.messages;
	}

	public void setMessages(Map<String, String> messages)
	{
		this.messages = messages;
	}

	@Override
	public String toString()
	{
		return StringUtils.objectToString(
			this,
			"classpath", this.getClass(),
			"messages", this.getMessages().size()
		);
	}
}
