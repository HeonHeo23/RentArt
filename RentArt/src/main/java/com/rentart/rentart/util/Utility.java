package com.rentart.rentart.util;

import java.util.HashMap;
import java.util.Map;


public class Utility {
	
	public static int[][] filterMapper(Map<Integer, int[]> map, int[] array){
		int[][] result = new int[array.length][];
		
		for(int i = 0; i<array.length; i++)
			result[i] = map.get(array[i]);
		return result;
		
	}
	
	public static String themeMapper(int input) {
		Map<Integer, String> map = new HashMap<Integer, String>(){{
			put(1, "인물");
			put(2, "추상");
			put(3, "풍경");
			put(4, "정물");
		}};
		
		String result = map.get(input);
		return result;
	}
	
	public static int rentPriceMapper(int size) {
		int number = (int) Math.floor(size);
		if(number <= 10)
			return 39000;
		else if (number <= 20)
			return 69000;
		else if (number <= 30)
			return 99000;
		else if (number <= 40)
			return 120000;
		else if (number <= 60)
			return 150000;
		else if (number <= 80)
			return 200000;
		else if (number <= 100)
			return 250000;
		else
			return 300000;
	}
}
