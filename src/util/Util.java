package util;

import java.util.Random;

public class Util
{
	public static int random(int min, int max)
	{
		Random generator = new Random();
		
		return generator.nextInt(max) + min;
	}
	
	public static int max(int[] array)
	{
		int index = 0;
		
		for( int i = 0; i < array.length; i++ )
		{
			// TODO: > or >=? does it matter
			if( array[i] > array[index] )
			{
				index = i;
			}
		}
		
		return index;
	}
}
