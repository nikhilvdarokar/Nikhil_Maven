package DDF_TestNG_10_Jan_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiLogin {
	
	@FindBy(xpath="//input[@id='username']") private WebElement UN;
	@FindBy(xpath="//input[@type='password']") private WebElement PWD;
	@FindBy(xpath="//div[text()='Login ']") private WebElement LogInBTN;
	
	public ActiLogin(WebDriver driver) {
		
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
