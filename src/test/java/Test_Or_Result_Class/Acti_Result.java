package Test_Or_Result_Class;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Classes.Acti_Base;
import POM_Classes.Acti_HomePom;
import POM_Classes.Acti_Login_Pompage;
import Utility_Classes.Acti_Utility_Class;

public class Acti_Result extends Acti_Base {
	Acti_Base abs;
	Acti_Login_Pompage alp;
	Acti_HomePom ahp;
	
	@BeforeClass
	
	public void openBrowser() {
		Acti_Base abs = new Acti_Base();
		
		abs.initializeBrowser();
		
		 alp = new Acti_Login_Pompage(driver);
		 ahp =  new Acti_HomePom(driver);
	}
	
	@BeforeMethod
	
	public void openApp() throws Throwable {
		
		String username = Acti_Utility_Class.getTestDat(0, 0);
		alp.enterUN(username);
		
		String passward = Acti_Utility_Class.getTestDat(0, 1);
		
		alp.enterPWD(passward);
		
		alp.clickLogInBTN();
		
	}
	
	@Test
	
	public void verifyText() throws Throwable {
		String expText = Acti_Utility_Class.getTestDat(0, 2);
		
		String actText  = ahp.verifyText();
		
		Assert.assertEquals(actText, expText);
		
		
	}

}
