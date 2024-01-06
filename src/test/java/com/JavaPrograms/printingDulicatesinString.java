package com.JavaPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class printingDulicatesinString {

	public static void main(String[] args) {
		printingDulicatesinString obj = new printingDulicatesinString();
		obj.printDuplicateCharacters("Hi How are you doing");
		String s = new String("Hi How are you doing");
	}

	String str = "";

	public  void printDuplicateCharacters(String str) {
		char[] characters = str.toCharArray();
		// build HashMap with character and number of times they appear in
		// String
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (Character ch : characters) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}
		// Iterate through HashMap to print all duplicate characters of String
		
		System.out.printf("List of duplicate characters in String '%s' %n", str);
		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			if (entry.getValue() >1) {
				System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
			}
		}
	}

	 
}
