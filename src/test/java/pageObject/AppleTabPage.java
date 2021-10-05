package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

public class AppleTabPage {

    public SelenideElement frontTab = $(By.xpath("//form[@name='appleForm']//a[@value='applefront']"));
    public SelenideElement backTab = $(By.xpath("//form[@name='appleForm']//a[@value='appleback']"));
    public SelenideElement accDescription = $(By.xpath("//input[@name='description']"));
    public  SelenideElement logoText =$(By.xpath("//input[@ng-model='values.apple.logoText']"));
    public SelenideElement headerFieldTab = $(By.xpath("//div[contains(text(),'Header')]"));
    public SelenideElement addHeaderIcon = $(By.xpath("//div[contains(@ng-show,'header')]//div[text()='Add']"));
    public SelenideElement appleTab =$(By.xpath("//div[contains(@class,'leftNavIcon-apple')]"));

    public void appleCustomization(WebDriver driver)
    {
        new WebDriverWait(driver,4000);
        appleTab.click();
        frontTab.waitUntil(Condition.visible,7000);
        frontTab.click();
        accDescription.sendKeys("xyzyu");
    }


}
