package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import automation.framework.common.BaseTest;
import automation.framework.utils.AutoUtilities;
import automation.framework.utils.FluentAssert;
import pages.marketplace.articles.ArticlesPage;
import pages.marketplace.auth.login.LoginAuthPage;
import pages.marketplace.auth.login.LoginPage;
import pages.marketplace.auth.pin.EnterCurrentPINPage;
import pages.marketplace.auth.pin.ForgotPINPage;
import pages.marketplace.auth.pin.PINAuthPage;
import pages.marketplace.auth.pin.PINCustomKeypad;
import pages.marketplace.auth.pin.PINOptionsPage;
import pages.marketplace.auth.pin.PINSetupPage;
import pages.marketplace.auth.registration.GetStartedPage;
import pages.marketplace.auth.registration.MemberLoginPage;
import pages.marketplace.auth.registration.RegistrationPage;
import pages.marketplace.auth.registration.TermsAndConditionsPage;
import pages.marketplace.chatbot.ChatbotPage;
import pages.marketplace.claimdetails.ClaimDetailsPage;
import pages.marketplace.claimdetails.ClaimIntroPage;
import pages.marketplace.claimdetails.MakeAClaimPage;
import pages.marketplace.common.CameraPage;
import pages.marketplace.common.CommonPage;
import pages.marketplace.common.ConfigPage;
import pages.marketplace.common.DummyPageWithLinks;
import pages.marketplace.common.FAPISettingsPage;
import pages.marketplace.common.ForceUpdatePage;
import pages.marketplace.common.GalleryPage;
import pages.marketplace.common.Keyboard;
import pages.marketplace.common.WebviewPage;
import pages.marketplace.digitalVault.ChooseFolderPage;
import pages.marketplace.digitalVault.DigiVaultCommonPage;
import pages.marketplace.digitalVault.DigitalVaultPage;
import pages.marketplace.digitalVault.FolderViewPage;
import pages.marketplace.digitalVault.ImagePreviewPage;
import pages.marketplace.digitalVault.ImageViewPage;
import pages.marketplace.digitalVault.SelectItemsPage;
import pages.marketplace.landing.LandingPage;
import pages.marketplace.landing.NavigationMenuPage;
import pages.marketplace.landing.WelcomePage;
import pages.marketplace.money.CategoryBreakDownPage;
import pages.marketplace.money.FromAccountPage;
import pages.marketplace.money.MoneyPage;
import pages.marketplace.money.MoneyTrackerPage;
import pages.marketplace.money.ToAccountPage;
import pages.marketplace.money.TransactionsPage;
import pages.marketplace.money.TransferPage;
import pages.marketplace.money.TransferRecieptPage;
import pages.marketplace.money.TransferSummaryPage;
import pages.marketplace.vehicles.VehicleDetailsPage;
import pages.marketplace.vehicles.VehiclesPage;
import pages.marketplace.offers.OffersPage;
import pages.marketplace.portfolio.MyProductsPage;
import pages.marketplace.productCatalogue.PCHomePage;
import pages.marketplace.portfolio.PolicyDetailsPage;
import pages.marketplace.portfolio.RenewPolicyPage;
import pages.marketplace.portfolio.RiskDetailsPage;
import pages.marketplace.professionalServices.HomeProfessionalServicesPage;
import pages.marketplace.property.DemographicsPage;
import pages.marketplace.property.FeatureAccessControlPage;
import pages.marketplace.property.HomeJourneyPage;
import pages.marketplace.property.HomePropertyPage;
import pages.marketplace.property.PropertyDetailsPage;
import pages.marketplace.property.PropertyExplorerPage;
import pages.marketplace.settings.SettingsPage;
import pages.marketplace.portfolio.AddPolicyPage;
import pages.marketplace.portfolio.AddProductPage;
import pages.marketplace.portfolio.AccountDetailsPage;
import pages.marketplace.portfolio.AddBankAccountPage;
import pages.marketplace.wealth.CategoryDetailsPage;
import pages.marketplace.wealth.ConnectedAccountsPage;
import pages.marketplace.wealth.FinancePage;
import pages.marketplace.wealth.SpendingsPage;
import pages.marketplace.wealth.VendorDetailPage;
import pages.marketplace.property.WhatsNearbyPage;
import pages.marketplace.property.PropertyHubPage;
import pages.marketplace.property.SuburbDetailsPage;


