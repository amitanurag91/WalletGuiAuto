package testcases;

import com.aventstack.extentreports.ExtentTest;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import framework.ApiBaseClass;
import framework.BaseActions;
import framework.BrowserFactory;
import framework.UtilClass;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.*;
import reporting.ExtentReporterImpl;
import util.FileUtil;
import util.ScreeShotUtil;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import java.util.HashMap;

public class LoginDemoTest extends ExtentReporterImpl{

    LoginPage loginPage;
    ImIServicePage servicePage;
    WalletBuilderPage walletBuilderPage;
    UtilClass utilClass;
    GraphicPage graphicPage;
    MobileWalletPage walletPage;
    FileUtil fileUtil;
    WebDriver driver;
    BaseActions base;
    HashMap<String, String> appProp;
    AppleTabPage appleTabPage;
    AndroidTabPage androidTabPage;
    BarcodePage barcodePage;
    LandingPageCreation landCreate;
    AddWalletPage addWalletPage;
    WebDriverWait webWait;
    JavascriptExecutor jsx;
    public static String  methodName;
    ExtentTest test;
    ApiBaseClass apiBaseClass;



    @BeforeClass
    public void addAllureReports()
    {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    public void setBrowserConfig(String browser)
    {
        String browser1=browser.toLowerCase();
        //browser=browser.toLowerCase();
        Configuration.browser=browser1;
        Configuration.driverManagerEnabled=true;
        Configuration.fastSetValue=true;
    }


    @BeforeTest
    @Parameters({"browser","appUrl"})
    public void setUp(@Optional("chrome") String browser,String appUrl) {
        appProp = new HashMap<>();
        //fileUtil = new FileUtil();
        loginPage = new LoginPage();
        servicePage = new ImIServicePage();
        walletPage = new MobileWalletPage();
        appleTabPage = new AppleTabPage();
        androidTabPage = new AndroidTabPage();
        setBrowserConfig(browser);
        open(appUrl);
        this.driver = WebDriverRunner.getWebDriver();
        walletBuilderPage = new WalletBuilderPage(this.driver);
        utilClass = new UtilClass(this.driver);
        graphicPage = new GraphicPage(this.driver);
        barcodePage = new BarcodePage(this.driver);
        landCreate = new LandingPageCreation();
        apiBaseClass = new ApiBaseClass();
        getWebDriver().manage().window().maximize();
        base = new BaseActions();
        addWalletPage = new AddWalletPage();
        jsx = ((JavascriptExecutor)this.driver);
        webWait = new WebDriverWait(this.driver,8000);
        //appProp = fileUtil.getAppProperties();
        //this.driver.get(appUrl);

    }


    @Parameters({"userEmail","userPassword"})
    @Test
    public void loginTest(String userEmail,String userPassword) throws InterruptedException {
        methodName = Thread.currentThread()
                .getStackTrace()[1]
                .getMethodName();
        test = ExtentReporterImpl.createTestInReport(methodName);
        webWait.until(ExpectedConditions.visibilityOf(loginPage.welcomeHeader));
        loginPage.waitForWelcomeHeader();
        test.info("User is on login page");
        base.clearInput(loginPage.userEmailInput);
        base.enterTextIntoInput(userEmail, loginPage.userEmailInput);
        base.clickOnElement(loginPage.nextBtn);
        test.info("user enters email");
        base.clearInput(loginPage.userPasswrdInput);
        base.enterTextIntoInput(userPassword, loginPage.userPasswrdInput);
        test.info("password is entered by the user");
        base.clickOnElement(loginPage.submitBtn);
        test.info("submit button is successfully is clicked");
        servicePage.waitUntilPageHeaderVisible();
        System.out.println("1:"+methodName);
       // ScreeShotUtil.takesFullPageScreenShot(this.driver);
        base.hoverToElement(servicePage.appTrayIcon);
       // base.hoverToElement(servicePage.mobileWalletLink);
       base.clickOnElement(servicePage.mobileWalletLink);
       Thread.sleep(4000);
       Selenide.switchTo().window(base.getAllWindows(getWebDriver())
                  .get(1));
       //servicePage.mobileWalletLink.click();
        test.info("user clicked on wallet link from app tray");
        walletPage.waitUntilWalletBuilderPage();
        Assert.assertTrue(walletPage.newTemplateLink.isDisplayed());
        walletPage.newTemplateLink.click();
        walletBuilderPage.generalSetupAndSave();
        graphicPage.pickColorAndImagesAndroid();
        graphicPage.pickColorAndImagesApple();
        appleTabPage.appleCustomization(this.driver);
        androidTabPage.androidSpecificFields();
        barcodePage.pickRandomBarcode();
        webWait.until(ExpectedConditions.elementToBeClickable(walletBuilderPage.saveBtn));
        walletBuilderPage.saveBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(walletBuilderPage.saveOkBtn));
        walletBuilderPage.saveOkBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(walletBuilderPage.publishBtn));
        base.hoverToElement(walletBuilderPage.publishBtn);
        //actions().moveToElement(walletBuilderPage.publishBtn).click().build().perform();
        walletBuilderPage.publishBtn.click();
        walletBuilderPage.publishedWalletId.shouldBe(Condition.visible);
        String walletId = walletBuilderPage.walletIdTextField.getText().split("\\s+")[1];
        walletBuilderPage.saveOkBtn.click();
        walletBuilderPage.generateTestPassBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(landCreate.barcodeValueInput));
        landCreate.barcodeValueInput.sendKeys(utilClass.generateRandomBarcode());
        landCreate.loyaltyAccName.sendKeys(utilClass.generateLoyaltyAccName());
        landCreate.loyaltyAccId.sendKeys(utilClass.generateLoyaltyAccId());
        landCreate.createButton.click();
        webWait.until(ExpectedConditions.visibilityOf(landCreate.passHtmlLink));
        String passLink = landCreate.passHtmlLink.getText().trim();
        jsx.executeScript("window.open('');");
        Selenide.switchTo().window(base.getAllWindows(getWebDriver()).get(2));
        System.out.println("pass html link is:"+passLink);
        //actions().keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
        driver.get(passLink);
        webWait.until(ExpectedConditions.visibilityOf(addWalletPage.generateAndroidPass));
        addWalletPage.generateAndroidPass.shouldBe(Condition.visible);
        addWalletPage.generateApplePass.shouldBe(Condition.visible);
        apiBaseClass.creatWalletPass(walletId);

    }
    @Test
    public void testApi()
    {
        methodName = Thread.currentThread()
                .getStackTrace()[1]
                .getMethodName();
        test = ExtentReporterImpl.createTestInReport(methodName);
       // String passId=apiBaseClass.creatWalletPass("a377a7b1-6d21-4bd2-9da6-2db574420fe7");
      //  apiBaseClass.verifyGetPassDetails(passId);
       // apiBaseClass.validateUpdatePass(passId);
        apiBaseClass.getPublishedWallets();
    }

    @AfterMethod
    public void addResultToReport(ITestResult r) {
        System.out.println("2:"+methodName);
        ExtentReporterImpl.logResultToReport(r,methodName,test);

    }

    @AfterTest
    public void tearDown() {
      closeWebDriver();
    }



    @AfterClass
    public void flushReport() {
        ExtentReporterImpl.finalizeReport();
    }


}