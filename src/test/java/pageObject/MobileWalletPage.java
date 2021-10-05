package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

public class MobileWalletPage {


    public SelenideElement newTemplateLink = $("a[id='action-add']");


    public void waitUntilWalletBuilderPage()
    {

        newTemplateLink.waitUntil(Condition.visible,25000);
    }
}
