package pages.marketplace.auth.registration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class MemberLoginPage extends BasePage {

	public MemberLoginPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By pageTitle = By.id("au.com.suncorp.marketplace:id/screenTitleText");
	private By cancelButton = By.id("au.com.suncorp.marketplace:id/cancelButton");
	private By emailTextField = By.id("au.com.suncorp.marketplace:id/emailAddressField");
	private By passwordTextField = By.id("au.com.suncorp.marketplace:id/passwordField");
	private By nextButton = By.id("au.com.suncorp.marketplace:id/nextButton");
	private By forgotPasswordButton = By.id("au.com.suncorp.marketplace:id/forgotPasswordButton");
	private By noCredentialsButton = By.id("au.com.suncorp.marketplace:id/noCredentialsButton");
	private By emailFieldError = By.xpath("//TextInputLayout[@text='Email']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By passwordFieldError = By.xpath("//TextInputLayout[@text='Password']//android.widget.LinearLayout/android.widget.TextView[@resource-id='au.com.suncorp.marketplace:id/textinput_error']");
	private By incorrectEmailSnackbar = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.FrameLayout");
	private By incorrectEmailSnackbarText = By.id("au.com.suncorp.marketplace:id/snackbar_text");
	private By incorrectEmailSnackBarButton = By.id("au.com.suncorp.marketplace:id/snackbar_action");

	
	//Mobile registration page elements
	private By mobileRegisterPageTitle = By.xpath("//android.widget.TextView[@text='Almost there!']");
	private By mobileRegisterPageDescription = By.id("au.com.suncorp.marketplace:id/registrationMobileText");
	private By mobileTextField = By.id("au.com.suncorp.marketplace:id/mobileField");
	private By regiterWithMobileButton = By.id("au.com.suncorp.marketplace:id/registerButton");
	private By noMarketingTermsText = By.id("au.com.suncorp.marketplace:id/noMarketingTermsText");
	private By registrationTermsText = By.id("au.com.suncorp.marketplace:id/registrationTermsText");
	private By mobileNumberError  = By.id("au.com.suncorp.marketplace:id/textinput_error");

	
	public String getPageTitle() {
		find(pageTitle, 30);
		return getText(pageTitle);
	}

	public WebElement checkCancelButton() {
		return find(cancelButton);
	}

	public void tapCancelButton() {
		tapElement(cancelButton);
	}

	public WebElement checkEmailField() {
		return find(emailTextField);
	}

	public void enterEmail(String emailValue) {
		typeValue(emailValue, emailTextField);
	}

	public void tapEmailField() {
		tapElement(emailTextField);
	}
	
	public String getEmailFieldValue() {
		return getText(emailTextField);
	}

	public String getEmailFieldErrorValue() {
		return getText(emailFieldError);
	}
	
	public WebElement checkEmailFieldError(){
		return find(emailFieldError, 5);
	}
	
	public WebElement checkPasswordField() {
		return find(passwordTextField);
	}
	
	public void enterPassword(String pwdValue) {
		typeValue(pwdValue, passwordTextField);
	}

	public void tapPasswordField() {
		tapElement(passwordTextField);
	}
	
	public WebElement checkPasswordFieldError(){
		return find(passwordFieldError, 5);
	}
	
	public String getPasswordFieldErrorValue() {
		return getText(passwordFieldError);
	}

	public WebElement checkNextButton() {
		return find(nextButton);
	}
	
	public void tapNextButton() {
		tapElement(nextButton);
	}

	public WebElement checkForgotPasswordButton() {
		return find(forgotPasswordButton);
	}

	public WebElement checkNoCredentialsButton() {
		return find(noCredentialsButton);
	}

	public String getPasswordFieldValue() {
		find(passwordTextField, 30);
		return getText(passwordTextField);
	}

	public void relaunchApp(int time, String appName) {
		selectSuncorpApp(time, appName);
	}

	public void tapOn(String tapOn) {
		switch (tapOn) {
		case "passwordField":
			tapElement(passwordTextField);
			break;
		case "nextButton":
			tapElement(nextButton);
			break;
		default:
			break;
		}
	}
	
	public void enterLoginCredentials(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
	}
	
	public void tapNoCredentialsButton() {
		tapElement(noCredentialsButton);
	}
	
	public WebElement checkMobileRegisterPageTitle() {
		return find(mobileRegisterPageTitle, 30);
	}
	
	public WebElement checkMobileRegisterPageDescription() {
		return find(mobileRegisterPageDescription);
	}
	
	public WebElement checkMobileTextField() {
		return find(mobileTextField);
	}

	public void tapMobileTextField() {
		tapElement(mobileTextField);
	}
	
	public void enterMobileNumber(String number) {
		typeValue(number, mobileTextField);
	}
	
	public WebElement checkRegiterWithMobileButton() {
		return find(regiterWithMobileButton);
	}
	
	public void tapRegisterButton() {
		find(regiterWithMobileButton);
		tapElement(regiterWithMobileButton);
	}
	
	public WebElement checkNoMarketingTermsText() {
		return find(noMarketingTermsText);
	}
	
	public WebElement checkRegistrationTermsText() {
		return find(registrationTermsText);
	}
	
	public String getMobileFieldError() {
		return getText(mobileNumberError);
	}
	
	public WebElement checkMobileFieldError() {
		return find(mobileNumberError, 5);
	}
	
	public Boolean checkKeyboard() {
		return isKeyboardPresent();
	}
	
	public void tapBackBtn() {
		tapDeviceBackButton();
	}
	
	public WebElement checkSnackbarDisplayed() {
		return find(incorrectEmailSnackbar);
	}
	
	public String getSnackbarText() {
		find(incorrectEmailSnackbarText);
		return getText(incorrectEmailSnackbarText);
	}
	
	public void tapSnackbarOkButton() {
		find(incorrectEmailSnackBarButton);
		tapElement(incorrectEmailSnackBarButton);
	}
}
