package org.diverproject.scarlet.util;

import static org.diverproject.scarlet.util.language.NumberUtilsLanguage.HAS_INTEGER_LENGTH_MINMAX;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.IS_FLOAT_NULL;

import java.util.regex.Pattern;

import org.diverproject.scarlet.Scarlet;
import org.diverproject.scarlet.util.exceptions.NumberUtilsRuntimeException;
import org.diverproject.scarlet.util.exceptions.StringUtilsRuntimeException;

public class NumberUtils
{
	public static final int DECIMAL_DOT_TYPE = 1;
	public static final int DECIMAL_COMMA_TYPE = 2;
	public static final int DECIMAL_ANY_TYPE = DECIMAL_DOT_TYPE | DECIMAL_COMMA_TYPE;
	public static final String INTEGER_REGEX = "^[-+]?(0|[1-9][0-9]*)$";
	public static final String COMMA_OR_DOT_REGEX = "[,.]";

	public static final String FLOAT_REGEX = "^(?<signal>[+-]?)(?<value>\\d+[{DecimalType}]{1}\\d*|\\d*[{DecimalType}]\\d+|\\d+)(?<expoent>$|[eE](?<expoentSignal>[+-]?)(?<expoentValue>[\\d]+)$)";
	public static final String FLOAT_ANY_REGEX = FLOAT_REGEX.replace("{DecimalType}", ".,");
	public static final String FLOAT_DOT_REGEX = FLOAT_REGEX.replace("{DecimalType}", ".");
	public static final String FLOAT_COMMA_REGEX = FLOAT_REGEX.replace("{DecimalType}", ",");
	public static final Pattern PATTERN_ANY = Pattern.compile(FLOAT_ANY_REGEX);
	public static final Pattern PATTERN_DOT = Pattern.compile(FLOAT_DOT_REGEX);
	public static final Pattern PATTERN_COMMA = Pattern.compile(FLOAT_COMMA_REGEX);

	public static final int COMPARE_FAILURE = 0;
	public static final int COMPARE_EQUALS = 1;
	public static final int COMPARE_MAJOR = 2;
	public static final int COMPARE_MINOR = 3;

	public static final int BITS_ON_BYTE = 8;

	NumberUtils()
	{
	}

	public static boolean hasIntegerFormat(String str)
	{
		return str.matches(NumberUtils.INTEGER_REGEX);
	}

	static Pattern getPattern()
	{
		return getPattern(Scarlet.getInstance().getFloatType());
	}

	static Pattern getPattern(int value)
	{
		if (BitwiseUtils.has(value, DECIMAL_DOT_TYPE) && !BitwiseUtils.has(value, DECIMAL_COMMA_TYPE))
			return PATTERN_DOT;

		if (BitwiseUtils.has(value, DECIMAL_COMMA_TYPE) && !BitwiseUtils.has(value, DECIMAL_DOT_TYPE))
			return PATTERN_COMMA;

		return PATTERN_ANY;
	}

	public static boolean isFloatFormat(String str)
	{
		return hasFloatFormat(str, Scarlet.getInstance().getFloatType());
	}

	public static boolean hasFloatFormat(String str, int floatType)
	{
		if (str == null)
			throw new StringUtilsRuntimeException(IS_FLOAT_NULL);

		return getPattern(floatType).matcher(str).find();
	}

	public static boolean hasFloatPrecision(String str, int precision)
	{
		if (!isFloatFormat(str))
			return false;

		if (str.charAt(0) == '+' || str.charAt(0) == '-')
			str = str.substring(1);

		str = str.replaceFirst(COMMA_OR_DOT_REGEX, "");

		return str.length() <= precision;
	}

	public static boolean isNumeric(char c)
	{
		return c >= '0' && c <= '9';
	}

	public static int compareStringNumber(String str, String str2)
	{
		if (!hasIntegerFormat(str) || !hasIntegerFormat(str2))
			return COMPARE_FAILURE;

		if (str.charAt(0) == '-' && str2.charAt(0) != '-')
			return COMPARE_MINOR;

		if (str2.charAt(0) == '-' && str.charAt(0) != '-')
			return COMPARE_MAJOR;

		if (str.charAt(0) == '-' && str2.charAt(0) == '-')
		{
			str = str.substring(1);
			str2 = str2.substring(1);

			String aux = str;
			str = str2;
			str2 = aux;
		}

		else
		{
			if (str.charAt(0) == '+')
				str = str.substring(1);

			if (str2.charAt(0) == '+')
				str2 = str2.substring(1);
		}

		int compare = str.length() > str2.length() ? 1 : (str.length() < str2.length() ? -1 : str.compareTo(str2));
		return compare < 0 ? COMPARE_MINOR : (compare > 0 ? COMPARE_MAJOR : COMPARE_EQUALS);
	}

	public static boolean hasNumberRange(String str, long minValue, long maxValue)
	{
		if (minValue > maxValue)
			throw new NumberUtilsRuntimeException(HAS_INTEGER_LENGTH_MINMAX, minValue, maxValue);

		return	ArrayUtils.in(compareStringNumber(str, Long.toString(minValue)),
					COMPARE_EQUALS, COMPARE_MAJOR
				) && ArrayUtils.in(compareStringNumber(str, Long.toString(maxValue)),
					COMPARE_EQUALS, COMPARE_MINOR
				);
	}
}
