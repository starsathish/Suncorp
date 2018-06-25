package pages.marketplace.auth.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class TermsAndConditionsPage extends BasePage {

	public TermsAndConditionsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By termsAndConditionsTitle = By.id("au.com.suncorp.marketplace:id/registrationTermsAndConditionsTitle");
	private By loginTermsAndConditionsTitle = By.id("au.com.suncorp.marketplace:id/loginTermsAndConditionsTitle");
	private By acceptButton = By.id("au.com.suncorp.marketplace:id/acceptButton");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");

	
	public WebElement checkTermsAndConditionsTitle() {
		return find(termsAndConditionsTitle);
	}
	
	public WebElement checkAcceptButton() {
		return find(acceptButton);
	}
	
	public void tapAcceptButton() {
		tapElement(acceptButton);
	}
	
	public WebElement checkLoginTermsAndConditionsTitle() {
		return find(loginTermsAndConditionsTitle);
	}
	public WebElement checkCancelButton() {
		return find(acceptButton);
	}
	
	public void tapCancelButton() {
		tapElement(cancelButton);
	}
	
}
