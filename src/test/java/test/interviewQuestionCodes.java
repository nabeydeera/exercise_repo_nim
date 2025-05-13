package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class interviewQuestionCodes {
	
	Scanner scanner = new Scanner(System.in);

	/*
	//print an array with reverse order
	@Test
	public void reverseList() {
		ArrayList<Integer> arrayNumbers = new ArrayList<>();
		arrayNumbers.add(10);
		arrayNumbers.add(30);
		arrayNumbers.add(20);
		arrayNumbers.add(15);
		System.out.println(arrayNumbers);
		
		Collections.reverse(arrayNumbers);
		
		System.out.println("Revered the list: "+arrayNumbers);
	}
	
	//Write a Java program that takes two numbers as input and displays the product of two numbers
	@Test
	public void productOfNumber() {
		System.out.println("----productOfNumber method----");
		int x = 4;
		int y = 15;
		System.out.println(x*y);
	}
	
	//Write a Java program that takes two numbers as input and checks the odd number
	@Test
	public void oddNumber() {
		System.out.println("----oddNumber method----");
		
		
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		String resultX = (x % 2 !=0) ? " Yes" : "No";
		System.out.println("Is x an odd number? "+resultX);
		String resultY = (y % 2 !=0) ? "Yes" : "No";
		System.out.println("Is y an odd number? "+resultY);
	}
	
	//Write a Java program that takes two numbers as input and checks the which is larger
	@Test
	public void largerNumber() {
		System.out.println("----largerNumber method----");
		
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
			System.out.println((x>y) ? "x is larger than y" : "y is larger than x");
	
	}
	*/
	
	//check the string has any duplicate characters
	 @Test
	 public void removeDuplicates() {
		 String word = scanner.next();
		 scanner.close();
		 String ch;
		 
		 ArrayList<String> noDuplicates = new ArrayList<>();
		//noDuplicates.add(""+word.charAt(0)); //T

		 for (int i = 0; i < word.length(); i++) {
			 
			 ch = ""+ word.charAt(i);
			 if (!noDuplicates.contains(ch)) {
					noDuplicates.add(ch);
				}
//
//			 for (int j = 0; j<noDuplicates.size(); j++) {	
//				 System.out.println("j: "+noDuplicates.get(j));
//				if (!ch.equalsIgnoreCase(noDuplicates.get(j))) {
//					noDuplicates.add(ch);
//					 System.out.println("2nd for loop"+noDuplicates);
//
//					break;
//				}
//			}
			
		}
		 System.out.println(noDuplicates);
		
			
		}
	 }
	

