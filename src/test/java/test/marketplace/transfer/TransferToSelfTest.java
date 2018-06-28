package test.marketplace.transfer;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.framework.common.Copy;
import automation.framework.common.TestDetails;
import automation.framework.common.TestDetails.Priority;
import pages.App;

public class TransferToSelfTest extends App{
	
	@DataProvider(name = "TransferPayEntryPoint")
	public static Object[][] Data_PolicyMaintainceError() {

		return new Object[][] {{ "moneyFlow" }, { "transactionsFlow" } };

	}
	
	//MACC-2779,defect occurs the case of Product names on To/From accounts are not in sync with Product names on account overview 
	@TestDetails(story1 = "DMPM-4368:DMPM-11080,DMPM-11086",priority = Priority.LOW)
	@Test (dataProvider = "TransferPayEntryPoint",groups = {"marketplace", "Transfer to self", "priority-minor"})
	public void testTransferConfirmAndPay(String entryPoint) {

		String userName = utils.readTestData("transferToSelf","userAccount1","login");
		String pwd = utils.readTestData("transferToSelf","userAccount1","pwd");
		String fromAccountNameOnMoney = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayName");
		String fromAccountName = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayNameOnFromScreen");
		String toAccountName = utils.readTestData("transferToSelf","userAccount1","toAccountdisplayNameOnToScreen");
		String amount = utils.readTestData("transferToSelf","userAccount1","amount");
		String fromAccountBSB = utils.readTestData("transferToSelf","userAccount1","fromBSB");
		String toAccountBSB = utils.readTestData("transferToSelf","userAccount1","toBSB");
		String fromAccountNumber = utils.readTestData("transferToSelf","userAccount1","fromAccountNumber");
		String toAccountNumber = utils.readTestData("transferToSelf","userAccount1","toAccountNumber");
		
		navigateToTransferScreen(userName,pwd,entryPoint,fromAccountNameOnMoney);
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		String exptdFromAvailableBalance= transferPage.getFromAvailableBalance();
		String exptdToAvailableBalance= transferPage.getToAvailableBalance();
		transferPage.enterAmount(amount);
		common.dismissKeyboardShown();
		transferPage.tapNextButton();
		assertTransferSummaryScreen(fromAccountName,toAccountName,amount,fromAccountBSB,toAccountBSB,fromAccountNumber,toAccountNumber,exptdFromAvailableBalance,exptdToAvailableBalance);
		Assert.assertEquals(transferSummaryPage.getDisclaimerLabel(),Copy.TRANSFER_DISCLAIMER_MESSAGE,"Transfer disclaimer message is incorrect");
		transferSummaryPage.tapTransferNowButton();
		Assert.assertEquals(Copy.PROCESSING_MESSAGE,transferSummaryPage.getProcessingMessage(),"Processing message is not displayed");
		common.tapDeviceBackButton();
		Assert.assertEquals(Copy.PROCESSING_MESSAGE,transferSummaryPage.getProcessingMessage(),"Processing message not displayed on pressing back button");
		
	}
	//Defect :-MACC-3063 for "transactionsFlow"
	@TestDetails(story1 = "DMPM-4368:DMPM-11083,DMPM-11080",priority = Priority.LOW)
	@Test (dataProvider = "TransferPayEntryPoint",groups = {"marketplace", "Transfer to self", "priority-minor"})
	public void testTransferFromCreditCardDisclaimer(String entryPoint) {

		String userName = utils.readTestData("transferToSelf","creditCardAccount1","login");
		String pwd = utils.readTestData("transferToSelf","creditCardAccount1","pwd");
		String fromAccountName = utils.readTestData("transferToSelf","creditCardAccount1","fromAccountdisplayNameOnFromScreen");
		String toAccountName = utils.readTestData("transferToSelf","creditCardAccount1","toAccountdisplayNameOnToScreen");
		String amount = utils.readTestData("transferToSelf","creditCardAccount1","amount");
		String fromAccountBSBAndAccountNum = utils.readTestData("transferToSelf","creditCardAccount1","fromBSBAndAccount");
		
		navigateToTransferScreen(userName,pwd,entryPoint,fromAccountName);
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		transferPage.enterAmount(amount);
		common.dismissKeyboardShown();
		transferPage.tapNextButton();
		Assert.assertEquals(transferSummaryPage.getFromAccountAndBsbNumber(),fromAccountBSBAndAccountNum,"From Account BSB and Account number is incorrect");
		Assert.assertEquals(transferSummaryPage.getCreditCardTransferDisclaimerLabel(),Copy.CREDIT_CARD_TRANSFER_DISCLAIMER_MESSAGE,"Credit card Transfer disclaimer message is incorrect");
		Assert.assertEquals(transferSummaryPage.getDisclaimerLabel(),Copy.TRANSFER_DISCLAIMER_MESSAGE,"Transfer disclaimer message is incorrect");
		
	}
	
