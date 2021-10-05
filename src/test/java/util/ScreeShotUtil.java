package util;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class ScreeShotUtil {

    public static String screenshotPath = System.getProperty("user.dir")+"\\src\\test\\ScreenShots\\";



    public static void takesFullPageScreenShot(WebDriver driver)
    {
        Screenshot  sShot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).
               takeScreenshot(driver);
        //String dateTime = DateUtil.getCurrentDateTimeToString();
        try {
            ImageIO.write(sShot.getImage(),"jpg",new File(screenshotPath+"screenshot.jpg"
                    ));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
