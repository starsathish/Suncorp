package pages.marketplace.auth.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class LoginAuthPage extends BasePage{

	
	private By reloginButton = By.id("au.com.suncorp.marketplace:id/loginButton");
	private By changeAccountButton = By.id("au.com.suncorp.marketplace:id/changeUserButton");
	
	public LoginAuthPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement checkChangeAccountButton(){
		return find(changeAccountButton,5);
	}
	
	public void tapChangeAccountButton() {
		tapElement(changeAccountButton);
	}
	
	public WebElement checkReloginButton(){
		return find(reloginButton);
	}
	
	public void tapReloginButton() {
		tapElement(reloginButton);
	}
}
