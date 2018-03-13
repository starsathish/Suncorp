package pages.marketplace.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class HomePropertyPage extends BasePage {

	public HomePropertyPage(AppiumDriver driver) {
		super(driver);
	}

	private By homeJourneyBannerImage = By.id("au.com.suncorp.marketplace:id/homeJourneyBannerImage");
	private By homeJourneyBannerHeading = By.id("au.com.suncorp.marketplace:id/journeyHeadingText");
	private By homeJourneyBannerDescription = By.id("au.com.suncorp.marketplace:id/journeyDescriptionText");
	private By startYourJourneyButton = By.id("au.com.suncorp.marketplace:id/startHomeJourneyButton");
	
	private By addAPropertyOrPolicyButton = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyActionText");
	private By addAPropertyOrPolicyImage = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyImage");
	private By propertyInsightInfo = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyInfo1Text");
	private By organiseDocumentsInfo = By.id("au.com.suncorp.marketplace:id/addPropertyOrPolicyInfo2Text");
	private By accessProfessionalInfo = By.id("au.com.suncorp.marketplace:id/addPropertyOrPropertyInfo3Text");
	
	private By addPropertyOrPolicyActionSheetTitle = By.id("au.com.suncorp.marketplace:id/propertyOrPolicySelectionText");
	private By addPolicyActionSheetButton = By.id("au.com.suncorp.marketplace:id/addPolicyButton");
	private By addPropertyActionSheetButton = By.id("au.com.suncorp.marketplace:id/addPropertyButton");
	
	private By activeClaimTitle = By.id("au.com.suncorp.marketplace:id/activeClaimText");
	private By propertyImage = By.id("au.com.suncorp.marketplace:id/propertyImage");
	private By addressLineText = By.id("au.com.suncorp.marketplace:id/addressLine1Text");
	private By suburbText = By.id("au.com.suncorp.marketplace:id/addressLine2Text");
	private By productIcon = By.id("au.com.suncorp.marketplace:id/productIcon");
	private By productDescriptionText = By.id("au.com.suncorp.marketplace:id/productDescriptionText");
	private By brandIcon = By.id("au.com.suncorp.marketplace:id/brandIcon");
	//au.com.suncorp.marketplace:id/propertyItemLayout
	private By propertyItem = By.id("au.com.suncorp.marketplace:id/propertyItemLayout");
	 private By emptyStatePropertyAsset = By.xpath("//android.widget.TextView[@text='43 Badminton Rd, Croydon']");


	public List<String> fetchProductDescriptionTextList() {
		find(productDescriptionText);
		return getTextList(productDescriptionText);
	}
	
	public String getAddressLineText() {
		find(addressLineText);
		return getText(addressLineText);
	}
	
	public String getSuburbTextList() {
		find(suburbText);
		return getText(suburbText);
	}
	
	public WebElement checkbrandIcon() {
		return find(brandIcon);
	}
	
	public WebElement checkproductDescriptionText() {
		return find(productDescriptionText);
	}
	
	public String getproductDescriptionText() {
		return getText(productDescriptionText);
	}
	
	public WebElement checkproductIcon() {
		return find(productIcon);
	}
	
	public WebElement checksuburbText() {
		return find(suburbText);
	}
	
	public String getsuburbText() {
		return getText(suburbText);
	}
	
	public WebElement checkaddressLineText() {
		return find(addressLineText);
	}
	
	public String getaddressLineText() {
		return getText(addressLineText);
	}
	
	public WebElement checkpropertyImage() {
		return find(propertyImage);
	}
	
	public String getpropertyImage() {
		return getText(propertyImage);
	}
	
	public WebElement checkactiveClaimTitle() {
		return find(activeClaimTitle);
	}
	
	public String getactiveClaimTitle() {
		return getText(activeClaimTitle);
	}
	
	
	public WebElement checkAddPropertyOrPolicyActionSheetTitle() {
		return find(addPropertyOrPolicyActionSheetTitle);
	}
	
	public String getAddPropertyOrPolicyActionSheetTitle() {
		return getText(addPropertyOrPolicyActionSheetTitle);
	}
	
	public WebElement checkAddPolicyActionSheetButton() {
		return find(addPolicyActionSheetButton);
	}
	
	public String getAddPolicyActionSheetButton() {
		return getText(addPolicyActionSheetButton);
	}
	
	public void tapAddPolicyActionSheetButton() {
		tapElement(addPolicyActionSheetButton);
	}
	
	public WebElement checkAddPropertyActionSheetButton() {
		return find(addPropertyActionSheetButton);
	}
	
	public String getAddPropertyActionSheetButton() {
		return getText(addPropertyActionSheetButton);
	}
	
	public void tapAddPropertyActionSheetButton() {
		tapElement(addPropertyActionSheetButton);
	}
	
	public WebElement checkAddAPropertyOrPolicyImage() {
		return find(addAPropertyOrPolicyImage);
	}
	
	public WebElement checkPropertyInsightInfo() {
		return find(propertyInsightInfo);
	}
	
	public String getPropertyInsightInfo() {
		return getText(propertyInsightInfo);
	}
	
	public WebElement checkOrganiseDocumentsInfo() {
		return find(organiseDocumentsInfo);
	}
	
	public String getOrganiseDocumentsInfo() {
		return getText(organiseDocumentsInfo);
	}
	
	public WebElement checkAccessProfessionalInfo() {
		return find(accessProfessionalInfo);
	}
	
	public String getAccessProfessionalInfo() {
		return getText(accessProfessionalInfo);
	}
	
	public void tapAddAPropertyOrPolicyButton() {
		tapElement(addAPropertyOrPolicyButton);
	}
	
	public WebElement checkAddAPropertyOrPolicyButton() {
		return find(addAPropertyOrPolicyButton);
	}
	
	public String getAddAPropertyOrPolicyButton() {
		return getText(addAPropertyOrPolicyButton);
	}
	
	public void scrollToJourneyBanner(){
		scrollToElement(startYourJourneyButton);
	}
	
	public WebElement checkHomeJourneyBannerImage() {
		return find(homeJourneyBannerImage);
	}
	
	public String getHomeJourneyBannerHeading() {
		return getText(homeJourneyBannerHeading);
	}
	
	public String getHomeJourneyBannerDescription() {
		return getText(homeJourneyBannerDescription);
	}
	
	public WebElement checkStartYourJourneyButton() {
		return find(startYourJourneyButton);
	}
	
	public void tapStartYourJourneyButton() {
		tapElement(startYourJourneyButton);
	}
	
	public void scrollToNextProduct() {
	
			for(int i=0;i<4;i++) {
				swipeScreen("down");
			}
			
		
	}
	
	public void scrollToEmptyStatePropertyAsset() {
		scrollToElement(emptyStatePropertyAsset, "true");
	}
}
