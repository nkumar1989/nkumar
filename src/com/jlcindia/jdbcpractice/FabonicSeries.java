package com.jlcindia.jdbcpractice;
import java.util.*;
public class FabonicSeries {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		System.out.println("Enter the no of term:-");
		int term=kb.nextInt();
		int arr[]=new int[term];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<arr.length;i++){
			arr[i]=arr[i-1]+arr[i-2];
			
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
			
		}
	}

}
