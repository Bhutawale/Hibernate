package com.controller;

import java.util.Scanner;

import com.service.Operation;

public class Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Operation op=new Operation();
		
		System.out.println("Hibernate one to one mapping");
		
		while(true)
		{
			System.out.println("1.pls insert the student information");
			System.out.println("2.pls show student information");
			System.out.println("3.pls update student information");
			System.out.println("4.pls delete student information");
			
			int ch=sc.nextInt();
			
			switch (ch)
			{
			case 1:op.insertData();
				
				break;
			case 2:op.showAll();
							
				break;
			case 3:op.update();
				
				break;
			case 4:op.delete();
				
				break;

			default:
				break;
			}
		}
		
	}

}
