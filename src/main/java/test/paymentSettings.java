package test;


import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonTestCase;


public class paymentSettings extends CommonTestCase {

    @Test
    public void testPaymentSettings()  {
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
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Show'])[1]/following::span[2]")).click();

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.elementToBeClickable(By.name("showPayment.paymentInformation.firstName")));
        }catch (NoSuchElementException e) {
            fail("Payment settings page not loaded" + e.getMessage());
        }

        driver.findElement(By.name("showPayment.paymentInformation.firstName")).click();
        driver.findElement(By.name("showPayment.paymentInformation.firstName")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.firstName")).sendKeys("Selenium");
        driver.findElement(By.name("showPayment.paymentInformation.lastName")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.lastName")).sendKeys("webdrivertest");
        driver.findElement(By.name("showPayment.paymentInformation.registeredCompanyName")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.registeredCompanyName")).sendKeys("Uitest");
        driver.findElement(By.name("showPayment.paymentInformation.companyNumber")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.companyNumber")).sendKeys("1305");
        driver.findElement(By.name("showPayment.paymentInformation.registeredAddress")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.registeredAddress")).sendKeys("Arena business center");
        driver.findElement(By.name("showPayment.paymentInformation.zipcode")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.zipcode")).sendKeys("gu52 5tx");
        driver.findElement(By.name("showPayment.paymentInformation.taxNumber")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.taxNumber")).sendKeys("12345");
        driver.findElement(By.name("showPayment.paymentInformation.email")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.email")).sendKeys("kiru.chennimalai@freemanco.com");
        driver.findElement(By.name("showPayment.paymentInformation.telephone")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.telephone")).sendKeys("01252641241");
        driver.findElement(By.name("showPayment.paymentInformation.invoiceNumberPrefix")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.invoiceNumberPrefix")).sendKeys("INV");
        driver.findElement(By.name("showPayment.paymentInformation.terms")).clear();
        driver.findElement(By.name("showPayment.paymentInformation.terms")).sendKeys("terms");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='terms'])[1]/following::button[1]")).click();

        try {
            WebDriverWait timer = new WebDriverWait(driver, 60);
            timer.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));
        }catch (NoSuchElementException e) {
            fail("Payment settings page not loaded" + e.getMessage());
        }

        assertEquals(driver.findElement(By.className("Toastify__toast-body")).getText(),"Your changes have been saved successfully" );
        System.out.println(driver.findElement(By.className("Toastify__toast-body")).getText());

    }
}

