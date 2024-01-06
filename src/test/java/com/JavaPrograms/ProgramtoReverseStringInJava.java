package com.JavaPrograms;

public class ProgramtoReverseStringInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "LearningJava";
		//Expected output : avaJgninraeL
		char ch[]=str.toCharArray();//step 1
		System.out.println(ch[3]);
		int length=str.length();
		System.out.println(length);
		for (int i=length-1;i>=0;i--){//step 2
			System.out.print(ch[i]);//step3
		}

	}

}
