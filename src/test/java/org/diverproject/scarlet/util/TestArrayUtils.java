package org.diverproject.scarlet.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.diverproject.scarlet.util.ArrayUtils;
import org.diverproject.scarlet.util.exceptions.ArrayUtilsRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Array Utils")
public class TestArrayUtils
{
	@Test
	@DisplayName("Join")
	public void testJoin()
	{
		String[] items = new String[] { "a", "b", "c", "d", "e" };

		assertEquals(ArrayUtils.join(items), "a, b, c, d, e");
		assertEquals(ArrayUtils.join(";", items), "a;b;c;d;e");
		assertEquals(ArrayUtils.join(Arrays.asList(items).iterator()), "a, b, c, d, e");
		assertEquals(ArrayUtils.join(Arrays.asList(items).iterator(), ";"), "a;b;c;d;e");
	}

	@Test
	@DisplayName("In array")
	public void testIn()
	{
		String[] items = new String[] { "a", "b", "c", "d", "e" };

		assertTrue(ArrayUtils.in("a", items));
		assertTrue(ArrayUtils.in("b", items));
		assertTrue(ArrayUtils.in("c", items));
		assertTrue(ArrayUtils.in("d", items));
		assertTrue(ArrayUtils.in("e", items));
		assertFalse(ArrayUtils.in("f", items));
	}

	@Test
	@DisplayName("Has index")
	public void testHasIndex()
	{
		String[] items = new String[] { "a", "b" };

		assertFalse(ArrayUtils.hasArrayIndex(items, -1));
		assertTrue(ArrayUtils.hasArrayIndex(items, 0));
		assertTrue(ArrayUtils.hasArrayIndex(items, 1));
		assertFalse(ArrayUtils.hasArrayIndex(items, 2));
	}

	@Test
	@DisplayName("Sub array (generic)")
	public void testSubArrayGeneric()
	{
		String[] array = new String[] { "a", "b", "c", "d", "e" };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new String[] { "a" });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new String[] { "a", "b", "c" });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new String[] { "c" });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new String[] { "c", "d", "e" });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive char)")
	public void testSubArrayChar()
	{
		char[] array = new char[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new char[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new char[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new char[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new char[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive byte)")
	public void testSubArrayByte()
	{
		byte[] array = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new byte[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new byte[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new byte[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new byte[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive short)")
	public void testSubArrayShort()
	{
		short[] array = new short[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new short[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new short[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new short[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new short[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive int)")
	public void testSubArrayInt()
	{
		int[] array = new int[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new int[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new int[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new int[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new int[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive long)")
	public void testSubArrayLong()
	{
		long[] array = new long[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new long[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new long[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new long[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new long[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive float)")
	public void testSubArrayFloat()
	{
		float[] array = new float[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new float[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new float[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new float[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new float[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}

	@Test
	@DisplayName("Sub array (primitive double)")
	public void testSubArrayDouble()
	{
		double[] array = new double[] { 0x01, 0x02, 0x03, 0x04, 0x05 };

		assertArrayEquals(ArrayUtils.subArray(array, 0, 1), new double[] { 0x01 });
		assertArrayEquals(ArrayUtils.subArray(array, 0, 3), new double[] { 0x01, 0x02, 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 1), new double[] { 0x03 });
		assertArrayEquals(ArrayUtils.subArray(array, 2, 3), new double[] { 0x03, 0x04, 0x05 });

		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, -1, 1); });
		assertThrows(ArrayUtilsRuntimeException.class, () -> { ArrayUtils.subArray(array, 0, 0); });
	}
}
