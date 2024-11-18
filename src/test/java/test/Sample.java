package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (test.Listeners.class)
public class Sample extends BaseTest{

	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test (timeOut = 1000)
	public void test2() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test2");
	}
	
	@Test (dependsOnMethods = "test2")
	public void test3() {
		System.out.println("Test3");
	}
	
	@Test
	public void test4() {
		System.out.println("Test4");
	}
	
}
