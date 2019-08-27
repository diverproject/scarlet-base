package org.diverproject.scarlet.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.diverproject.scarlet.util.FloatParser;
import org.diverproject.scarlet.util.FloatUtils;
import org.diverproject.scarlet.util.exceptions.NumberUtilsRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Float Utils")
public class TestFloatUtils
{
	@Test
	@DisplayName("Is a safe float value")
	public void testIsSafeFloat() throws IOException
	{
		assertTrue(FloatUtils.isSafeFloat("1"));
		assertTrue(FloatUtils.isSafeFloat("1."));
		assertTrue(FloatUtils.isSafeFloat(".1"));
		assertTrue(FloatUtils.isSafeFloat("1.1"));
		assertTrue(FloatUtils.isSafeFloat("-1"));
		assertTrue(FloatUtils.isSafeFloat("-1."));
		assertTrue(FloatUtils.isSafeFloat("-.1"));
		assertTrue(FloatUtils.isSafeFloat("-1.1"));
		assertTrue(FloatUtils.isSafeFloat("+1"));
		assertTrue(FloatUtils.isSafeFloat("+1."));
		assertTrue(FloatUtils.isSafeFloat("+.1"));
		assertTrue(FloatUtils.isSafeFloat("+1.1"));
		assertFalse(FloatUtils.isSafeFloat("a1"));
		assertFalse(FloatUtils.isSafeFloat("1a"));
		assertFalse(FloatUtils.isSafeFloat("a1."));
		assertFalse(FloatUtils.isSafeFloat("1a."));
		assertFalse(FloatUtils.isSafeFloat("1.a"));
		assertFalse(FloatUtils.isSafeFloat("a.1"));
		assertFalse(FloatUtils.isSafeFloat(".a1"));
		assertFalse(FloatUtils.isSafeFloat(".1a"));
		assertFalse(FloatUtils.isSafeFloat("a1.1"));
		assertFalse(FloatUtils.isSafeFloat("1a.1"));
		assertFalse(FloatUtils.isSafeFloat("1.a1"));
		assertFalse(FloatUtils.isSafeFloat("1.1a"));
		assertFalse(FloatUtils.isSafeFloat("a-1"));
		assertFalse(FloatUtils.isSafeFloat("-a1"));
		assertFalse(FloatUtils.isSafeFloat("-1a"));
		assertFalse(FloatUtils.isSafeFloat("a-1."));
		assertFalse(FloatUtils.isSafeFloat("-a1."));
		assertFalse(FloatUtils.isSafeFloat("-1a."));
		assertFalse(FloatUtils.isSafeFloat("-1.a"));
		assertFalse(FloatUtils.isSafeFloat("a-.1"));
		assertFalse(FloatUtils.isSafeFloat("-a.1"));
		assertFalse(FloatUtils.isSafeFloat("-.a1"));
		assertFalse(FloatUtils.isSafeFloat("-.1a"));
		assertFalse(FloatUtils.isSafeFloat("a-1.1"));
		assertFalse(FloatUtils.isSafeFloat("-a1.1"));
		assertFalse(FloatUtils.isSafeFloat("-1a.1"));
		assertFalse(FloatUtils.isSafeFloat("-1.a1"));
		assertFalse(FloatUtils.isSafeFloat("-1.1a"));
		assertFalse(FloatUtils.isSafeFloat("a+1"));
		assertFalse(FloatUtils.isSafeFloat("+a1"));
		assertFalse(FloatUtils.isSafeFloat("+1a"));
		assertFalse(FloatUtils.isSafeFloat("a+1."));
		assertFalse(FloatUtils.isSafeFloat("+a1."));
		assertFalse(FloatUtils.isSafeFloat("+1a."));
		assertFalse(FloatUtils.isSafeFloat("+1.a"));
		assertFalse(FloatUtils.isSafeFloat("a+.1"));
		assertFalse(FloatUtils.isSafeFloat("+a.1"));
		assertFalse(FloatUtils.isSafeFloat("+.a1"));
		assertFalse(FloatUtils.isSafeFloat("+.1a"));
		assertFalse(FloatUtils.isSafeFloat("a+1.1"));
		assertFalse(FloatUtils.isSafeFloat("+a1.1"));
		assertFalse(FloatUtils.isSafeFloat("+1a.1"));
		assertFalse(FloatUtils.isSafeFloat("+1.a1"));
		assertFalse(FloatUtils.isSafeFloat("+1.1a"));
	}

