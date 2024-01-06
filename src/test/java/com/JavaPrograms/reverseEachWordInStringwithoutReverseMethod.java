package com.JavaPrograms;

public class reverseEachWordInStringwithoutReverseMethod {

	private static Object StringFormatter;

	public static void main(String[] args) {
		String str="Hi How are you doing?";
		String []words=str.split("\\s");
		String ReverseString="";
//		System.out.println(words[0]);
//		System.out.println(words[1]);
//		System.out.println(words[2]);
//		System.out.println(words[3]);
//		System.out.println(words[4]);
		
		int count =words.length;
		System.out.println(count);
		
		for (int i=count-1 ; i>=0;i--){
	//	for (int i=0 ; i<count;i++){
			String word =words[i];
			String RevWord="";
			for (int j= word.length()-1; j>=0;j--){
				RevWord=RevWord+word.charAt(j);
			}
			//System.out.println(RevWord);
			ReverseString=ReverseString+RevWord+ " ";
		//	System.out.println(ReverseString);
		}
		System.out.println("input: "+str);
		System.out.println("output: "+ReverseString);
	
	}

}
