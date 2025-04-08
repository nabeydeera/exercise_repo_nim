package test;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class interviewQuestionCodes {

	@Test
	public void reverseList() {
		ArrayList<Integer> arrayNumbers = new ArrayList<>();
		arrayNumbers.add(10);
		arrayNumbers.add(20);
		arrayNumbers.add(30);
		arrayNumbers.add(40);
		System.out.println(arrayNumbers);
		
		Collections.reverse(arrayNumbers);
		
		System.out.println("Revered the list: "+arrayNumbers);
	}
	
}
