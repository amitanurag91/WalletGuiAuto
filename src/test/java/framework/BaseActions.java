package framework;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.actions;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BaseActions {
    WebDriverWait wait;


    public BaseActions()
    {


    }

    public void clickOnElement(SelenideElement element)
    {
        waitUntilClickable(element);
        element.click();
    }
    public void enterTextIntoInput(String text,SelenideElement element)
    {
        waitForElementVisible(element);
       element.setValue(text);
    }

    public void clearInput(SelenideElement element)
    {
        waitForElementVisible(element);
        element.clear();
    }

    public void waitForElementVisible(SelenideElement element)
    {
        element.shouldBe(visible);
    }
    public void waitUntilClickable(SelenideElement element)
    {
        element.shouldBe(visible);
    }

    public void hoverToElement(SelenideElement element)
    {
        actions().moveToElement(element).build().perform();

    }

    public List<String> getAllWindows(WebDriver driver)
    {
        List<String> allWindows = new ArrayList();
        Set<String> windowsAvailable = driver.getWindowHandles();
        windowsAvailable.stream().forEach(x->allWindows.add(x));
        System.out.println("widndows present are:"+allWindows.size());
        return allWindows;
    }


}
