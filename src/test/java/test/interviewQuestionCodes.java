package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.testng.annotations.Test;

public class interviewQuestionCodes {
	
	Scanner scanner = new Scanner(System.in);

	
	//print an array with reverse order
	@Test
	public void reverseList() {
		System.out.println("----Array list reverse numbers method----");
		ArrayList<Integer> arrayNumbers = new ArrayList<>();
		arrayNumbers.add(10);
		arrayNumbers.add(30);
		arrayNumbers.add(10);
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
		}
		 System.out.println(noDuplicates);
		
			
		}
	 
	 @Test
	 public void hashSetRemoveDuplicates() {
		 String word = "bainana";
		 System.out.println(duplicatesRemoved(word));
	 }

	private static Set<String> duplicatesRemoved(String word) {
		Set<String> uniqueChar = new LinkedHashSet<String>();
		for(char c: word.toCharArray()) {
			uniqueChar.add(""+c);
		}
		//if we need to print the word without the array, use the StringBuilder and append and convert toString to return a String
//		StringBuilder result = new StringBuilder();
//		for(char c:uniqueChar) {
//			result.append(c);
//		}
//		return result.toString();
		return uniqueChar;
	}
	 
	//printing fibonacci - 1 way of coding
	@Test
	public void printFibonacci1() {
		int n1 = 0;
		int n2 = 1;
		int n3;
		int count = 10;
		
		System.out.print(n1+", "+n2);
		for(int i=1; i<count-1; i++) {
			n3 = n1+n2;
			System.out.print(", "+n3);
			n1=n2;
			n2=n3;
		}
	}
	
	//printing fibonacci - 2nd way of coding
	@Test
	public void printFibonacci2() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + (i < count - 1 ? ", " : ""));
        }
	}
        
        
    public static int fibonacci(int n) {
	        if (n <= 1) {
	            return n;
	        }
	        return fibonacci(n - 1) + fibonacci(n - 2);
	    }

}
	

