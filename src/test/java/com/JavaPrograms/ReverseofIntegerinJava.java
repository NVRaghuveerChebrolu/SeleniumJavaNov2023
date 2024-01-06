package com.JavaPrograms;

public class ReverseofIntegerinJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 987654, reverse = 0;
		while (number != 0) {
			int remainder = number % 10;//step 1
			reverse = reverse * 10 + remainder;//step 2
			number = number / 10;//step 3
		}
		System.out.println("The reverse of the given number is: " + reverse);
	}
}
