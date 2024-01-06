package com.JavaPrograms;

public class FactorialUsingRecurssion {
	//if a method calls by itself , it is called recursion.
	static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

	public static void main(String args[]) {
		int i, fact = 1;
		int number = 7 ;// It is the number to calculate factorial
		//5 * 4 * 3 * 2 * 1 = 120
		fact = factorial(number);
		System.out.println("Factorial of " + number + " is: " + fact);
	}
}