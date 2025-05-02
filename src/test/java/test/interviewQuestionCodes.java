package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.testng.annotations.Test;

public class interviewQuestionCodes {

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
		
		Scanner scanner = new Scanner(System.in);
		
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
		
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
			System.out.println((x>y) ? "x is larger than y" : "y is larger than x");
	
	}
	
	
	
}
