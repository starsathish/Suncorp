package pages.marketplace.digitalVault;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;

public class DigitalVaultPage extends BasePage {

	public DigitalVaultPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	DigiVaultCommonPage digiCommonPage = new DigiVaultCommonPage(driver);
	
	private By digiVaultTitle = By.xpath("//android.widget.TextView[@text='DigitalSafe']");
	private By chatbotButton = By.id("au.com.suncorp.marketplace:id/chatbotOption");
	private By digiVaultEmptyImage = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultImage");
	private By digiVaultEmptyImageTitle = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultTitle");
	private By digiVaultEmptyImageDescription = By.id("au.com.suncorp.marketplace:id/emptyDigitalVaultDescription");
	private By addFromPhotoLibraryButton = By.id("au.com.suncorp.marketplace:id/uploadPhotoCard");

	private By sortByButton = By.id("au.com.suncorp.marketplace:id/sortByButton");
	private By editButton = By.id("au.com.suncorp.marketplace:id/editButton");

	private By moveToFolderButton = By.id("au.com.suncorp.marketplace:id/moveToFolderButton");
	private By permissionOkButton = By.id("com.android.packageinstaller:id/permission_allow_button");
	private By imageItem = By.id("DigitalVaultFileCell0FileThumbnailImageView");

	private By createFolderCard = By.id("au.com.suncorp.marketplace:id/createFolderCard");
	private By folderMoreButton = By.id("au.com.suncorp.marketplace:id/folderMoreButton");
	private By folderNameField = By.id("au.com.suncorp.marketplace:id/dialogEditText");
	private By renameFolderButton = By.id("au.com.suncorp.marketplace:id/renameFolderButton");
	private By deleteFolderButton = By.id("au.com.suncorp.marketplace:id/deleteFolderButton");
	private By folderItem = By.id("au.com.suncorp.marketplace:id/folderForeground");
	private By folderName = By.id("au.com.suncorp.marketplace:id/folderName");
	private By deleteFolderPopupButton = By.id("android:id/button1");
	private By deleteFolderConfirmationMsg = By.id("au.com.suncorp.marketplace:id/dialogMessage");
	

	private By binBoxForFolder = By.id("au.com.suncorp.marketplace:id/deleteFolderOption");
	private By sortingButtonIcon = By.id("au.com.suncorp.marketplace:id/sortingButtonIcon");
    private By sortByDate = By.id("au.com.suncorp.marketplace:id/sortByDateOption");
    private By sortByName = By.id("au.com.suncorp.marketplace:id/sortByNameOption");
    private By imageTitle = By.id("au.com.suncorp.marketplace:id/documentTitle");
    
    public List<String> fetchFolderNameList() {
		return getTextList(folderName);
	}
    
	public WebElement checkDigiVaultTitle() {
		return find(digiVaultTitle);
	}

	public WebElement checkChatbotButton() {
		return find(chatbotButton);
	}
	

	public WebElement checkDigiVaultEmptyImage() {
		return find(digiVaultEmptyImage);
	}

	public WebElement checkDigiVaultEmptyImageTitle() {
		return find(digiVaultEmptyImageTitle);
	}
	
	public String getDigiVaultEmptyImageTitle()
	{
		return getText(digiVaultEmptyImageTitle);
	}

	public WebElement checkDigiVaultEmptyImageDescription() {
		return find(digiVaultEmptyImageDescription);
	}
	
	public String getdigiVaultEmptyImageDescription()
	{
		return getText(digiVaultEmptyImageDescription);
	}

	public WebElement checkAddFromPhotoLibraryButton() {
		return find(addFromPhotoLibraryButton);
	}

	public void tapAddFromPhotoLibraryButton() {
		tapElement(addFromPhotoLibraryButton);
	}

	
	
	public boolean isEditClickable() {
		return isClickable(editButton);
	}
	
	public WebElement checkFolderNameField() {
		return find(folderNameField);
	}
	
	
	
	public void enterFolderName(String folderName) {
		typeValue(folderName, folderNameField);
	}
	
	public void tapFolderItem() {
		tapElement(folderItem);
	}
	
	public WebElement checkEditButton() {
		return find(editButton,30);
	}
	
	public boolean checkEditButtonEnabled() {
		return isEnabled(editButton);
	}
	
	public WebElement checkImageItem() {
		return find(imageItem);
	}
	
	public void createAnEntry() {
		digiCommonPage.tapAddButton();
		digiCommonPage.tapTakePhotoCard();
		if(find(permissionOkButton) != null) {
			tapPermissionOkButton();
		}
	}

	public void createFolder(String folderName) {
		digiCommonPage.tapAddButton();
		tapCreateFolderCard();
		typeValue(folderName, folderNameField);
		digiCommonPage.tapPositiveButton();		
	}


	
	public void tapPermissionOkButton() {
		tapElement(permissionOkButton);
	}

	
	public WebElement checkCreateFolderCard() {
		return find(createFolderCard);
	}
	
	public void tapCreateFolderCard() {
		tapElement(createFolderCard);
	}
	
	public WebElement checkMoveToFolderButton() {
		return find(moveToFolderButton);
	}
	
	public void tapEditButton() {
		tapElement(editButton);
	}

	public void tapFolderMoreOption() {
		tapElement(folderMoreButton);
	}
	
	public WebElement checkRenameFolderButton() {
		return find(renameFolderButton);
	}
	
	public void tapRenameFolderButton() {
		tapElement(renameFolderButton);
	}
	
	public String findDocumentInPage(String fileName) {
		WebElement doc = find(By.xpath(String.format( "//*[@text=\"%s\"]", fileName)));
		return doc.toString();	
	}
		
	public WebElement checkFolderMoreOption() {
		return find(folderMoreButton);
	}
	
	public void swipeToDeleteFolder() {
		 swipeHorizontally(folderMoreButton, folderItem);
	}
	
	public WebElement checkBinBoxForFolder() {
		return find(binBoxForFolder);
	}
	
	public void tapBinBoxForFolder() {
		tapElement(binBoxForFolder);
	}
	
	public WebElement Name() {
		return find(sortByDate);
	}
	
	public WebElement checkSortingButtonIcon() {
		return find(sortingButtonIcon);
	}
	
	public boolean isSortingButtonIconEnabled() {
		return isClickable(sortingButtonIcon);
	}
	
	public void tapSortingButtonIcon() {
		tapElement(sortingButtonIcon);
	}
	
	public WebElement checkSortByName() {
		return find(sortByName);
	}
	
	public void tapSortByName() {
		tapElement(sortByName);
	}
	
    public List<String> fetchImageTitleList(){
		return getTextList(imageTitle);
	}
    
    
	public WebElement checkDeleteFolderButton() {
		return find(deleteFolderButton);
	}
	
	public void tapDeleteFolderButton() {
		tapElement(deleteFolderButton);
	}

	public WebElement checkDeleteFolderPopupButton() {
		return find(deleteFolderPopupButton);
	}
	
	public void tapDeleteFolderPopupButton() {
		tapElement(deleteFolderPopupButton);
	}
	
	public WebElement checkDeleteFolderConfirmationMsg() {
		return find(deleteFolderConfirmationMsg);
	}

	public WebElement checkFolderTitleXPath(String str) {
		return find(findElementUsingXpathText(str));
	}
}