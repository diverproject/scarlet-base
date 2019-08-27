package org.diverproject.scarlet.util;

import static org.diverproject.scarlet.util.language.NumberUtilsLanguage.FLOAT_PARSER_EXPOENT;
import static org.diverproject.scarlet.util.language.NumberUtilsLanguage.FLOAT_PARSER_PRECISION;

import org.diverproject.scarlet.util.exceptions.NumberUtilsRuntimeException;

public class FloatParser
{
	public static final int FLOAT_MAX_PRECISION = 6;

	private boolean isExpression;
	private boolean positive;
	private String value;
	private Integer expoent;
	private boolean expoentPositive;
	private String raw;

	public FloatParser()
	{
		isExpression = false;
		positive = false;
		value = "0";
		expoent = null;
		expoentPositive = true;
		raw = "0";
	}

	public boolean isExpression()
	{
		return isExpression;
	}

	public void setExpression(boolean isExpression)
	{
		this.isExpression = isExpression;
	}

	public boolean isPositive()
	{
		return positive;
	}

	public void setPositive(boolean positive)
	{
		this.positive = positive;
	}

	public boolean isNegative()
	{
		return !isPositive();
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public Integer getExpoent()
	{
		return expoent;
	}

	public void setExpoent(Integer expoent)
	{
		this.expoent = expoent;
	}

	public boolean isExpoentPositive()
	{
		return expoentPositive;
	}

	public void setExpoentPositive(boolean expoentPositive)
	{
		this.expoentPositive = expoentPositive;
	}

	public String getRaw()
	{
		return raw;
	}

	public void setRaw(String raw)
	{
		this.raw = raw;
	}

	public int getPrecision()
	{
		String str = value.replaceAll("[.,]{1}", "");
		str = StringUtils.trim(str, "0");
		int length = str.length();

		return length + ScarletUtils.nvl(Integer.class, expoent, 0);
	}

	public float parseFloat()
	{
		return parseFloat(true);
	}

	public float parseFloat(boolean safe)
	{
		if (expoent != null)
		{
			if (expoent < Float.MIN_EXPONENT || expoent > Float.MAX_EXPONENT)
				throw new NumberUtilsRuntimeException(FLOAT_PARSER_EXPOENT, expoent, Float.MIN_EXPONENT, Float.MAX_EXPONENT);
		}

		if (safe)
		{
			int precision = getPrecision();

			if (precision > FLOAT_MAX_PRECISION)
				throw new NumberUtilsRuntimeException(FLOAT_PARSER_PRECISION, precision, FLOAT_MAX_PRECISION);
		}

		return Float.parseFloat(raw.replace(",", "."));
	}

	@Override
	public String toString()
	{
		return	String.format("%s[isExpression: %s, positive: %s, expoentPositive: %s, expoent: %s, value: %s, raw: %s]",
				getClass().getSimpleName(), isExpression, positive, expoentPositive, expoent, value, raw);
	}
}