	@TestDetails(story1 = "DMPM-4368:DMPM-9845,DMPM-9846",priority = Priority.LOW)
	@Test (dataProvider = "TransferPayEntryPoint",groups = {"marketplace","Transfer to self", "priority-minor"})
	public void testSelectFromAndToAccounts(String entryPoint) {

		String userName = utils.readTestData("transferToSelf","userAccount1","login");
		String pwd = utils.readTestData("transferToSelf","userAccount1","pwd");
		String fromAccountNameOnMoney = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayName");
		String fromAccountName = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayNameOnFromScreen");
		String toAccountName = utils.readTestData("transferToSelf","userAccount1","toAccountdisplayNameOnToScreen");
		String fromAccountBSB = utils.readTestData("transferToSelf","userAccount1","fromBSB");
		String toAccountBSB = utils.readTestData("transferToSelf","userAccount1","toBSB");
		String fromAccountNumber = utils.readTestData("transferToSelf","userAccount1","fromAccountNumber");
		String toAccountNumber = utils.readTestData("transferToSelf","userAccount1","toAccountNumber");
		
		navigateToTransferScreen(userName,pwd,entryPoint,fromAccountNameOnMoney);
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		
		Assert.assertEquals(transferPage.getFromAccountName(), fromAccountName,"From Account name is incorrect");
		Assert.assertEquals(transferPage.getFromAccountBSB(), fromAccountBSB,"From account BSB is not correct");
		Assert.assertEquals(transferPage.getFromAccountNumber(), fromAccountNumber,"From account number is incorrect");
		Assert.assertTrue(transferPage.getFromAvailableBalance().matches("^\\$[0-9]+\\.[0-9][0-9]$"),"From available balance is incorrect");
		Assert.assertFalse(transferPage.isAmountFieldEnabled(),"Amount field is enabled");
		Assert.assertFalse(transferPage.isDescriptionFieldEnabled(),"Description field is enabled");
		Assert.assertFalse(transferPage.isNextButtonEnabled(),"Next button is enabled");
		
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		
		Assert.assertEquals(transferPage.getToAccountName(), toAccountName,"To account name is incorrect");
		Assert.assertEquals(transferPage.getToAccountBSB(), toAccountBSB,"To account BSB is inocrrect");
		Assert.assertEquals(transferPage.getToAccountNumber(), toAccountNumber,"To account number is incorrect");	
		Assert.assertTrue(transferPage.getToAvailableBalance().matches("^\\$[0-9]+\\.[0-9][0-9]$"),"To available balance is incorrect");
		Assert.assertTrue(transferPage.isAmountFieldEnabled(),"Amount field is disabled");
		common.dismissKeyboardShown();
		Assert.assertTrue(transferPage.isDescriptionFieldEnabled(),"Description field is disabled");
		Assert.assertFalse(transferPage.isNextButtonEnabled(),"Next button is enabled");
	}
	
