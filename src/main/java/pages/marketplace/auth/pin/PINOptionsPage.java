package pages.marketplace.auth.pin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class PINOptionsPage extends BasePage{


	//No Fingerprint enabled
	private By enablePinButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptEnablePinButton");
	private By maybeLaterPinPromptButton = By.id("au.com.suncorp.marketplace:id/enablePinPromptDismissButton");
	private By pinPromptImage = By.id("au.com.suncorp.marketplace:id/enablePinPromptImage");
	private By pinPromptUserWelcome = By.id("au.com.suncorp.marketplace:id/enablePinPromptUserWelcome");
	private By pinPromptDescription = By.id("au.com.suncorp.marketplace:id/enablePinPromptDescription");
	
	//Fingerprint enabled
	private By promptUserWelcome = By.id("au.com.suncorp.marketplace:id/enablePromptUserWelcome");
	private By promptDescription = By.id("au.com.suncorp.marketplace:id/enablePromptDescription");
	private By promptImage = By.id("au.com.suncorp.marketplace:id/enablePromptImage");
//	private By enablePinButton = By.id("au.com.suncorp.marketplace:id/enablePinButton");
	private By maybeLaterPromptButton = By.id("au.com.suncorp.marketplace:id/enablePromptDismissButton");
	
	public PINOptionsPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Methods for Fingerprint not enabled cases
	
	public WebElement checkEnablePinButton(){
		return find(enablePinButton,45);
	}
	
	public WebElement checkMaybeLaterButton(){
		return find(maybeLaterPinPromptButton);
	}
	
	public WebElement checkPinPromptImage(){
		return find(pinPromptImage);
	}
	
	public WebElement checkPinPromptUserWelcome(){
		return find(pinPromptUserWelcome, 30);
	}
	
	public WebElement checkPinPromptDescription(){
		return find(pinPromptDescription);
	}
	
	public void tapEnablePinButton(){
		tapElement(enablePinButton);
	}
	
	public void tapMaybeLater(){
		tapElement(maybeLaterPinPromptButton);
	}
	
	//Methods for Fingerprint enabled cases
	
	public WebElement checkPromptUserWelcome(){
		return find(promptUserWelcome, 30);
	}
	
	public WebElement checkPromptDescription(){
		return find(promptDescription);
	}
	
	public WebElement checkPromptImage(){
		return find(promptImage);
	}
	
	public WebElement checkMaybeLaterPromptButton(){
		return find(maybeLaterPromptButton);
	}
	
	public void tapPromptMaybeLater(){
		tapElement(maybeLaterPromptButton);
	}
}
