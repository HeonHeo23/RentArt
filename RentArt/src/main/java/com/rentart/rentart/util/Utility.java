package com.rentart.rentart.util;

import java.util.Map;

public class Utility {
	public static int[][] filterMapper(Map<Integer, int[]> map, int[] array){
		int[][] result = new int[array.length][];
		
		for(int i = 0; i<array.length; i++)
			result[i] = map.get(array[i]);
		
		return result;
		
	}
}
