package com.JavaPrograms;

public class PerformanceStringSndStringBuffer {
	public String concatWithString() {
		String t = "Java";
		for (int i = 0; i < 100000; i++) {
			t = t + "Tpoint";
		}
		return t;
	}

	public static String concatWithStringBuffer() {
		StringBuffer sb = new StringBuffer("Java");
		for (int i = 0; i < 100000; i++) {
			sb.append("Tpoint");
		}
		return sb.toString();
	}

	public static String concatWithStringBuilder() {
		StringBuilder sb2 = new StringBuilder("Java");
		for (int i = 0; i < 100000; i++) {
			sb2.append("Tpoint");
		}
		return sb2.toString();
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("startTime: "+ startTime);
		PerformanceStringSndStringBuffer StySb=new PerformanceStringSndStringBuffer();
		StySb.concatWithString();
		System.out.println("Time taken by Concating with String: " + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		concatWithStringBuffer();
		System.out.println(
				"Time taken by Concating with  StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		concatWithStringBuilder();
		System.out.println(
				"Time taken by Concating with  StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
	}
}