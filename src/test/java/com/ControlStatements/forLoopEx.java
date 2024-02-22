package com.ControlStatements;

public class forLoopEx {

	public static void main(String[] args) {
		char[] ch={'e','r','t','o','p'};
		char cha ='h';
		int[] intArr = {7,8,2,4,9,12};
		String[] strArr = {"I","am","Learning","Java"};
		// TODO Auto-generated method stub
		for(int i=1; i<=10;i++){
			System.out.println("The value of i: "+i);
		}
		for(char c:ch){
			System.out.println(c);
			if(c=='t'){
				System.out.println("i have identified character t");
				break;
			}
		}
		System.out.println("-----------------------------");
		for(int j=1 ; j<=ch.length;j++) {
			System.out.println(j);
			if(j=='t'){
				System.out.println("i have identified character t");
				break;
			}
		}
	}

}
