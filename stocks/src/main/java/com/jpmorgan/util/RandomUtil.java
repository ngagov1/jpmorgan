package com.jpmorgan.util;

public class RandomUtil
{
	public static int randomWithRange(final int min, final int max)
	{
		final int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}
}
