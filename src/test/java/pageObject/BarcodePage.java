package pageObject;

import com.codeborne.selenide.SelenideElement;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BarcodePage {

    public SelenideElement barcodeDropDown = $("div[dropdown-select='system.barcodeTypes']");
    public List<SelenideElement> barcodeDropDownItems = $$("div[dropdown-select='system.barcodeTypes'] li a");
    public SelenideElement barcodeTab =$(By.cssSelector("div[id='configbarcode']"));
    public JavascriptExecutor jsx;




    public BarcodePage(WebDriver driver)
    {
        jsx =((JavascriptExecutor)driver);

    }

    public void pickRandomBarcode()
    {
        barcodeTab.click();
        barcodeDropDown.click();
        int randomIndex = ThreadLocalRandom.current().nextInt(0,barcodeDropDownItems.size()-1);
        jsx.executeScript("arguments[0].scrollIntoView(true);",barcodeDropDownItems.get(randomIndex));
        barcodeDropDownItems.get(randomIndex).click();
    }


    

}
