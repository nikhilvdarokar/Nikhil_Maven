package DDF_TestNG_10_Jan_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiHome {
	
	@FindBy (xpath="//td[text()='Enter Time-Track']") private WebElement text;
	
	public ActiHome(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyText() {
		String actText = text.getText();
		
		return actText;
	}

}