public class App extends BaseTest {
	public AutoUtilities utils = null;
	public FluentAssert fluentAssert = null;	
	public WelcomePage welcomePage = null;
	public LoginPage loginPage = null;
	public GetStartedPage getStartedPage = null;
	public RegistrationPage registrationPage = null;
	public PINSetupPage pinSetupPage = null;
	public DummyPageWithLinks dummy = null;
	public PINAuthPage pinAuthPage = null;
	public ForgotPINPage forgotPINPage = null;
	public ConfigPage configPage = null;
	public PINCustomKeypad pinCustomKeypad = null;
	public CommonPage common = null;
	public NavigationMenuPage navigationMenu = null;
	public LandingPage landingPage = null;
	public HomePropertyPage homePropertyPage = null;
	public HomeJourneyPage homeJourneyPage = null;
	public FinancePage financePage = null;
	public SpendingsPage spendingsPage = null;
	public VehiclesPage vehiclesPage = null;
	public VehicleDetailsPage vehicleDetailsPage = null;
	public SettingsPage settingsPage = null;
	public ChatbotPage chatbotPage = null;
	protected OffersPage offersPage = null;
	public DigitalVaultPage digitalVaultPage = null;
	public FolderViewPage folderViewPage = null;
	public ImagePreviewPage imagePreviewPage = null;
	public CameraPage cameraPage = null;
	public GalleryPage galleryPage = null;		
	public LoginAuthPage loginAuthPage = null;
	public PINOptionsPage pinOptionsPage = null;
	public ImageViewPage imageViewPage = null;
	public ChooseFolderPage chooseFolderPage = null;
	public SelectItemsPage selectItemsPage = null;
	public DigiVaultCommonPage digiVaultCommonPage = null;
	public MyProductsPage myProductsPage = null;
	public AddPolicyPage addPolicyPage = null;
	public AddBankAccountPage addBankAccountPage = null;
	public AccountDetailsPage accountDetailsPage = null;
	public PCHomePage productCatalogueHomePage = null;
	public FAPISettingsPage fapiSettingsPage = null;
	public EnterCurrentPINPage enterCurrentPINPage=null;
	public PropertyExplorerPage propertyExplorerPage = null;
	public PropertyDetailsPage propertyDetailsPage = null;
	public HomeProfessionalServicesPage homeServicesPage = null;
	public PropertyHubPage propertyHubPage = null;
	public ArticlesPage articlesPage = null;
	public CategoryDetailsPage categoryDetailsPage = null;
	public WebviewPage webviewPage = null;
	public MemberLoginPage memberLoginPage = null;
	public VendorDetailPage vendorDetailPage = null;
	public ConnectedAccountsPage connectedAccountsPage = null;
	public WhatsNearbyPage whatsNearbyPage = null;
	public ForceUpdatePage forceUpdatePage = null;
	public SuburbDetailsPage suburbDetailsPage = null;
	public PolicyDetailsPage policyDetailsPage = null;
	public RiskDetailsPage riskDetailsPage = null;
	public RenewPolicyPage renewPolicyPage = null;
	public ClaimDetailsPage claimDetailsPage = null;
	public ClaimIntroPage claimIntroPage =null;
	public MakeAClaimPage makeAClaimPage =null;
	public TermsAndConditionsPage termsAndConditionsPage = null;
	public AddProductPage addProductPage = null;
	public MoneyPage moneyPage = null;
	public TransactionsPage transactionsPage = null;
	public MoneyTrackerPage moneyTrackerPage =null;
	public CategoryBreakDownPage categoryBreakDownPage=null;
	public TransferPage transferPage=null;
	public ToAccountPage toAccountPage = null;
	public FromAccountPage fromAccountPage = null;
	public TransferSummaryPage transferSummaryPage = null; 
	public Keyboard keyboard=null;
	public FeatureAccessControlPage featureAccessControlPage =null;
	public DemographicsPage demographicsPage = null;
	public TransferRecieptPage transferRecieptPage =null;
	
	String CONFIG_FILE=null;

