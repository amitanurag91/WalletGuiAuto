package pageObject;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import framework.BaseActions;
import framework.UtilClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WalletBuilderPage {

    public SelenideElement platFormDropDown = $("div[dropdown-select='system.platformTypes']");
    public SelenideElement walletName = $("input[name='name']");
    public SelenideElement expirationDate = $("input[ng-model='values.wallet.expirationDate']");
    public  SelenideElement passTypeDropDown =$("div[dropdown-model='values.passTypeSel']");
    public List<SelenideElement> platformTypeOptions = $$("div[dropdown-model='values.platformTypeSel'] ul li");
    public List<SelenideElement> passTypeOptions = $$("div[dropdown-model='values.passTypeSel'] ul li");
    public SelenideElement graphicTab =$(By.xpath("//div[contains(@class,'leftNavIcon-graphics')]"));
    public SelenideElement appleTab =$(By.xpath("//div[contains(@class,'leftNavIcon-apple')]"));
    public SelenideElement androidTab =$(By.xpath("//div[contains(@class,'leftNavIcon-android')]"));
    public SelenideElement landingPageTab =$(By.xpath("//div[contains(@class,'leftNavIcon-landing')]"));
    public SelenideElement barcodeTab =$(By.cssSelector("div[id='configbarcode']"));
    public SelenideElement geoLocationTab =$(By.cssSelector("div[id='configlocation']"));
    public SelenideElement confirmationTab =$(By.xpath("//div[contains(@class,'leftNavIcon-confirmation"));
    public SelenideElement publishBtn =$("div[class*='leftNavIcon-publish']");
    public SelenideElement saveBtn = $(By.xpath("//div[contains(@class,'configFooter')]//div[@id='action-save']"));
    public SelenideElement saveAsBtn = $(By.xpath("//div[contains(@class,'configFooter')]//div[@id='action-save-as']"));
    public SelenideElement undoBtn = $(By.xpath("//div[contains(@class,'configFooter')]//div[@id='action-revert']"));
    public SelenideElement saveOkBtn = $(By.xpath("(//button[contains(@ng-click,'closeSave')])[1]"));
    public SelenideElement publishedWalletId = $(By.xpath("//div[@id='savingCampaignResult']"));
    public SelenideElement walletIdTextField =$(By.xpath("(//div[@id='savingCampaignResult'])[1]"));
    public SelenideElement generateTestPassBtn = $(By.xpath("//div[@id='action-create-link']//div[contains(@ng-if,'publish')]"));


    BaseActions base;
    UtilClass utilClass;
    GraphicPage graphicPage;


    public WalletBuilderPage(WebDriver driver)
    {
         base = new BaseActions();
         utilClass = new UtilClass(driver);
        graphicPage = new GraphicPage(driver);
    }

    public void generalSetupAndSave()
    {
        base.waitUntilClickable(platFormDropDown);
        platFormDropDown.click();
        utilClass.pickSpecificOption(platformTypeOptions,"BOTH");
        base.enterTextIntoInput(utilClass.generateRandomPassName("Loyalty"),walletName);
        passTypeDropDown.click();
        utilClass.pickSpecificOption(passTypeOptions,"Loyalty");
        //saveBtn.click();
       // base.waitUntilClickable(saveOkBtn);
        //saveOkBtn.click();
    }



}
