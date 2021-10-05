package framework;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;

public class UtilClass {
    WebDriverWait wait;
    JavascriptExecutor jsx;
    Faker faker;

    public UtilClass(WebDriver driver)
    {
        jsx= (JavascriptExecutor)driver;
        faker = new Faker();
    }

    public int generateRandomNumber(int min,int max)
    {
        return ThreadLocalRandom.current().nextInt(min,max-1);
    }
    public void scrollToView(SelenideElement s)
    {
        jsx.executeScript("arguments[0].scrollIntoView(true);",s);
    }

    public void pickRandomOptionFromDropDown(List<SelenideElement> dropDown,int n)
    {
        int size = dropDown.size();
        scrollToView(dropDown.get(size));
        dropDown.get(size).click();
    }

    public void pickSpecificOption(List<SelenideElement> dropDown,String optionName)
    {
        int size = dropDown.size();
        for(SelenideElement ele:dropDown) {
            scrollToView(ele);
            if(ele.getText().contains(optionName)) {
                ele.click();
            }
        }
    }


    public String generateRandomPassName(String passName)
    {
        String paasName="";
        switch (passName)
        {
            case "Loyalty":
               passName=faker.name().username()+faker.commerce()
                       .productName()+"Loyalty";
               break;
        }
         return passName;
    }
    public String generateRandomBarcode()
    {
        return faker.code().imei();
    }
    public String generateLoyaltyAccName()
    {
        return faker.commerce().productName();
    }
    public String generateLoyaltyAccId()
    {
        return faker.idNumber().valid();
    }




}
