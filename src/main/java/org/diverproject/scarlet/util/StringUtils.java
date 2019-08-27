package org.diverproject.scarlet.util;

import static org.diverproject.scarlet.util.ScarletUtils.nameOf;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.BACKSPACE_OUT_OF_BOUNDS;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.CAP_LENGTH;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.CAP_MOD_LENGTH;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.CAP_NULL;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.INDENT_LENGTH;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.INDEX_OF_SEQUENCE_EMPTY;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.INDEX_OF_SEQUENCE_NULL;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.INDEX_OF_STRING;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.INDEX_OF_TIMES;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.INSERT_OUT_OF_BOUNDS;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PAD_PATTERN_COUNT;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PAD_PATTERN_EMPTY;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PAD_PATTERN_NULL;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PAD_STRING_NULL;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PAD_TYPE;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PARSE_EMPTY_EMPTY;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.PARSE_EMPTY_NULL;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.SPLIT_LENGTH_LENGTH;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.SPLIT_LENGTH_NULL_STIRNG;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.TRIM_SEQUENCE_EMPTY;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.TRIM_SEQUENCE_NULL;
import static org.diverproject.scarlet.util.language.StringUtilsLanguage.TRIM_STRING;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.diverproject.scarlet.util.exceptions.StringUtilsRuntimeException;

public class StringUtils
{
	public static final String ACCENTS = "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛÅåÅ";
	public static final String UNACCENTS = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOUAaA";
	public static final String LETTERS_LOWER = "abcdefghijklmnopqrstuvxwyz";
	public static final String LETTERS_UPPER = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
	public static final String LETTERS = LETTERS_LOWER + LETTERS_UPPER + ACCENTS;
	public static final String LETTERS_NUMBERS = LETTERS_UPPER + "0123456789";

	public static final int PAD_LEFT = 1;
	public static final int PAD_RIGHT = 2;
	public static final int MIN_PAD_ORIENTATION = PAD_LEFT;
	public static final int MAX_PAD_ORIENTATION = PAD_RIGHT;

	public static final int PAD_LENGTH = 1;
	public static final int PAD_MOD = 2;
	public static final int MIN_PAD_TYPE = PAD_LENGTH;
	public static final int MAX_PAD_TYPE = PAD_MOD;

	public static final int MIN_PAD_PATTERN_LENGTH = 1;
	public static final int MIN_SPLIT_LENGTH = 1;
	public static final int MIN_CAP_LENGTH = 1;
	public static final int MIN_CAP_MOD = 1;

	public static final String PARAMETERS_REGEX = "^(?<message>.+)\\s\\((?<parameters>.*)\\)$";

	private StringUtils()
	{
	}

	public static String nvl(String value)
	{
		return nvl(value, "");
	}

	public static String nvl(String value, String nullValue)
	{
		return value == null ? nullValue : value;
	}

	public static String unaccent(String str)
	{
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

		return str;
	}

	public static boolean isAlpha(String str)
	{
		str = unaccent(str);

		for (char c : str.toCharArray())
			if (!LETTERS.contains(Character.toString(c)))
				return false;

		return true;
	}

	public static String substr(String str, int start)
	{
		return substr(str, start, str.length());
	}

	public static String substr(String str, int start, int end)
	{
		if (str == null)
			return null;

		if (start < 0 && start < str.length() * -1 || start > str.length())
			throw new StringIndexOutOfBoundsException(start);

		if (end < 0 && end < str.length() * -1 || end > str.length())
			throw new StringIndexOutOfBoundsException(end);

		if (start == end)
			return "";

		int beginIndex = start < 0 ? str.length() + start : start;
		int endIndex = end < 0 ? str.length() + end : end;

		return str.substring(beginIndex, endIndex);
	}

	public static String substrAt(String str, int end)
	{
		return substr(str, 0, end);
	}

	public static String substr(String str, char character)
	{
		return substr(str, Character.toString(character));
	}

	public static String substr(String str, String sequence)
	{
		int beginIndex = str.indexOf(sequence) + sequence.length();

		return beginIndex < 0 ? str : substr(str, beginIndex);
	}

	public static String substrAt(String str, char character)
	{
		return substrAt(str, Character.toString(character));
	}

	public static String substrAt(String str, String sequence)
	{
		int endIndex = str.indexOf(sequence);

		return endIndex < 0 ? str : substr(str, 0, endIndex);
	}

	public static String trim(String str, String sequence)
	{
		return trimLeft(trimRight(str, sequence), sequence);
	}

