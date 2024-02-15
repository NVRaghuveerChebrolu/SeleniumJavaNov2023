package com.AccessModifiers;

public class accessModifier_AccessingPublic {

	public static void main(String[] args) {
		accessModifier_Public obj = new accessModifier_Public();
		System.out.println(obj.b);
		obj.msg12345();
		//msg12345();
		obj.msg123456();
		//msg123456();
	}

}
