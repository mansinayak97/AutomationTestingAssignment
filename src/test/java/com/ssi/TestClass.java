package com.ssi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass {
	@Test(enabled=false)
	public static void A(){
		System.out.println("A");
	}
	@Test(enabled=false)
	public static void B(){
		System.out.println("B");
	}
	@Test(enabled=true)
	public void C(){
		SoftAssert softAssert=new SoftAssert();
		A();
		B();
		System.out.println("C");
		softAssert.assertEquals("C", "C");
		System.out.println("D");
		softAssert.assertEquals("D","D");
		softAssert.assertAll();
		//dependent fields m hard asset use krenge aur independent fields m soft assert use krenge
		
	}
}
