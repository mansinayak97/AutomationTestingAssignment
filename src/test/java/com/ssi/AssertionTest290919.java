package com.ssi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest290919 {
	
	@Test(priority = 1, enabled = true)
	public static void A() {
		System.out.println("A");
	}
	
	@Test(priority = 1, enabled = true)
	public static void B() {
		System.out.println("B");
	}
	
	@Test(priority = 1, enabled = true)
	public void C() {		
		/*//ye hard assertion ka code h
		System.out.println("C");
		Assert.assertEquals(true, false);// ye assertion fail ho jayega to baad ka code execute nhi hoga, koshish rhe ki assertion humara sbse last me rhe
		System.out.println("A");
		*/
		
		
		//ye softAssert hai isme jb tk assertAll method call nhi hogi softAssert ke object pe tb tk assertion ke cases nhi chalenge.
		SoftAssert softAssert = new SoftAssert();
		System.out.println("C");
		softAssert.assertEquals(true, false, "----------test failed-------------");
		System.out.println("D");
		softAssert.assertAll();
	
		/* example Login click krne pr nya tab to khule,
		 *  but vo 1 error page ho ya dashboard ho,
		 *  ye depend krta hai credentials sahi h ya nhi.
		 *  so that to check that a new tab is opening or not we use softAssert here.  
		*/
	}
	

}
