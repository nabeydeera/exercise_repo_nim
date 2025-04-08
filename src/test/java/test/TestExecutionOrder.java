package test;

import org.testng.annotations.Test;

public class TestExecutionOrder {

	//TCs with no priority or 0 set will be run alphabetical
	@Test
	public void openBrowser() {System.out.println("1st TC no prioriity");}
	
	@Test(priority = 0)
	public void getpayment() {System.out.println("2nd TC with prioriity 0");}
	
	@Test(priority = 1)
	public void closed() {System.out.println("3rd TC with prioriity 1");}
	
	@Test
	public void finalOption() {System.out.println("4th TC with no prioriity");}
	
	
}