	public static String trimRight(String str, String sequence)
	{
		if (str == null) throw new StringUtilsRuntimeException(TRIM_STRING);
		if (sequence == null) throw new StringUtilsRuntimeException(TRIM_SEQUENCE_NULL);
		if (sequence.isEmpty()) throw new StringUtilsRuntimeException(TRIM_SEQUENCE_EMPTY);

		int endIndex = -1;

		for (int i = str.length() - 1, j = sequence.length() - 1; i >= 0 && i >= 0; i--)
		{
			if (sequence.charAt(j) != str.charAt(i))
				break;

			if (--j == -1)
			{
				endIndex = i;
				j = sequence.length() - 1;
			}
		}

		return endIndex != -1 ? str.substring(0, endIndex) : str;
	}

	public static String trimLeft(String str, String sequence)
	{
		if (str == null) throw new StringUtilsRuntimeException(TRIM_STRING);
		if (sequence == null) throw new StringUtilsRuntimeException(TRIM_SEQUENCE_NULL);
		if (sequence.isEmpty()) throw new StringUtilsRuntimeException(TRIM_SEQUENCE_EMPTY);

		int beginIndex = -1;

		for (int i = 0, j = 0; j < sequence.length() && i < str.length(); i++)
		{
			if (sequence.charAt(j) != str.charAt(i))
				break;

			if (++j == sequence.length())
			{
				beginIndex = i;
				j = 0;
			}
		}

		return beginIndex != -1 ? str.substring(beginIndex + 1) : str;
	}

	public static int countOf(String str, char c)
	{
		int count = 0;

		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == c)
				count++;

