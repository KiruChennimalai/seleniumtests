/**
 * Created by kchennimalai on 30/11/2017.
 */
package utilities;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CommonTestCase extends WebDriverProvider {

    protected WebDriver driver;

    @Rule
    public ScreenShotOnFailure screenShootOnFailureRule = new ScreenShotOnFailure();

    @Before
    public void getDriver() throws IOException{

        String driverName = "chrome";
        try{

            if (System.getenv("driver") != null) {
                driverName = System.getenv("driver");
                if (driverName.length() != 0) {
                    driverName = driverName.trim().toLowerCase();
                }
            }
            if (System.getProperty("driver") != null) {
                driverName = System.getProperty("driver");
                if (driverName.length() != 0) {
                    driverName = driverName.trim().toLowerCase();
                }
            }

        } catch (NullPointerException e) {

        }

        if (driverName.startsWith("chrome")) {
            System.out.println("Using chrome driver");
             driver = Chrome();
        } else if (driverName.startsWith("firefox")) {
            System.out.println("Using firefox driver");
             driver = Firefox();
        }

        screenShootOnFailureRule.setDriver(driver);

    }

}
