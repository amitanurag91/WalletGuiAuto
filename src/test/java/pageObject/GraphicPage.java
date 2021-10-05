package pageObject;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import framework.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class GraphicPage {

    public SelenideElement androidTab = $("a[value='Android']");
    public SelenideElement appleTab = $("a[value='Apple']");
    public SelenideElement androidBackgrndColor = $(xpath("//div[contains(@ng-click,'androidCardBackgroundColor')]"));
    public SelenideElement appleBackgndColor = $(xpath("//div[contains(@ng-click,'appleBackgroundColor')]"));
    public SelenideElement appleTextLabelColor =$(xpath("//div[contains(@ng-click,'appleTextLabelColor')]"));
    public  SelenideElement appleValueTextColor =$(xpath("//div[contains(@ng-click,'appleValueTextColor')]"));
    public  SelenideElement randomColourSelection =$(xpath("//div[contains(@style,'background')  and contains(@style,'crosshair')]"));
    public List<SelenideElement> browseFiles = $$(xpath("//div[contains(@image-obj,'values.graphics')]//input[contains(@file-change,'onFilesBrowsed')]"));
    public SelenideElement iconImageBrowseFile = $(xpath("//div[contains(@image-obj,'values.images[0]')]//input[contains(@file-change,'onFiles')]"));
    public SelenideElement logoImageBrowseFile = $(xpath("//div[contains(@image-obj,'values.images[1]')]//input[contains(@file-change,'onFiles')]"));
    public SelenideElement graphicTab =$(xpath("//div[contains(@class,'leftNavIcon-graphics')]"));
    public SelenideElement stripImageLabel = $(xpath("//div[contains(@label,'Strip Image')]"));
    public String logoImageFileLocation = "C:\\Users\\amit.a\\Documents\\Imi Wallet\\image.png";
    public String appleLogoImageFileLocation ="C:\\Users\\amit.a\\Documents\\Imi Wallet\\Event-PNG-Photo.png";


    BaseActions actions;
    JavascriptExecutor jsx;
    WebDriverWait wait ;



    public GraphicPage(WebDriver driver)
    {
        actions = new BaseActions();
        jsx = ((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver,7000);

    }

    public void pickColorAndImagesAndroid()
    {
        graphicTab.click();
        androidTab.click();
        //androidBackgrndColor.click();
        wait.until(ExpectedConditions.elementToBeClickable(androidBackgrndColor));
       // jsx.executeScript("arguments[0].click();",androidBackgrndColor);
        actions.clickOnElement(androidBackgrndColor);
        randomColourSelection.click();
        browseFiles.get(0).sendKeys(logoImageFileLocation);
    }

    public void pickColorAndImagesApple()
    {
        wait.until(ExpectedConditions.elementToBeClickable(appleTab));
        appleTab.click();
        appleBackgndColor.click();
        randomColourSelection.click();
        appleTextLabelColor.click();
        randomColourSelection.click();
        appleValueTextColor.click();
        randomColourSelection.click();
        stripImageLabel.click();
        iconImageBrowseFile.sendKeys(logoImageFileLocation);
        logoImageBrowseFile.sendKeys(appleLogoImageFileLocation);

    }
}
