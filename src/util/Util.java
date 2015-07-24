package util;

import java.util.Random;

public class Util
{
	public static int random(int min, int max)
	{
		Random generator = new Random();
		
		return generator.nextInt(max) + min;
	}
}
