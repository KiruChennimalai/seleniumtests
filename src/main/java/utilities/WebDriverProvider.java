package utilities;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;

/**
 * Created by kchennimalai on 01/12/2017.
 */
public class WebDriverProvider {

    public static WebDriver driver;

    public WebDriver Chrome(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;

    }

    public WebDriver Firefox(){

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;

    }

}
