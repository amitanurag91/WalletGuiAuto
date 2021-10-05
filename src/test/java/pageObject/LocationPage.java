package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocationPage {

    public SelenideElement issuerNameInput = $(By.xpath("//div[contains(@property,'values.location.isAware')]"));
}