		return count;
	}

	public static int indexOf(String str, char character, int time)
	{
		return indexOf(str, Character.toString(character), time);
	}

	public static int indexOf(String str, String sequence, int times)
	{
		if (str == null) throw new StringUtilsRuntimeException(INDEX_OF_STRING);
		if (sequence == null) throw new StringUtilsRuntimeException(INDEX_OF_SEQUENCE_NULL);
		if (sequence.isEmpty()) throw new StringUtilsRuntimeException(INDEX_OF_SEQUENCE_EMPTY);
		if (times < 0) throw new StringUtilsRuntimeException(INDEX_OF_TIMES);

		for (int characterIndex = 0, sequenceOffset = 0, matchCount = 0; characterIndex < str.length(); characterIndex++)
		{
			if (str.charAt(characterIndex) == sequence.charAt(sequenceOffset))
			{
				if (++sequenceOffset == sequence.length())
				{
					if (++matchCount == times)
						return characterIndex - (sequence.length() - 1);

					sequenceOffset = 0;
				}
			}
			else
				sequenceOffset = 0;
		}

		return -1;
	}

	public static String replace(String str, String replacement, String... targets)
	{
		for (String target : targets)
			str = str.replace(target, replacement);

		return str;
	}

	public static int countOf(String str, String sequence)
	{
		int count = 0;

		for (int i = 0; i < str.length(); i++)
		{
			int repeated = 0;

			for (int j = 0; j < sequence.length(); j++, repeated++)
				if (!(i + j < str.length() && str.charAt(i + j) == sequence.charAt(j)))
				{
					repeated = 0;
					break;
				}

			if (repeated == sequence.length())
				count++;
		}

		return count;
	}

	public static String pad(String str, String pattern, int patternCount, int padType, int padOrientation)
	{
		switch (padOrientation)
		{
			case PAD_LEFT: return leftPad(str, pattern, patternCount, padType);
			case PAD_RIGHT: return rightPad(str, pattern, patternCount, padType);
		}

		throw new StringUtilsRuntimeException(PAD_TYPE, padType);
	}

	public static String leftPad(String str, String pattern, int patternCount, int padType)
	{
		switch (padType)
		{
			case PAD_LENGTH: return leftPadLength(str, pattern, patternCount);
			case PAD_MOD: return leftPadMod(str, pattern, patternCount);
		}

		throw new StringUtilsRuntimeException(PAD_TYPE, padType);
	}

	public static String rightPad(String str, String pattern, int patternCount, int padType)
	{
		switch (padType)
		{
			case PAD_LENGTH: return rightPadLength(str, pattern, patternCount);
			case PAD_MOD: return rightPadMod(str, pattern, patternCount);
		}

		throw new StringUtilsRuntimeException(PAD_TYPE, padType);
	}

	private static void validatePad(String str, String pattern, int patternCount)
	{
		if (str == null)
			throw new StringUtilsRuntimeException(PAD_STRING_NULL);

		if (pattern == null)
			throw new StringUtilsRuntimeException(PAD_PATTERN_NULL);

		if (pattern.isEmpty())
			throw new StringUtilsRuntimeException(PAD_PATTERN_EMPTY);

		if (patternCount < MIN_PAD_PATTERN_LENGTH)
			throw new StringUtilsRuntimeException(PAD_PATTERN_COUNT, patternCount);
	}

	public static String leftPadLength(String str, String pattern, int patternCount)
	{
		validatePad(str, pattern, patternCount);

		while (str.length() < patternCount)
			str = pattern + str;

		return str;
	}

	public static String rightPadLength(String str, String pattern, int patternCount)
	{
		validatePad(str, pattern, patternCount);

		while (str.length() < patternCount)
			str = str + pattern;

		return str;
	}

	public static String leftPadMod(String str, String pattern, int patternCount)
	{
		validatePad(str, pattern, patternCount);

		while (str.length() % patternCount != 0)
			str = pattern + str;

		return str;
	}

	public static String rightPadMod(String str, String pattern, int patternCount)
	{
		validatePad(str, pattern, patternCount);

		while (str.length() % patternCount != 0)
			str = str + pattern;

		return str;
	}

	public static String[] splitLength(String str, int length)
	{
		if (str == null)
			throw new StringUtilsRuntimeException(SPLIT_LENGTH_NULL_STIRNG, length);

		if (length < MIN_SPLIT_LENGTH)
			throw new StringUtilsRuntimeException(SPLIT_LENGTH_LENGTH, length);

		if (length > str.length())
			return new String[] { str };

		if (str.isEmpty())
			return new String[] { "" };

		char chars[] = str.toCharArray();
		double splittedItemLength = (double) str.length() / (double) length;
		int splittedLength = (int) Math.ceil(splittedItemLength);
		String splitted[] = new String[splittedLength];

		for (int i = 0; i < splitted.length; i++)
			splitted[i] = new String(ArrayUtils.subArray(chars, i * length, length));

		return splitted;
	}

	public static String[] splitInto(String str, int count)
	{
		if (str == null)
			return splitLength(str, MIN_SPLIT_LENGTH);

		double splittedItemLength = (double) str.length() / (double) count;
		int length = (int) Math.ceil(splittedItemLength);

		return splitLength(str, length);
	}

	public static String cap(String str, int length)
	{
		if (str == null)
			throw new StringUtilsRuntimeException(CAP_NULL);

		if (length < MIN_CAP_LENGTH)
			throw new StringUtilsRuntimeException(CAP_LENGTH, MIN_CAP_LENGTH);

		if (length > str.length())
			return str;

		return str.substring(0, length);
	}

	public static String capMod(String str, int mod)
	{
		if (str == null)
			return cap(str, MIN_CAP_MOD);

		if (mod < MIN_CAP_MOD)
			throw new StringUtilsRuntimeException(CAP_MOD_LENGTH);

		return cap(str, str.length() - str.length() % mod);
	}

	public static boolean isEmpty(String str)
	{
		return str == null || str.isEmpty();
	}

	public static void parseEmpty(String str)
	{
		if (str == null)
			throw new StringUtilsRuntimeException(PARSE_EMPTY_NULL);

		if (str.isEmpty())
			throw new StringUtilsRuntimeException(PARSE_EMPTY_EMPTY);
	}

	public static String genCode(int size)
	{
		return genCode(size, LETTERS_NUMBERS);
	}

	public static String genCode(int size, String characters)
	{
		char[] codes = new char[size];
		Random random = new Random();

		for (int i = 0; i < size; i++)
			codes[i] = characters.charAt(random.nextInt(characters.length() - 1));

		return new String(codes);
	}

	public static String insert(String str, char c, int index)
	{
		if (index < 0 || index > str.length())
			throw new StringUtilsRuntimeException(new ArrayIndexOutOfBoundsException(index));

		else if (index == 0 && str.length() > 0)
			return c + str;

		else if (index == str.length())
			return str + c;

		return substrAt(str, index) + c + str.substring(index);
	}

	public static String insert(String str, String insertString, int index)
	{
		if (index < 0 || index > str.length())
			throw new StringUtilsRuntimeException(INSERT_OUT_OF_BOUNDS, index);

		else if (index == 0 && str.length() > 0)
			return insertString + str;

		else if (index == str.length())
			return str + insertString;

		return substrAt(str, index) + insertString + str.substring(index);
	}

	public static String backspace(String string, int index)
	{
		if (index < 0 || index > string.length())
			throw new StringUtilsRuntimeException(BACKSPACE_OUT_OF_BOUNDS, index);

		if (index == 0)
			return string;

		return substrAt(string, index - 1) + substr(string, index);
	}

	public static String delete(String string, int index)
	{
		if (index < 0 || index > string.length())
			throw new StringUtilsRuntimeException(BACKSPACE_OUT_OF_BOUNDS, index);

		if (index == string.length())
			return string;

		return substrAt(string, index) + substr(string, index + 1);
	}

	public static String parseString(byte[] bytes)
	{
		if (bytes.length == 0 || bytes[0] == 0x00)
			return "";

		for (int i = 1; i < bytes.length; i++)
			if (bytes[i] == 0x00)
				return new String(ArrayUtils.subArray(bytes, 0, i));

		return new String(bytes);
	}

	public static String indent(int length)
	{
		if (length < 0)
			throw new StringUtilsRuntimeException(INDENT_LENGTH, length);

		char[] tabs = new char[length];
		Arrays.fill(tabs, '\t');

		return new String(tabs);
	}

	public static String parseParameters(Object... args)
	{
		return parseParametersFormat(", ", ": ", args);
	}

	public static String parseParametersFormat(String parameterSeparetor, String valueSeparetor, Object... args)
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i <= args.length - 2; i += 2)
		{
			if (args[i] == null)
				args[i] = "null";

			stringBuilder.append(args[i].toString());
			stringBuilder.append(valueSeparetor);
			stringBuilder.append(args[i + 1].toString());

			if (i < args.length - 3)
				stringBuilder.append(parameterSeparetor);
		}

		return stringBuilder.toString();
	}

	public static String extendParameters(String str, Object... args)
	{
		return extendParameters(str, parseParameters(args));
	}

	public static String extendParameters(String str, String data)
	{
		final Pattern pattern = Pattern.compile(PARAMETERS_REGEX, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(str);
		String message = str;
		String parameters = "";

		if (matcher.find())
		{
			message = matcher.group("message");
			parameters = matcher.group("parameters");
			parameters = parameters.isEmpty() ? data : parameters+ ", " +data;
		}
		else
			parameters = data;

		return String.format("%s (%s)", message, parameters);
	}

	public static String formatMoney(long value)
	{
		return formatMoney(",", value);
	}

	public static String formatMoney(String thousandSeparator, long value)
	{
		boolean negative = value < 0;

		if (negative)
			value *= -1;

		String strv = Long.toString(value);
		String str = "";

		for (int i = 0; i < strv.length(); i++)
		{
			if (i % 3 == 0 && i > 0)
				str = thousandSeparator + str;

			str = strv.charAt(strv.length() - i - 1) + str;
		}

		str = str.startsWith(thousandSeparator) ? str.substring(1, str.length()) : str;

		if (negative)
			str = "-" + str;

		return str;
	}

	public static String firstUppercase(String str)
	{
		if (str == null)
			return null;

		return str.isEmpty() ? str : str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String singleLine(String str)
	{
		return str == null ? null : str.replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
	}

	public static String objectToString(Object object, Object... args)
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < args.length - 1; i++)
			stringBuilder.append(String.format("%s=%s, ", args[i], args[++i]));

		return String.format("%s[%s]", nameOf(object), StringUtils.substr(stringBuilder.toString(), 0, -2));
	}

	public static String getStackTrace(Exception e)
	{
		String className = e.getClass().getName();
		String trace = getStackTrace(e.getStackTrace());

		if (StringUtils.isEmpty(e.getMessage()))
			return String.format("%s\n%s", className, trace);

		return String.format("%s - %s\n%s", className, e.getMessage(), trace);
	}

	public static String getStackTrace(Throwable throwable)
	{
		String className = throwable.getClass().getName();
		String trace = getStackTrace(throwable.getStackTrace());

		return className+ "\n" +trace;
	}

	public static String getStackTrace(StackTraceElement[] stackTraceElements)
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (StackTraceElement stackTraceElement : stackTraceElements)
			stringBuilder.append(
				String.format(
					"\tat %s.%s(%s:%s)\n",
					stackTraceElement.getClassName(),
					stackTraceElement.getMethodName(),
					stackTraceElement.getFileName(),
					stackTraceElement.getLineNumber()
				)
			);

		return stringBuilder.toString();
	}

	public static String getSimpleNameOf(String classname)
	{
		return	StringUtils.isEmpty(classname) ?
					null : (
						classname.lastIndexOf("$") >= 0 ?
							classname.substring(classname.lastIndexOf("$") + 1) : (
								classname.lastIndexOf(".") < 0 ?
									classname : classname.substring(classname.lastIndexOf(".") + 1)
							)
					)
				;
	}
}
