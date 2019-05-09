package test;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonTestCase;

import static org.junit.Assert.fail;

public class appLogin extends CommonTestCase {

    @Test
    public void login()  {
        driver.get("https://blueprint.meteorapp.com/app/auth/login");

        try {
            WebDriverWait timer = new WebDriverWait(driver, 20);
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
    }
}

