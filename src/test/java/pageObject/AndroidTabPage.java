package pageObject;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AndroidTabPage {

    public SelenideElement issuerNameInput = $("input[name='issuerName']");
    public SelenideElement programNameInput = $("input[name='programName']");
    public SelenideElement accDescription = $(By.xpath("//input[@name='description']"));
    public  SelenideElement logoText =$(By.xpath("//input[@ng-model='values.apple.logoText']"));
    public SelenideElement headerFieldTab = $(By.xpath("//div[contains(text(),'Header')]"));
    public SelenideElement addHeaderIcon = $(By.xpath("//div[contains(@ng-show,'header')]//div[text()='Add']"));
    public SelenideElement androidTab =$(By.xpath("//div[contains(@class,'leftNavIcon-android')]"));

    public Faker faker;

    public AndroidTabPage()
    {
        faker = new Faker();
    }


    public void androidSpecificFields()
    {
        androidTab.click();
        issuerNameInput.sendKeys(faker.commerce().productName());
        programNameInput.sendKeys(faker.company().industry());
    }
    

}