	@Test
	@DisplayName("Is all a safe float value")
	public void testIsAllSafeFloat() throws IOException
	{
		String[] strings = new String[] {
			"1",
			"1.",
			".1",
			"1.1",
			"-1",
			"-1.",
			"-.1",
			"-1.1",
			"+1",
			"+1.",
			"+.1",
			"+1.1",
		};
		assertTrue(FloatUtils.isAllSafeFloat(strings));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a1." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "1a." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "1.a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { ".a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { ".1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a1.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "1a.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "1.a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "1.1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a-1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a-1." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-a1." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-1a." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-1.a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a-.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-a.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-.a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-.1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a-1.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-a1.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-1a.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-1.a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "-1.1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a+1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a+1." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+a1." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+1a." }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+1.a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a+.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+a.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+.a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+.1a" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "a+1.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+a1.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+1a.1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+1.a1" }));
		assertFalse(FloatUtils.isAllSafeFloat(new String[] { "+1.1a" }));
	}

	@Test
	@DisplayName("Float values")
	public void testParseFloat()
	{
		assertEquals(FloatUtils.parseFloat("123"),		123f);
		assertEquals(FloatUtils.parseFloat("123."),		123f);
		assertEquals(FloatUtils.parseFloat(".123"),		.123f);
		assertEquals(FloatUtils.parseFloat("123.123"),	123.123f);
		assertEquals(FloatUtils.parseFloat("-123"),		-123f);
		assertEquals(FloatUtils.parseFloat("-123."),	-123f);
		assertEquals(FloatUtils.parseFloat("-.123"),	-.123f);
		assertEquals(FloatUtils.parseFloat("-123.123"),	-123.123f);
		assertEquals(FloatUtils.parseFloat("123"),		123f);
		assertEquals(FloatUtils.parseFloat("123."),		123f);
		assertEquals(FloatUtils.parseFloat(".123"),		.123f);
		assertEquals(FloatUtils.parseFloat("123.123"),	123.123f);
		assertEquals(FloatUtils.parseFloat("-123"),		-123f);
		assertEquals(FloatUtils.parseFloat("-123."),	-123f);
		assertEquals(FloatUtils.parseFloat("-.123"),	-.123f);
		assertEquals(FloatUtils.parseFloat("-123.123"),	-123.123f);

		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("123,"); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(",123"); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("123,123"); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-123,"); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-,123"); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-123,123"); });

		assertEquals(FloatUtils.parseFloat("123,",		0f), 0f);
		assertEquals(FloatUtils.parseFloat(",123",		0f), 0f);
		assertEquals(FloatUtils.parseFloat("123,123",	0f), 0f);
		assertEquals(FloatUtils.parseFloat("-123,",		0f), 0f);
		assertEquals(FloatUtils.parseFloat("-,123",		0f), 0f);
		assertEquals(FloatUtils.parseFloat("-123,123",	0f), 0f);

