package framework;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.util.Locale;

public class BrowserFactory {


/*public static WebDriver configureBrowserForTest(String browser) {
      browser=browser.toLowerCase();
  switch (browser)
  {
    case "chrome":
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      break;
    case "firefox":
      WebDriverManager.firefoxdriver().setup();
      driver= new FirefoxDriver();

  }


  return driver;
}*/
  public void configureBrowser(String browser) {
    browser=browser.toLowerCase();
    Configuration.browser=browser;
    Configuration.driverManagerEnabled=true;
    Configuration.fastSetValue=true;

  }
}