	@TestDetails(story1 = "DMPM-4356:DMPM-9851",story2="DMPM-9971:DMPM-11324,DMPM-11581",story3="DMPM-4356:DMPM-9853",priority = Priority.LOW)
	@Test (dataProvider = "TransferPayEntryPoint",groups = {"marketplace","Transfer to self", "priority-minor"})
	public void testAmountAndDescriptionFieldValidation(String entryPoint) {

		String userName = utils.readTestData("transferToSelf","userAccount1","login");
		String pwd = utils.readTestData("transferToSelf","userAccount1","pwd");
		String fromAccountName = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayNameOnFromScreen");
		String fromAccountNameOnMoney = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayName");
		String toAccountName = utils.readTestData("transferToSelf","userAccount1","toAccountdisplayNameOnToScreen");
		String zeroAmount = utils.readTestData("transferToSelf","userAccount1","amountValidation","zeroAmount");
		String greaterAmount = utils.readTestData("transferToSelf","userAccount1","amountValidation","greaterAmount");
		String negativeAmount = utils.readTestData("transferToSelf","userAccount1","amountValidation","negativeAmount");
		String moreThanEightDigitAmount = utils.readTestData("transferToSelf","userAccount1","amountValidation","moreThanEightDigitAmount");
		String moreThanTwoAfterDecimal = utils.readTestData("transferToSelf","userAccount1","amountValidation","moreThanTwoAfterDecimal");
		String currencyFormatAmount = utils.readTestData("transferToSelf","userAccount1","amountValidation","4digitAmount");
		String maxDescriptionCharactors = utils.readTestData("transferToSelf","userAccount1","descriptionValidation","19DescriptionCharactors");
		
		
		navigateToTransferScreen(userName,pwd,entryPoint,fromAccountNameOnMoney);
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		transferPage.enterAmount(zeroAmount);
		common.dismissKeyboardShown();
		Assert.assertEquals(transferPage.getAmountInlineError(), Copy.MINIMUM_AMOUNT_INLINE_ERROR,"Minimum amount error is incorrect");
		transferPage.clearAmountField();
		transferPage.enterAmount(greaterAmount);
		common.dismissKeyboardShown();
		Assert.assertEquals(transferPage.getAmountInlineError(), Copy.INSUFFICIENT_FUNDS_INLINE_ERROR,"Insufficient funds error is not correct");
		Assert.assertFalse(transferPage.isNextButtonEnabled(),"Next button is enabled");
		transferPage.clearAmountField();
		transferPage.enterAmount(negativeAmount);
		common.dismissKeyboardShown();
		Assert.assertTrue(transferPage.isAmountFieldEmpty());
		enterByKeyboard(moreThanEightDigitAmount);
		Assert.assertTrue(transferPage.getAmountFieldValue().matches("\\b[0-9]{8}\\b"),"Amount field is has more than 8 digits");
		transferPage.clearAmountField();
		enterByKeyboard(moreThanTwoAfterDecimal);
		Assert.assertTrue(transferPage.getAmountFieldValue().matches("[0-9]+\\.[0-9][0-9]$"),"Amount has more than 2 digits after decimal");
		transferPage.clearAmountField();
		transferPage.enterAmount(currencyFormatAmount);
		common.dismissKeyboardShown();
		transferPage.tapDescriptionField();
		enterByKeyboard(maxDescriptionCharactors);
		Assert.assertTrue(transferPage.getDescriptionText().length()<=18,"Description field has more than 18 charactors");
		common.dismissKeyboardShown();
		Assert.assertTrue(transferPage.getAmountFieldValue().matches("^\\$[0-9],[0-9]{3}\\.[0-9][0-9]$"),"Amount format is incorrect");
		
	}
	
	@TestDetails(story1 = "DMPM-4371:DMPM-11151,DMPM-11154",story2="DMPM-10946:DMPM-11185",priority = Priority.LOW)
	@Test (dataProvider = "TransferPayEntryPoint",groups = {"marketplace", "Transfer to self", "priority-minor"})
	public void testSelfTransferRecieptScreen(String entryPoint) {

		String userName = utils.readTestData("transferToSelf","userAccount1","login");
		String pwd = utils.readTestData("transferToSelf","userAccount1","pwd");
		String fromAccountNameOnMoney = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayName");
		String fromAccountName = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayNameOnFromScreen");
		String toAccountName = utils.readTestData("transferToSelf","userAccount1","toAccountdisplayNameOnToScreen");
		String amount = utils.readTestData("transferToSelf","userAccount1","amount");
		String fromAccountBSB = utils.readTestData("transferToSelf","userAccount1","fromBSB");
		String toAccountBSB = utils.readTestData("transferToSelf","userAccount1","toBSB");
		String fromAccountNumber = utils.readTestData("transferToSelf","userAccount1","fromAccountNumber");
		String toAccountNumber = utils.readTestData("transferToSelf","userAccount1","toAccountNumber");
		
		navigateToTransferScreen(userName,pwd,entryPoint,fromAccountNameOnMoney);
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		transferPage.enterAmount(amount);
		common.dismissKeyboardShown();
		transferPage.tapNextButton();
		Assert.assertEquals(transferSummaryPage.getDisclaimerLabel(),Copy.TRANSFER_DISCLAIMER_MESSAGE,"Transfer disclaimer message is incorrect");
		transferSummaryPage.tapTransferNowButton();
		Assert.assertEquals(Copy.TRANSFER_COMPLETE_SUCCESS_MESSAGE,transferRecieptPage.getReceiptMessage(),"Success Message is not displayed");
		Assert.assertTrue(transferRecieptPage.getReceiptNumber().matches("\\b\\d{10}\\b"),"Reciept number not displayed");
		Assert.assertEquals(transferRecieptPage.getFromAccountName(),fromAccountName,"From Account Name is not displayed");
		Assert.assertEquals(transferRecieptPage.getfromAccountNumberAndBSB(),fromAccountBSB+" "+fromAccountNumber,"From Account number and BSB are incorrect");
		Assert.assertEquals(transferRecieptPage.getToAccountName(),toAccountName,"To Account Name is not displayed");
		Assert.assertEquals(transferRecieptPage.getToAccountNumberAndBSB(),toAccountBSB+" "+toAccountNumber,"To Account number and BSB are incorrect");
		Assert.assertEquals(transferRecieptPage.getWhenDate(),utils.getDate("dd MMM yyyy"),"Date is incorrect");
		Assert.assertEquals(transferRecieptPage.getAmount(),"$"+amount,"Amount is not displayed correctly");
		transferRecieptPage.tapBackToAccountsButton();
		Assert.assertNotNull(moneyPage.checkTransferPayButton(), "Not Money Dimension Page");
		
	}
	
