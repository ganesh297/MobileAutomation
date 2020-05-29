package com.selenium.practice;

import java.util.ArrayList;
import java.util.List;

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Rule1data1={40,50,10,30,20,5};
		
		int[] Rule1data2={40,50,10};

		int[] Rule1data3={40};

		
        rules(Rule1data1,Rule1data2,Rule1data3,1);
	
	}



public static void rules(int a[], int b[], int c[],int ruleNum){
	
	for(int i=0;i<a.length;i++){
		System.out.println(a[i]);
		
	}
	
	System.out.println("**************");
	for(int i=0;i<b.length;i++){
		System.out.println(b[i]);
		
	}
	System.out.println("**************");
	for(int i=0;i<c.length;i++){
		System.out.println(c[i]);
		
	}
}


}