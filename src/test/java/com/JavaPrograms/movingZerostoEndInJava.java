package com.JavaPrograms;

import java.util.Arrays;

public class movingZerostoEndInJava {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 4, 5, 0, 7, 8, 0 };
		int n = arr.length;

		// Count the number of zeros in the array
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}

		// Create a new array to store the non-zero elements
		int[] newArr = new int[n - count];
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				newArr[j] = arr[i];
				j++;
			}
		}

		// Append the zeros to the end of the new array
		for (int i = n - count; i < n; i++) {
			newArr[i] = 0;
		}

		// Print out the new array
		System.out.println(Arrays.toString(newArr));
	}
}
