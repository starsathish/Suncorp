package test.marketplace.portfolio;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.App;

public class AddPolicyTest extends App{
	
	/*1011 - Scenario 1 - DMPM-1247, Scenario 2 DMPM-1249*/
	@Test (groups = {"DMPM-1011", "DMPM-1247", "DMPM-1249" ,"marketplace", "portfolio", "priority-minor"})
	public void testAddingAPolicy(){
	
	navigateToMyProductsScreen("prodListUser");
	
	addPolicyPage.tapPolicyNumberTextBox();
	addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList", "addPolicy", "enterPolicyNumber"));
	Assert.assertNotNull(addPolicyPage.checkAddAccountButton(), "Add policy screen - Add account buttom is not present");
	addPolicyPage.tapAddAccountButton();
	//verify the loading indicator here
	Assert.assertNotNull(addPolicyPage.checkSuccessMessage(), "Add policy screen - Success message is not present");
	Assert.assertNotNull(addPolicyPage.checkSuccessImage(), "Add policy screen - Success image is not present");
	Assert.assertEquals(addPolicyPage.getSuccessMessage(), utils.readTestData("copy", "portfolio","policyAddedSuccessfulMsg"), "Add policy Page - Successful message is not matching");
	Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
	
	}

	/*344 - Scenario 1 - DMPM-462* and Scenario 3 - DMPM-464*/
	@Test (groups = {"DMPM-344", "DMPM-462","DMPM-464", "marketplace", "portfolio", "priority-minor"})
	public void testInlineErrorsAsItype(){
		navigateToMyProductsScreen("prodListUser");
		
		addPolicyPage.tapPolicyNumberTextBox();
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList", "addPolicy", "policyNumberExceedsMaxLimit"));
		
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","maxLimitError"), "Add policy Page - Max limit error message is not matching");
		
		addPolicyPage.deletecharactersInPolicyNumber(1);
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "policyNumberInvalidChars"));
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","invalidCharactor"), "Add policy Page - Invalid charactor error message is not matching");
		
		addPolicyPage.clearPolicyNumber();
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "policyNumberExceedsMaxLimit")+utils.readTestData("portfolio","loginProdList","addPolicy", "policyNumberInvalidChars"));
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","maxLimitError")+"\n"+"\n"+utils.readTestData("copy", "portfolio","invalidCharactor"), "Add policy Page - Invalid charactor error message is not matching");
		
		addPolicyPage.deletecharactersInPolicyNumber(6);
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
	}
	
	/*344 - scenario2 - "DMPM-463" and Scenario 4 - DMPM-465
	 * 108 - scenario 9 -DMPM-459*/
	@Test (groups = {"DMPM-344", "DMPM-463", "DMPM-465","DMPM-108", "DMPM-459", "marketplace", "portfolio", "priority-minor"})
	public void testInlineErrorMessagesOnTapOut(){
		
		navigateToMyProductsScreen("prodListUser");
	
		addPolicyPage.tapAddAccountButton();
		
		Assert.assertNotNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is not present");
		Assert.assertEquals(addPolicyPage.getPolicyNumberinlineError(), utils.readTestData("copy", "portfolio","feildValidationError"), "Add policy Page - Field validation error message is not matching");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "minimumChar"));
		Assert.assertNull(addPolicyPage.checkPolicyNumberinlineError(), "Add policy screen - inline Error message is still present");
		
		addPolicyPage.enterPolicyNumber(utils.readTestData("portfolio","loginProdList","addPolicy", "enterPolicyNumber"));
		addPolicyPage.tapAddAccountButton();
		Assert.assertNotNull(addPolicyPage.checkSuccessMessage(), "Add policy screen - success message is not displayed");
		Assert.assertEquals(addPolicyPage.getSuccessMessage(), utils.readTestData("copy", "portfolio","policyAddedSuccessfulMsg"), "Add policy Page - policy added Successfuly message is not matching");
		Assert.assertNotNull(addPolicyPage.checkSuccessImage(), "Add policy screen - success image is not displayed");
		
		
	}
	
	
	private void navigateToMyProductsScreen(String userType) {
		
		if (userType.equals("emptyProdListUser")) {
			loginToApp(utils.readTestData("portfolio","loginEmptyProdList", "login"), utils.readTestData("portfolio","loginEmptyProdList", "pwd"));
		}else {
			loginToApp(utils.readTestData("portfolio","loginProdList", "login"), utils.readTestData("portfolio","loginProdList", "pwd"));
		}
		navigationMenu.tapSplitMenuIcon();
		navigationMenu.tapProductsMenuItem();
		Assert.assertNotNull(myProductsPage.checkMyProductsTitle(), "My products page - title is not present");
		
		myProductsPage.scrollToAddExistingProductButton();
		
		myProductsPage.tapAddExistingProductButton();
		Assert.assertNotNull(myProductsPage.checkInsurancePolicyBottomSheetButton(), "My Products screen - Insurance policy button on Bottom sheet label is not present");
		myProductsPage.tapInsurancePolicyBottomSheetButton();
			
		Assert.assertNotNull(addPolicyPage.checkAddPolicyPageTitle(), "Add policy screen - Add policy title is not present");
		Assert.assertNotNull(addPolicyPage.checkForgotMyDetailsButton(), "Add policy screen - Forgotten my details button is not present");
		
		
	}

}
