package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LandingPageCreation {

    public SelenideElement barcodeValueInput = $(By.xpath("(//input[@ng-model='system.data.barcode.value'])[1]"));
    public SelenideElement loyaltyAccName = $("input[ng-model='system.data.loyaltyAccountName']");
    public SelenideElement loyaltyAccId= $("input[ng-model='system.data.loyaltyAccountId']");
    public SelenideElement createButton =$(By.xpath("(//button[contains(@ng-click,'system.createLink()')])[1]"));
    public SelenideElement passHtmlLink = $(By.xpath("(//div[@ng-show='system.campaignLink'])[1]"));
    public SelenideElement landingPageOkBtn = $(By.xpath("(//button[contains(@ng-click,'system.createLinkClose()')])[1]"));

    public LandingPageCreation()
    {

    }











}
