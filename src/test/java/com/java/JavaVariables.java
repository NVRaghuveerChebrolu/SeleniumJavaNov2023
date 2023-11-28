package com.java;

public class JavaVariables {
	int a=9; //variables declared inside a class but outside a method is called as Instance Variables
	String str = "learning";
	
	static char c='a';  //static variables declared with help of static keyword
	
	public static void display() {
		System.out.println("inside print method");
	}
	
	public int Sum(int c, int d) {  //variables declared inside a method is called local variables.
		return c+d;
	}
	
	public static void main(String[] args) {
		JavaVariables obj = new JavaVariables();
		System.out.println(obj.a);
		System.out.println(obj.Sum(7,8));
		System.out.println(obj.str);
		System.out.println(c);
		display();
	}

}
