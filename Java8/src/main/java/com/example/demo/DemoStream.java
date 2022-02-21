package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class DemoStream {

	public static void main(String[] args) {
		
		List<Integer> numbers =Arrays.asList(1,5,9,2,10,3,12,8,7);
		
		numbers.stream().forEach(i -> System.out.print(i));
		
		System.out.println("---------parallel stream---------");
		
		numbers.parallelStream().forEachOrdered(i -> System.out.print(i));
	}
}
