package org.diverproject.scarlet.util;

import static org.diverproject.scarlet.util.language.ArrayUtilsLanguage.SUB_ARRAY_LENGTH_INVALID;
import static org.diverproject.scarlet.util.language.ArrayUtilsLanguage.SUB_ARRAY_NULL;
import static org.diverproject.scarlet.util.language.ArrayUtilsLanguage.SUB_ARRAY_OFFSET_INVALID;

import org.diverproject.scarlet.util.exceptions.ArrayUtilsRuntimeException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayUtils
{
	public static final int MIN_SUB_ARRAY_LENGTH = 1;
	public static final String DEFAULT_JOIN_SEPARATOR = ", ";

	public static <T> String join(T... elements)
	{
		return ArrayUtils.join(Arrays.asList(elements).iterator());
	}

	public static <T> String join(String separator, T... elements)
	{
		return ArrayUtils.join( Arrays.asList(elements).iterator(), separator);
	}

	public static <T> String join(Iterator<T> iterator)
	{
		return ArrayUtils.join(iterator, DEFAULT_JOIN_SEPARATOR);
	}

	public static <T> String join(Iterator<T> iterator, String separator)
	{
		StringBuilder stringBuilder = new StringBuilder();

		while (iterator.hasNext())
		{
			T element = iterator.next();
			stringBuilder.append(element == null ? "null" : element.toString());
			stringBuilder.append(separator);
		}

		String joined = stringBuilder.toString();

		return joined.isEmpty() ? joined : StringUtils.substr(joined, 0, -separator.length());
	}

	public static <T> boolean inIterator(Class<T> clazz, T item, Iterator<T> iterator)
	{
		while (iterator.hasNext())
		{
			T next = iterator.next();

			if (item == null && next == null || item != null && item.equals(next))
				return true;
		}

		return false;
	}

	public static <T> boolean in(T item, T... items)
	{
		for (T item2 : items)
			if (item == null && item2 == null || item != null && item.equals(item2))
				return true;

		return false;
	}

	public static <T> boolean hasArrayIndex(T[] array, int index)
	{
		return index >= 0 && index < array.length;
	}

	public static Byte[] primitiveArrayToObject(byte... array)
	{
		Byte[] newArray = new Byte[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	public static Short[] primitiveArrayToObject(short... array)
	{
		Short[] newArray = new Short[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	public static Integer[] primitiveArrayToObject(int... array)
	{
		Integer[] newArray = new Integer[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	public static Long[] primitiveArrayToObject(long... array)
	{
		Long[] newArray = new Long[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	public static Float[] primitiveArrayToObject(float... array)
	{
		Float[] newArray = new Float[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	public static Double[] primitiveArrayToObject(double... array)
	{
		Double[] newArray = new Double[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	public static Character[] primitiveArrayToObject(char... array)
	{
		Character[] newArray = new Character[array.length];

		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];

		return newArray;
	}

	private static int validateSubArray(int offset, int length, int arrayLength)
	{
		if (length < MIN_SUB_ARRAY_LENGTH)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_LENGTH_INVALID);

		if (offset + length > arrayLength)
			length = arrayLength - offset;

		return length;
	}

	public static <T> T[] subArray(T[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (!hasArrayIndex(array, offset))
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		@SuppressWarnings("unchecked")
		T[] sub = (T[]) Array.newInstance(array.getClass().getComponentType(), length);

		if (length >= 0)
			System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static char[] subArray(char[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		char[] sub = new char[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static byte[] subArray(byte[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		byte[] sub = new byte[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static short[] subArray(short[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		short[] sub = new short[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static int[] subArray(int[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		int[] sub = new int[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static long[] subArray(long[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		long[] sub = new long[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static float[] subArray(float[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		float[] sub = new float[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static double[] subArray(double[] array, int offset, int length)
	{
		if (array == null)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_NULL);

		if (offset < 0 || offset >= array.length)
			throw new ArrayUtilsRuntimeException(SUB_ARRAY_OFFSET_INVALID);

		length = validateSubArray(offset, length, array.length);

		double[] sub = new double[length];

		System.arraycopy(array, offset, sub, 0, length);

		return sub;
	}

	public static <D>  D[] reallocate(D[] array, int length)
	{
		@SuppressWarnings("unchecked")
		D[] newArray = (D[]) Array.newInstance(array.getClass().getComponentType(), length);
		copy(array, newArray);

		return newArray;
	}

	public static byte[] reallocate(byte[] array, int length)
	{
		byte[] newArray = new byte[length];
		copy(array, newArray);

		return newArray;
	}

	public static short[] reallocate(short[] array, int length)
	{
		short[] newArray = new short[length];
		copy(array, newArray);

		return newArray;
	}

	public static int[] reallocate(int[] array, int length)
	{
		int[] newArray = new int[length];
		copy(array, newArray);

		return newArray;
	}

	public static long[] reallocate(long[] array, int length)
	{
		long[] newArray = new long[length];
		copy(array, newArray);

		return newArray;
	}

	public static float[] reallocate(float[] array, int length)
	{
		float[] newArray = new float[length];
		copy(array, newArray);

		return newArray;
	}

	public static double[] reallocate(double[] array, int length)
	{
		double[] newArray = new double[length];
		copy(array, newArray);

		return newArray;
	}

	public static char[] reallocate(char[] array, int length)
	{
		char[] newArray = new char[length];
		copy(array, newArray);

		return newArray;
	}

	public static boolean[] reallocate(boolean[] array, int length)
	{
		boolean[] newArray = new boolean[length];
		copy(array, newArray);

		return newArray;
	}

	public static <T> boolean contains(T[] items, T value)
	{
		for (T item : items)
			if (item.equals(value))
				return true;

		return false;
	}

	public static <D> void copy(D[] source, D[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(byte[] source, byte[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(short[] source, short[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(int[] source, int[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(long[] source, long[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(float[] source, float[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(double[] source, double[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(boolean[] source, boolean[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}

	public static void copy(char[] source, char[] destination)
	{
		for (int i = 0; i < source.length && i < destination.length; i++)
			destination[i] = source[i];
	}
}
