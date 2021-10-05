package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddWalletPage {

    public SelenideElement generateAndroidPass = $(By.xpath("(//div[@id='googleButton'])[1]"));
    public SelenideElement generateApplePass = $(By.xpath("(//div[@id='appleButton']//a)[1]"));
    public AddWalletPage()
    {

    }











}