	@TestDetails(story1 = "DMPM-4371:DMPM-11153,",priority = Priority.LOW)
	@Test (dataProvider = "TransferPayEntryPoint",groups = {"marketplace", "Transfer to self", "priority-minor"})
	public void testMakeAnotherPaymentFromRecieptScreen(String entryPoint) {

		String userName = utils.readTestData("transferToSelf","userAccount1","login");
		String pwd = utils.readTestData("transferToSelf","userAccount1","pwd");
		String fromAccountName = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayNameOnFromScreen");
		String fromAccountNameOnMoney = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayName");
		String toAccountName = utils.readTestData("transferToSelf","userAccount1","toAccountdisplayNameOnToScreen");
		String amount = utils.readTestData("transferToSelf","userAccount1","amount");
		
		navigateToTransferScreen(userName,pwd,entryPoint,fromAccountNameOnMoney);
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		transferPage.enterAmount(amount);
		common.dismissKeyboardShown();
		transferPage.tapNextButton();
		transferSummaryPage.tapTransferNowButton();
		Assert.assertEquals(Copy.TRANSFER_COMPLETE_SUCCESS_MESSAGE,transferRecieptPage.getReceiptMessage(),"Success Message is not displayed");
		transferRecieptPage.tapMakeAnotherPaymentButton();
		Assert.assertNotNull(transferPage.checkTransferPageTtile(Copy.TRANSFER_TITLE), "Not on transfer page");
		Assert.assertNotNull(transferPage.checkSelectFromAccountButton(),"Select From Account Button is not displayed");
		Assert.assertNotNull(transferPage.checkSelectToAccountButton(),"Select To Account Button is not displayed");
		Assert.assertEquals(transferPage.getAmountFieldValue(),"","Amount field is not empty");
		Assert.assertEquals(transferPage.getDescriptionFieldValue(),"","Description field is not empty");
		
	}
	
	@TestDetails(story1 = "DMPM-4371:DMPM-11155",priority = Priority.LOW)
	@Test (groups = {"marketplace", "Transfer to self", "priority-minor"})
	public void testNavigateFromRecieptByDeviceBackButton() {

		String userName = utils.readTestData("transferToSelf","userAccount1","login");
		String pwd = utils.readTestData("transferToSelf","userAccount1","pwd");
		String fromAccountName = utils.readTestData("transferToSelf","userAccount1","fromAccountdisplayNameOnFromScreen");
		String toAccountName = utils.readTestData("transferToSelf","userAccount1","toAccountdisplayNameOnToScreen");
		String amount = utils.readTestData("transferToSelf","userAccount1","amount");
		
		navigateToTransferScreen(userName,pwd,"moneyFlow");
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		transferPage.enterAmount(amount);
		common.dismissKeyboardShown();
		transferPage.tapNextButton();
		transferSummaryPage.tapTransferNowButton();
		Assert.assertEquals(Copy.TRANSFER_COMPLETE_SUCCESS_MESSAGE,transferRecieptPage.getReceiptMessage(),"Success Message is not displayed");
		common.tapDeviceBackButton();
		Assert.assertNotNull(moneyPage.checkTransferPayButton(), "Not MoneyDimension Page");
		
	}

