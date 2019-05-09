package utilities;

/**
 * Created by kchennimalai on 08/12/2017.
 */

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotOnFailure implements MethodRule{

    private static WebDriver driver;

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {

                    System.out.println("Running: " + frameworkMethod.getMethod().getDeclaringClass().getCanonicalName() + "." + frameworkMethod.getName());
                    statement.evaluate();

                } catch (Throwable t) {
                    // exception will be thrown only when a test fails.
                    System.out.println("Starting screen shoot capture");
                    captureScreenShot(frameworkMethod.getMethod().getDeclaringClass().getCanonicalName(), frameworkMethod.getName());
                    System.out.println("End screen shoot capture");

                    // rethrow to allow the failure to be reported by JUnit
                    t.printStackTrace();

                    throw t;
                } finally {

                    teardown();
                }

        }

            public void captureScreenShot(String className, String methodName) throws IOException, InterruptedException, NoSuchElementException {
                try {

                    Date date = new Date();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");

                    Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
                    ImageIO.write(screenshot.getImage(), "PNG", new File("C:\\Users\\kchennimalai\\Desktop\\" + className + dateFormat.format(date)+ ".png"));

                } catch (Exception e) {
                    System.out.println("Unknown error while trying to take a screenshoot: " + e.getMessage() + " Url: " + (driver != null ? driver.getCurrentUrl() : "No driver object"));
                }
            }

        };
    }

    public void teardown(){

            if(driver!=null){
                driver.quit();
            }
        }


    public void setDriver(WebDriver d) {
        driver = d;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
