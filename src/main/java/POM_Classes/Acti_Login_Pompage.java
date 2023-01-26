package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Acti_Login_Pompage {
	@FindBy(xpath="//input[@id='username']") private WebElement UN;
	@FindBy(xpath="//input[@type='password']") private WebElement PWD;
	@FindBy(xpath="//div[text()='Login ']") private WebElement LogInBTN;
	
	public Acti_Login_Pompage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterUN(String username) {
		UN.sendKeys(username);	
	}
	
public void enterPWD(String passward) {	
		PWD.sendKeys(passward);
	}
public void clickLogInBTN() {	
	LogInBTN.click();
}
	

}
