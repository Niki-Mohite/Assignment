package com.nikita.streams;

import java.util.stream.IntStream;

	public class OddNumberAfterHundred {
	    public static void main(String[] args) {
	        IntStream.iterate(101, n -> n + 2)
	                 .limit(50)
	                 .forEach(System.out::println);
	    }
	}



