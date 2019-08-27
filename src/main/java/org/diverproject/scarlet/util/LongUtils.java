package org.diverproject.scarlet.util;

import static org.diverproject.scarlet.util.language.NumberUtilsLanguage.LONG_PARSER;

import org.diverproject.scarlet.util.exceptions.NumberUtilsRuntimeException;

public class LongUtils extends NumberUtils
{
	private LongUtils() { }

	public static boolean isLong(String str)
	{
		return hasNumberRange(str, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean isAllLong(String[] array)
	{
		for (String str : array)
			if (!isLong(str))
				return false;

		return true;
	}

	public static long parseLong(String str)
	{
		return parseLong(str, null);
	}

	public static long parseLong(String str, Long failValue)
	{
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			if (failValue != null)
				return failValue;
			throw new NumberUtilsRuntimeException(e, LONG_PARSER, str);
		}
	}

	public static Long parseLongObject(String str)
	{
		return parseLongObject(str, null);
	}

	public static Long parseLongObject(String str, Long failValue)
	{
		return StringUtils.isEmpty(str) ? null : parseLong(str, failValue);
	}

	public static long parseUnsignedByte(byte b)
	{
		long value = b;

		return value >= 0 ? value : 256 + value;
	}

	public static long parseUnsignedShort(short b)
	{
		long value = b;

		return value >= 0 ? value : 65536 + value;
	}

	public static long parseUnsignedInteger(int b)
	{
		long value = b;

		return value >= 0 ? value : 4294967296L + value;
	}

	public static long capMin(long value, long minValue)
	{
		return value < minValue ? minValue : value;
	}

	public static long capMax(long value, long maxValue)
	{
		return value > maxValue ? maxValue : value;
	}

	public static long cap(long value, long minValue, long maxValue)
	{
		return capMin(capMax(value, maxValue), minValue);
	}

	public static boolean hasMin(long value, long min)
	{
		return value >= min;
	}

	public static boolean hasMax(long value, long maxValue)
	{
		return value <= maxValue;
	}

	public static boolean hasBetween(long value, long minValue, long maxValue)
	{
		return hasMin(value, minValue) && hasMax(value, maxValue);
	}
}
