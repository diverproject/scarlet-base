package org.diverproject.scarlet;

import org.diverproject.scarlet.util.NumberUtils;

public class Scarlet
{
	private static volatile Scarlet instance;

	private int floatType;

	private Scarlet()
	{
		floatType = NumberUtils.DECIMAL_ANY_TYPE;
	}

	public int getFloatType()
	{
		return floatType;
	}

	public void setFloatType(int floatType)
	{
		this.floatType = floatType;
	}

	public static void setInstance(Scarlet instance)
	{
		Scarlet.instance = instance;
	}

	public static Scarlet getInstance()
	{
		if (instance == null)
			synchronized (Scarlet.class)
			{
				if (instance == null)
					instance = new Scarlet();
			}

		return instance;
	}
}