	@TestDetails(story1 = "DMPM-4356:DMPM-9857", priority = Priority.LOW)
	@Test(groups = { "marketplace", "Transfer to self", "priority-minor" })
	public void testAmountAndDescriptionFocus() {

		String userName = utils.readTestData("transferToSelf", "userAccount1", "login");
		String pwd = utils.readTestData("transferToSelf", "userAccount1", "pwd");
		String fromAccountName = utils.readTestData("transferToSelf", "userAccount1",
				"fromAccountdisplayNameOnFromScreen");
		String toAccountName = utils.readTestData("transferToSelf", "userAccount1", "toAccountdisplayNameOnToScreen");
		String amount = utils.readTestData("transferToSelf", "userAccount1", "amount");
		String description = utils.readTestData("transferToSelf","userAccount1","description");

		navigateToTransferScreen(userName, pwd, "moneyFlow");
		transferPage.tapSelectFromAccount();
		common.waitForLoadingIndicatorToDisappear();
		fromAccountPage.chooseFromAccount(fromAccountName);
		transferPage.tapSelectToAccount();
		common.waitForLoadingIndicatorToDisappear();
		toAccountPage.chooseToAccount(toAccountName);
		transferPage.checkAmountField();
		common.dismissKeyboardShown();
		transferPage.tapDescriptionField();
		transferPage.enterDescriptionField(description);
		common.dismissKeyboardShown();
		Assert.assertFalse(transferPage.isNextButtonEnabled(), "Next button is enabled");
		transferPage.tapAmountField();
		transferPage.enterAmount(amount);
		common.dismissKeyboardShown();
		Assert.assertTrue(transferPage.isNextButtonEnabled(), "Next button is disabled");

	}
	

	private void navigateToTransferScreen(String userName, String pwd, String flow, String... accountName) {

		loginToApp(userName, pwd);
		landingPage.tapMoneyTab();
		moneyPage.checkTransferPayButton();
		if (flow.equalsIgnoreCase("moneyFlow")) {
			moneyPage.tapTransferPayButton();

		} else if (flow.equalsIgnoreCase("transactionsFlow")) {
			moneyPage.tapAccountName(accountName[0]);
			transactionsPage.tapTransferPayButton();
		}
		moneyPage.tapTransferToSelfButton();
		Assert.assertNotNull(transferPage.checkTransferPageTtile(Copy.TRANSFER_TITLE),
				"Not on transfer page");

	}
	
	private void assertTransferSummaryScreen(String exptdFromAccountName, String exptdToAccountName, String amount,
			String fromAccountBSB, String toAccountBSB, String fromAccountNumber, String toAccountNumber,
			String exptdFromAvailableBalance, String exptdToAvailableBalance) {

		Assert.assertEquals(transferSummaryPage.getFromAccountName(), exptdFromAccountName,"From Account name is not correct");
		Assert.assertEquals(transferSummaryPage.getToAccountName(), exptdToAccountName,"To Account name is not correct");
		Assert.assertEquals(transferSummaryPage.getFromAccountBSB(), fromAccountBSB,"From Account BSB is not correct");
		Assert.assertEquals(transferSummaryPage.getToAccountBSB(), toAccountBSB,"To Account BSB is not correct");
		Assert.assertEquals(transferSummaryPage.getFromAccountNumber(), fromAccountNumber,"From account number is incorrect");
		Assert.assertEquals(transferSummaryPage.getToAccountNumber(), toAccountNumber,"To account number is not correct");
		Assert.assertEquals(transferSummaryPage.getTransferAmount(), "$" + amount,"Amount is incorrect");
		Assert.assertEquals(transferSummaryPage.getFromAccountBalance(),exptdFromAvailableBalance,"From available balance is incorrect");
		Assert.assertEquals(transferSummaryPage.getToAccountBalance(), exptdToAvailableBalance,"To available balance is incorrect");
		Assert.assertEquals(transferSummaryPage.getWhenValue(), Copy.WHEN,"When value is incorrect");

	}
	
	private void enterByKeyboard(String amount) {
		
		for(int i=0;i<amount.length();i++) {
			
			keyboard.enterKeyUsingKeyboard(amount.charAt(i));
		}
		
	}

}
