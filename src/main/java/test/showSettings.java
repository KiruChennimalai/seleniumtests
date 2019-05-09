package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonTestCase;

import static org.junit.Assert.fail;

public class showSettings extends CommonTestCase {

    @Test
    public void saveShow() {

        driver.get("https://blueprint.meteorapp.com/app/auth/login");

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.elementToBeClickable(By.name("userEmail")));
        }catch (NoSuchElementException e) {
            fail("Login page is not displayed:" + e.getMessage());
        }

        driver.findElement(By.name("userEmail")).clear();
        driver.findElement(By.name("userEmail")).sendKeys("admin@showhub.events");
        driver.findElement(By.id("userPassword")).clear();
        driver.findElement(By.id("userPassword")).sendKeys("abc123");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='You are online.'])[1]/following::div[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.elementToBeClickable(By.id("ShowSelectorSelected")));
        }catch (NoSuchElementException e) {
            fail("Floorplan page not displayed:" + e.getMessage());
        }
        driver.findElement(By.id("ShowSelectorSelected")).click();
        driver.findElement(By.id("ShowSelectorItemkinJeZFEuW6BpuqGW")).click();

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.elementToBeClickable(By.id("ShowSelectorSelected")));
        }catch (NoSuchElementException e) {
            fail("Floorplan page not reloaded after show selection:" + e.getMessage());
        }

        WebElement element = driver.findElement(By.xpath("//*[@id=\"AppNav\"]/nav/ul/li[4]/a/span[2]"));

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

        driver.findElement(By.xpath("//*[@id=\"AppNav\"]/nav/ul/li[4]/ul/li[1]/a")).click();

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("settings.extensions.api.enabled")));
        }catch (NoSuchElementException e) {
            fail("Settings page not displayed:" + e.getMessage());
        }

        driver.findElement(By.name("settings.extensions.api.enabled")).click();
        driver.findElement(By.name("settings.locale")).click();
        new Select(driver.findElement(By.name("settings.locale"))).selectByVisibleText("English (US)");
        driver.findElement(By.name("settings.locale")).click();
        driver.findElement(By.name("settings.units.measurement")).click();
        new Select(driver.findElement(By.name("settings.units.measurement"))).selectByVisibleText("Metres (m)");
        driver.findElement(By.name("settings.units.measurement")).click();
        driver.findElement(By.name("settings.units.currency")).click();
        new Select(driver.findElement(By.name("settings.units.currency"))).selectByVisibleText("United States Dollars - USD ($)");
        driver.findElement(By.name("settings.units.currency")).click();
        driver.findElement(By.name("slug")).click();
        driver.findElement(By.name("slug")).clear();
        driver.findElement(By.name("slug")).sendKeys("blueprintexpoSelenium");
        driver.findElement(By.xpath("//div[@id='render-target']/div")).click();
        driver.findElement(By.name("settings.profile.venueName")).clear();
        driver.findElement(By.name("settings.profile.venueName")).sendKeys("Arena business centre");
        driver.findElement(By.name("settings.profile.address")).clear();
        driver.findElement(By.name("settings.profile.address")).sendKeys("Farnborough");
        driver.findElement(By.name("settings.profile.zipcode")).clear();
        driver.findElement(By.name("settings.profile.zipcode")).sendKeys("gu14 7na");
        driver.findElement(By.xpath("//*[@id=\"SettingsShowSettings\"]/div[3]/div[2]/div/div[2]/div/button")).click();

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("Toastify__toast-body")));
        }catch (NoSuchElementException e) {
            fail("Settings page not displayed:" + e.getMessage());
        }

        Assert.assertFalse((driver.findElements(By.className("Toastify__toast-body")).isEmpty()));

    }


}