	@Parameters({ "endPoint" })
	@BeforeClass
	public void initializeApp(@Optional("SYST") String endPoint) {
	
		 utils = new AutoUtilities();
		 String JSONFilePath = null;
		 
		 if(endPoint.equalsIgnoreCase("stub")) {
				// Autoutilites file path
				JSONFilePath = "/TestData/TestData_Stub.json";
		 } else {
				JSONFilePath = "/TestData/TestData_Test.json";
		 }
		 
		CONFIG_FILE = System.getProperty("user.dir")+"/Config/config.properties";
		utils.loadTestData(JSONFilePath);
		
		// Initializing the fleuntAssert object for global use.
		fluentAssert = new FluentAssert();

		// Initializing the various pages of the app for use across all tests
		welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);
		registrationPage = new RegistrationPage(driver);
		getStartedPage = new GetStartedPage(driver);
		pinSetupPage = new PINSetupPage(driver);
		dummy = new DummyPageWithLinks(driver);
		pinAuthPage = new PINAuthPage(driver);
		forgotPINPage = new ForgotPINPage(driver);
		welcomePage = new WelcomePage(driver);
		configPage = new ConfigPage(driver);
		pinCustomKeypad = new PINCustomKeypad(driver);
		common = new CommonPage(driver);
		navigationMenu = new NavigationMenuPage(driver);
		landingPage = new LandingPage(driver);
		homePropertyPage = new HomePropertyPage(driver);
		homeJourneyPage = new HomeJourneyPage(driver);
		financePage = new FinancePage(driver);
		spendingsPage = new SpendingsPage(driver);
		vehiclesPage = new VehiclesPage(driver);
		vehicleDetailsPage = new VehicleDetailsPage(driver);
		settingsPage = new SettingsPage(driver);
		chatbotPage = new ChatbotPage(driver);
		offersPage = new OffersPage(driver);
		digitalVaultPage = new DigitalVaultPage(driver);
		folderViewPage = new FolderViewPage(driver);
		imagePreviewPage = new ImagePreviewPage(driver);
		cameraPage = new CameraPage(driver);
		galleryPage = new GalleryPage(driver);
		loginAuthPage = new LoginAuthPage(driver);
		pinOptionsPage = new PINOptionsPage(driver);
		imageViewPage = new ImageViewPage(driver);
		chooseFolderPage = new ChooseFolderPage(driver);
		selectItemsPage = new SelectItemsPage(driver);
		digiVaultCommonPage = new DigiVaultCommonPage(driver);
		myProductsPage = new MyProductsPage(driver);
		addPolicyPage = new AddPolicyPage(driver);
		addBankAccountPage = new AddBankAccountPage(driver);
		accountDetailsPage = new AccountDetailsPage(driver);
		productCatalogueHomePage = new PCHomePage(driver);
		fapiSettingsPage = new FAPISettingsPage(driver);
		enterCurrentPINPage = new EnterCurrentPINPage(driver);
		propertyExplorerPage = new PropertyExplorerPage(driver);
		propertyDetailsPage = new PropertyDetailsPage(driver);
		webviewPage = new WebviewPage(driver);
		homeServicesPage = new HomeProfessionalServicesPage(driver);
		memberLoginPage = new MemberLoginPage(driver);
		whatsNearbyPage = new WhatsNearbyPage(driver);
		propertyHubPage = new PropertyHubPage(driver);
		forceUpdatePage = new ForceUpdatePage(driver);
		suburbDetailsPage = new SuburbDetailsPage(driver);
		articlesPage = new ArticlesPage(driver);
		policyDetailsPage = new PolicyDetailsPage(driver);
		riskDetailsPage = new RiskDetailsPage(driver);
		renewPolicyPage = new RenewPolicyPage(driver);
		claimDetailsPage = new ClaimDetailsPage(driver);
		claimIntroPage = new ClaimIntroPage(driver);
		makeAClaimPage = new MakeAClaimPage(driver);
		categoryDetailsPage = new CategoryDetailsPage(driver);
		vendorDetailPage = new VendorDetailPage(driver);
		connectedAccountsPage = new ConnectedAccountsPage(driver);
		propertyHubPage = new PropertyHubPage(driver);
		termsAndConditionsPage = new TermsAndConditionsPage(driver);
		addProductPage = new AddProductPage(driver);
		moneyPage = new MoneyPage(driver);
		transactionsPage = new TransactionsPage(driver);
		moneyTrackerPage = new MoneyTrackerPage(driver);
	    categoryBreakDownPage = new CategoryBreakDownPage(driver); 
	    transferPage = new TransferPage(driver);
	    toAccountPage = new ToAccountPage(driver);
	    fromAccountPage = new FromAccountPage(driver);
	    transferSummaryPage = new TransferSummaryPage(driver);
	    keyboard =new Keyboard(driver);
	    featureAccessControlPage = new FeatureAccessControlPage(driver);
	    demographicsPage = new DemographicsPage(driver);
	    transferRecieptPage = new TransferRecieptPage(driver);
	}
	

	@Parameters({ "endPoint" })

	@BeforeMethod(alwaysRun = true)
	public void beforeEachTest(@Optional("SYST") String endPoint) throws Exception {
		
		welcomePage.launchApp();
		
		configPage.dismissConfigPage(endPoint,CONFIG_FILE);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterEachTest() throws Exception {
		welcomePage.closeApp();
	}
	
	// If "MaybeLater" option should not be clicked from any of the scenarios then pass "DoNotTapMayBeLaterOption" as the third argument
	public void loginToApp(String login, String pwd, String... args) {
		if(loginAuthPage.checkChangeAccountButton() != null) {
			loginAuthPage.tapChangeAccountButton();
		}
		//Assert.assertNotNull(welcomePage.checkWelcomeSuncorpImage(), "Welcome screen - background is not shown");
		welcomePage.tapLoginButton();
		loginPage.enterLoginCredentials(login, pwd);
		
		loginPage.tapLoginButton();
		loginPage.waitForLoadingIndicatorToDismiss();
		
		if(termsAndConditionsPage.checkAcceptButton() != null) {
			termsAndConditionsPage.tapAcceptButton();
		}
		
		if(pinOptionsPage.checkMaybeLaterButton() != null && args.length < 1) {
			pinOptionsPage.tapMaybeLater();
		} else if(pinOptionsPage.checkMaybeLaterPromptButton() != null && args.length < 1) {
			pinOptionsPage.tapPromptMaybeLater();
		} else if (pinOptionsPage.checkEnableFingerprintBtn() != null && args.length < 1) {
			pinOptionsPage.tapPromptMaybeLater();
		}
	}
	
	//TODO : Remove
	public void loginWithPinOptions(String login, String pwd) {
		loginPage.enterLoginCredentials(login, pwd);
		loginPage.tapLoginButton();
	}
	/*
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		try {
			welcomePage.clearAppData();			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}*/
}
