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

public class LoginPage {


    public SelenideElement userEmailInput = $("input[name='email']");
    public SelenideElement userPasswrdInput =$("input[name='password'");
    public SelenideElement submitBtn =$("button[t-attr='loginBtn']");;
    public SelenideElement welcomeHeader =$("*[t-attr='welcomback']");
     public SelenideElement nextBtn =$("button[t-attr='loginNextBtn']");

    public void waitForWelcomeHeader()

    {
        welcomeHeader.shouldBe(Condition.visible);
    }


}
