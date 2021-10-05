package pageObject;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImIServicePage {

    public SelenideElement serivcePageHeader= $("*[title='Services']");
    public SelenideElement appTrayIcon = $("svg[id='apptrayicon']");
    public SelenideElement mobileWalletLink= $(byXpath("//a[text()=' Mobile Wallet ']"));






    public void waitUntilPageHeaderVisible()
    {
        serivcePageHeader.waitUntil(Condition.visible,10000);
        serivcePageHeader.shouldBe(Condition.visible);
    }



}