		assertEquals(FloatUtils.parseFloat("123",		FloatUtils.DECIMAL_ANY_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("123.",		FloatUtils.DECIMAL_ANY_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat(".123",		FloatUtils.DECIMAL_ANY_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("123.123",	FloatUtils.DECIMAL_ANY_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("+123",		FloatUtils.DECIMAL_ANY_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("+123.",		FloatUtils.DECIMAL_ANY_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat("+.123",		FloatUtils.DECIMAL_ANY_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("+123.123",	FloatUtils.DECIMAL_ANY_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("-123",		FloatUtils.DECIMAL_ANY_TYPE),	-123f);
		assertEquals(FloatUtils.parseFloat("-123.",		FloatUtils.DECIMAL_ANY_TYPE),	-123.f);
		assertEquals(FloatUtils.parseFloat("-.123",		FloatUtils.DECIMAL_ANY_TYPE),	-.123f);
		assertEquals(FloatUtils.parseFloat("-123.123",	FloatUtils.DECIMAL_ANY_TYPE),	-123.123f);
		assertEquals(FloatUtils.parseFloat("123",		FloatUtils.DECIMAL_ANY_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("123,",		FloatUtils.DECIMAL_ANY_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat(",123",		FloatUtils.DECIMAL_ANY_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("123,123",	FloatUtils.DECIMAL_ANY_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("+123",		FloatUtils.DECIMAL_ANY_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("+123,",		FloatUtils.DECIMAL_ANY_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat("+,123",		FloatUtils.DECIMAL_ANY_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("+123,123",	FloatUtils.DECIMAL_ANY_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("-123",		FloatUtils.DECIMAL_ANY_TYPE),	-123f);
		assertEquals(FloatUtils.parseFloat("-123,",		FloatUtils.DECIMAL_ANY_TYPE),	-123.f);
		assertEquals(FloatUtils.parseFloat("-,123",		FloatUtils.DECIMAL_ANY_TYPE),	-.123f);
		assertEquals(FloatUtils.parseFloat("-123,123",	FloatUtils.DECIMAL_ANY_TYPE),	-123.123f);
		assertEquals(FloatUtils.parseFloat("123",		FloatUtils.DECIMAL_DOT_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("123.",		FloatUtils.DECIMAL_DOT_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat(".123",		FloatUtils.DECIMAL_DOT_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("123.123",	FloatUtils.DECIMAL_DOT_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("+123",		FloatUtils.DECIMAL_DOT_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("+123.",		FloatUtils.DECIMAL_DOT_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat("+.123",		FloatUtils.DECIMAL_DOT_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("+123.123",	FloatUtils.DECIMAL_DOT_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("-123",		FloatUtils.DECIMAL_DOT_TYPE),	-123f);
		assertEquals(FloatUtils.parseFloat("-123.",		FloatUtils.DECIMAL_DOT_TYPE),	-123.f);
		assertEquals(FloatUtils.parseFloat("-.123",		FloatUtils.DECIMAL_DOT_TYPE),	-.123f);
		assertEquals(FloatUtils.parseFloat("-123.123",	FloatUtils.DECIMAL_DOT_TYPE),	-123.123f);
		assertEquals(FloatUtils.parseFloat("123",		FloatUtils.DECIMAL_COMMA_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("123,",		FloatUtils.DECIMAL_COMMA_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat(",123",		FloatUtils.DECIMAL_COMMA_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("123,123",	FloatUtils.DECIMAL_COMMA_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("+123",		FloatUtils.DECIMAL_COMMA_TYPE),	123f);
		assertEquals(FloatUtils.parseFloat("+123,",		FloatUtils.DECIMAL_COMMA_TYPE),	123.f);
		assertEquals(FloatUtils.parseFloat("+,123",		FloatUtils.DECIMAL_COMMA_TYPE),	.123f);
		assertEquals(FloatUtils.parseFloat("+123,123",	FloatUtils.DECIMAL_COMMA_TYPE),	123.123f);
		assertEquals(FloatUtils.parseFloat("-123",		FloatUtils.DECIMAL_COMMA_TYPE),	-123f);
		assertEquals(FloatUtils.parseFloat("-123,",		FloatUtils.DECIMAL_COMMA_TYPE),	-123.f);
		assertEquals(FloatUtils.parseFloat("-,123",		FloatUtils.DECIMAL_COMMA_TYPE),	-.123f);
		assertEquals(FloatUtils.parseFloat("-123,123",	FloatUtils.DECIMAL_COMMA_TYPE),	-123.123f);

		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("123.",		FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(".123",		FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("123.123",	FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("+123.",		FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("+.123",		FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("+123.123",	FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-123.",		FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-.123",		FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-123.123",	FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("123,",		FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(",123",		FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("123,123",	FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("+123,",		FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("+,123",		FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("+123,123",	FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-123,",		FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-,123",		FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("-123,123",	FloatUtils.DECIMAL_DOT_TYPE); });
	}

	@Test
	@DisplayName("Float values")
	public void testFloatValues()
	{
		FloatParser parser = new FloatParser();

		Object[][] parametersTest = new Object[][] {
			{ "123",		FloatUtils.DECIMAL_ANY_TYPE,	false,	true,	false,	"123",		3,	123f },
			{ "123.",		FloatUtils.DECIMAL_ANY_TYPE,	false,	true,	false,	"123.",		3,	123f },
			{ ".123",		FloatUtils.DECIMAL_ANY_TYPE,	false,	true,	false,	".123",		3,	.123f },
			{ "123.123",	FloatUtils.DECIMAL_ANY_TYPE,	false,	true,	false,	"123.123",	6,	123.123f },
			{ "-123",		FloatUtils.DECIMAL_ANY_TYPE,	false,	false,	true,	"123",		3,	-123f },
			{ "-123.",		FloatUtils.DECIMAL_ANY_TYPE,	false,	false,	true,	"123.",		3,	-123f },
			{ "-.123",		FloatUtils.DECIMAL_ANY_TYPE,	false,	false,	true,	".123",		3,	-.123f },
			{ "-123.123",	FloatUtils.DECIMAL_ANY_TYPE,	false,	false,	true,	"123.123",	6,	-123.123f },
			{ "123",		FloatUtils.DECIMAL_DOT_TYPE,	false,	true,	false,	"123",		3,	123f },
			{ "123.",		FloatUtils.DECIMAL_DOT_TYPE,	false,	true,	false,	"123.",		3,	123f },
			{ ".123",		FloatUtils.DECIMAL_DOT_TYPE,	false,	true,	false,	".123",		3,	.123f },
			{ "123.123",	FloatUtils.DECIMAL_DOT_TYPE,	false,	true,	false,	"123.123",	6,	123.123f },
			{ "-123",		FloatUtils.DECIMAL_DOT_TYPE,	false,	false,	true,	"123",		3,	-123f },
			{ "-123.",		FloatUtils.DECIMAL_DOT_TYPE,	false,	false,	true,	"123.",		3,	-123f },
			{ "-.123",		FloatUtils.DECIMAL_DOT_TYPE,	false,	false,	true,	".123",		3,	-.123f },
			{ "-123.123",	FloatUtils.DECIMAL_DOT_TYPE,	false,	false,	true,	"123.123",	6,	-123.123f },
			{ "123",		FloatUtils.DECIMAL_COMMA_TYPE,	false,	true,	false,	"123",		3,	123f },
			{ "123,",		FloatUtils.DECIMAL_COMMA_TYPE,	false,	true,	false,	"123,",		3,	123f },
			{ ",123",		FloatUtils.DECIMAL_COMMA_TYPE,	false,	true,	false,	",123",		3,	.123f },
			{ "123,123",	FloatUtils.DECIMAL_COMMA_TYPE,	false,	true,	false,	"123,123",	6,	123.123f },
			{ "-123",		FloatUtils.DECIMAL_COMMA_TYPE,	false,	false,	true,	"123",		3,	-123f },
			{ "-123,",		FloatUtils.DECIMAL_COMMA_TYPE,	false,	false,	true,	"123,",		3,	-123f },
			{ "-,123",		FloatUtils.DECIMAL_COMMA_TYPE,	false,	false,	true,	",123",		3,	-.123f },
			{ "-123,123",	FloatUtils.DECIMAL_COMMA_TYPE,	false,	false,	true,	"123,123",	6,	-123.123f },
		};

		for (Object[] parameters : parametersTest)
		{
			float floatParsed = FloatUtils.parseFloat((String) parameters[0], (int) parameters[1], parser);
			assertEquals(parser.isExpression(), parameters[2]);
			assertEquals(parser.isPositive(), parameters[3]);
			assertEquals(parser.isNegative(), parameters[4]);
			assertEquals(parser.getValue(), parameters[5]);
			assertEquals(parser.getPrecision(), parameters[6]);
			assertNull(parser.getExpoent());
			assertEquals(parser.parseFloat(), parameters[7]);
			assertEquals(floatParsed, parameters[7]);
		}

		Object[][] throwsParametersTest = new Object[][] {
			{ "1234567",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1234567.",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ ".1234567",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1234.567",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "-1234567",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "-1234567.",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "-.1234567",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "-1234.567",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
		};

		for (Object[] parameters : throwsParametersTest)
		{
			assertThrows(NumberUtilsRuntimeException.class, () ->
			{
				FloatUtils.parseFloat((String) parameters[0], (int) parameters[1], parser);
				assertEquals(parser.getPrecision(), parameters[2]);
				parser.parseFloat();
			});
		}
	}

	@Test
	@DisplayName("Float expressions")
	public void testFloatExpressions()
	{
		FloatParser parser = new FloatParser();

		Object[][] parametersTest = new Object[][] {
			{ "1e0",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		1,	0,	1f },
			{ "1e+0",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		1,	0,	1f },
			{ "1e-0",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		1,	0,	1f },
			{ "1e5",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		6,	5,	100000f },
			{ "1e+5",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		6,	5,	100000f },
			{ "1e-5",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		6,	5,	.00001f },
			{ "1.0e0",		FloatUtils.DECIMAL_DOT_TYPE,	true,	true,	false,	"1.0",		1,	0,	1f },
			{ "1.0e+0",		FloatUtils.DECIMAL_DOT_TYPE,	true,	true,	false,	"1.0",		1,	0,	1f },
			{ "1.0e-0",		FloatUtils.DECIMAL_DOT_TYPE,	true,	true,	false,	"1.0",		1,	0,	1f },
			{ "1.0e5",		FloatUtils.DECIMAL_DOT_TYPE,	true,	true,	false,	"1.0",		6,	5,	100000f },
			{ "1.0e+5",		FloatUtils.DECIMAL_DOT_TYPE,	true,	true,	false,	"1.0",		6,	5,	100000f },
			{ "1.0e-5",		FloatUtils.DECIMAL_DOT_TYPE,	true,	true,	false,	"1.0",		6,	5,	.00001f },
			{ "1,0e0",		FloatUtils.DECIMAL_COMMA_TYPE,	true,	true,	false,	"1,0",		1,	0,	1f },
			{ "1,0e+0",		FloatUtils.DECIMAL_COMMA_TYPE,	true,	true,	false,	"1,0",		1,	0,	1f },
			{ "1,0e-0",		FloatUtils.DECIMAL_COMMA_TYPE,	true,	true,	false,	"1,0",		1,	0,	1f },
			{ "1,0e5",		FloatUtils.DECIMAL_COMMA_TYPE,	true,	true,	false,	"1,0",		6,	5,	100000f },
			{ "1,0e+5",		FloatUtils.DECIMAL_COMMA_TYPE,	true,	true,	false,	"1,0",		6,	5,	100000f },
			{ "1,0e-5",		FloatUtils.DECIMAL_COMMA_TYPE,	true,	true,	false,	"1,0",		6,	5,	.00001f },
			{ "123456e0",	FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"123456",	6,	0,	123456f },
			{ "12345e1",	FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"12345",	6,	1,	123450f },
			{ "1234e2",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1234",		6,	2,	123400f },
			{ "123e3",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"123",		6,	3,	123000f },
			{ "12e4",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"12",		6,	4,	120000f },
			{ "1e5",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		6,	5,	100000f },
			{ "123456e-0",	FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"123456",	6,	0,	123456f },
			{ "12345e-1",	FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"12345",	6,	1,	1234.5f },
			{ "1234e-2",	FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1234",		6,	2,	12.340f },
			{ "123e-3",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"123",		6,	3,	.12300f },
			{ "12e-4",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"12",		6,	4,	.00120f },
			{ "1e-5",		FloatUtils.DECIMAL_ANY_TYPE,	true,	true,	false,	"1",		6,	5,	.00001f },
		};

		for (Object[] parameters : parametersTest)
		{
			float floatParsed = FloatUtils.parseFloat((String) parameters[0], (int) parameters[1], parser);
			assertEquals(parser.isExpression(), parameters[2]);
			assertEquals(parser.isPositive(), parameters[3]);
			assertEquals(parser.isNegative(), parameters[4]);
			assertEquals(parser.getValue(), parameters[5]);
			assertEquals(parser.getPrecision(), parameters[6]);
			assertEquals(parser.getExpoent(), parameters[7]);
			assertEquals(parser.parseFloat(), parameters[8]);
			assertEquals(floatParsed, parameters[8]);
		}

		Object[][] throwsParametersTest = new Object[][] {
			{ "1e6",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1e+6",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1e-6",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "12e5",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "12e+5",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "12e-5",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "123e4",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "123e+4",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "123e-4",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1234e3",		FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1234e+3",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "1234e-3",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "12345e2",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "12345e+2",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "12345e-2",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "123456e1",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "123456e+1",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
			{ "123456e-1",	FloatUtils.DECIMAL_ANY_TYPE,	7 },
		};

		for (Object[] parameters : throwsParametersTest)
		{
			assertThrows(NumberUtilsRuntimeException.class, () ->
			{
				FloatUtils.parseFloat((String) parameters[0], (int) parameters[1], parser);
				assertEquals(parser.getPrecision(), parameters[2]);
				parser.parseFloat();
			});
		}

		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("ae0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("a1e0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1ae0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1e0,", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(",1e0", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1,1e0", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1.e0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(".1e0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1.1e0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("ae+0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("a1e+0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1ae+0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1e+0,", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(",1e+0", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1,1e+0", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1.e+0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(".1e+0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1.1e+0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("ae-0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("a1e-0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1ae-0", FloatUtils.DECIMAL_ANY_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1e-0,", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(",1e-0", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1,1e-0", FloatUtils.DECIMAL_DOT_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1.e-0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat(".1e-0", FloatUtils.DECIMAL_COMMA_TYPE); });
		assertThrows(NumberUtilsRuntimeException.class, () -> { FloatUtils.parseFloat("1.1e-0", FloatUtils.DECIMAL_COMMA_TYPE); });
	}

	@Test
	@DisplayName("Cap min float value")
	public void testCapMin()
	{
		assertEquals(5, FloatUtils.capMin(4f, 5f));
		assertEquals(5, FloatUtils.capMin(5f, 5f));
		assertEquals(6, FloatUtils.capMin(6f, 5f));

		assertEquals(-4, FloatUtils.capMin(-4f, -5f));
		assertEquals(-5, FloatUtils.capMin(-5f, -5f));
		assertEquals(-5, FloatUtils.capMin(-6f, -5f));
	}

	@Test
	@DisplayName("Cap max float value")
	public void testCapMax()
	{
		assertEquals(5, FloatUtils.capMin(4f, 5f));
		assertEquals(5, FloatUtils.capMin(5f, 5f));
		assertEquals(6, FloatUtils.capMin(6f, 5f));

		assertEquals(-4, FloatUtils.capMin(-4f, -5f));
		assertEquals(-5, FloatUtils.capMin(-5f, -5f));
		assertEquals(-5, FloatUtils.capMin(-6f, -5f));
	}

	@Test
	@DisplayName("Cap min and max float value")
	public void testCap()
	{
		assertEquals(5f, FloatUtils.cap(4f, 5f, 10f));
		assertEquals(5f, FloatUtils.cap(5f, 5f, 10f));
		assertEquals(6f, FloatUtils.cap(6f, 5f, 10f));
		assertEquals(9f, FloatUtils.cap(9f, 5f, 10f));
		assertEquals(10f, FloatUtils.cap(10f, 5f, 10f));
		assertEquals(10f, FloatUtils.cap(11f, 5f, 10f));

		assertEquals(-10f, FloatUtils.cap(-11f, -10f, -5f));
		assertEquals(-10f, FloatUtils.cap(-10f, -10f, -5f));
		assertEquals(-9f, FloatUtils.cap(-9f, -10f, -5f));
		assertEquals(-6f, FloatUtils.cap(-6f, -10f, -5f));
		assertEquals(-5f, FloatUtils.cap(-5f, -10f, -5f));
		assertEquals(-5f, FloatUtils.cap(-4f, -10f, -5f));
	}

	@Test
	@DisplayName("Has min float value")
	public void testHasMin()
	{
		assertFalse(FloatUtils.hasMin(4f, 5f));
		assertTrue(FloatUtils.hasMin(5f, 5f));
		assertTrue(FloatUtils.hasMin(6f, 5f));

		assertTrue(FloatUtils.hasMin(-4f, -5f));
		assertTrue(FloatUtils.hasMin(-5f, -5f));
		assertFalse(FloatUtils.hasMin(-6f, -5f));
	}

	@Test
	@DisplayName("Has max float value")
	public void testHasMax()
	{
		assertTrue(FloatUtils.hasMax(4f, 5f));
		assertTrue(FloatUtils.hasMax(5f, 5f));
		assertFalse(FloatUtils.hasMax(6f, 5f));

		assertFalse(FloatUtils.hasMax(-4f, -5f));
		assertTrue(FloatUtils.hasMax(-5f, -5f));
		assertTrue(FloatUtils.hasMax(-6f, -5f));
	}

	@Test
	@DisplayName("Has range float value")
	public void testHasBetween()
	{
		assertFalse(FloatUtils.hasBetween(4f, 5, 10));
		assertTrue(FloatUtils.hasBetween(5f, 5, 10));
		assertTrue(FloatUtils.hasBetween(6f, 5, 10));
		assertTrue(FloatUtils.hasBetween(9f, 5, 10));
		assertTrue(FloatUtils.hasBetween(10f, 5, 10));
		assertFalse(FloatUtils.hasBetween(11f, 5, 10));

		assertFalse(FloatUtils.hasBetween(-11f, -10f, -5f));
		assertTrue(FloatUtils.hasBetween(-10f, -10f, -5f));
		assertTrue(FloatUtils.hasBetween(-9f, -10f, -5f));
		assertTrue(FloatUtils.hasBetween(-6f, -10f, -5f));
		assertTrue(FloatUtils.hasBetween(-5f, -10f, -5f));
		assertFalse(FloatUtils.hasBetween(-4f, -10f, -5f));
	}
}
