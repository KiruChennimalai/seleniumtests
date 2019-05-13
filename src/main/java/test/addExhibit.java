package test;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonTestCase;

import static org.junit.Assert.fail;

public class addExhibit extends CommonTestCase {

     @Test
    public void testAddExhibit()  {
         driver.get("https://blueprint.meteorapp.com/app/auth/login ");

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

         /*driver.findElement(By.id("FloorplanEditorMap")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Text'])[2]/following::span[4]")).click();
        driver.findElement(By.id("FloorplanDetailStandExhibit-name")).click();
        driver.findElement(By.id("FloorplanDetailStandExhibit-name")).clear(); */

         driver.get("https://blueprint.meteorapp.com/app/stands/94uBhSzyyAfZDh3yH/exhibit/newExhibit");

         try {
             WebDriverWait timer = new WebDriverWait(driver, 60);
             timer.until(ExpectedConditions.elementToBeClickable(By.id("FloorplanDetailStandExhibit-name")));
         }catch (NoSuchElementException e) {
             fail("Floorplan page not reloaded after show selection:" + e.getMessage());
         }
        driver.findElement(By.id("FloorplanDetailStandExhibit-name")).sendKeys("test exhibit selenium");
        driver.findElement(By.id("FloorplanDetailStandExhibit-representative-firstName")).clear();
        driver.findElement(By.id("FloorplanDetailStandExhibit-representative-firstName")).sendKeys("Fname");
        driver.findElement(By.id("FloorplanDetailStandExhibit-representative-lastName")).clear();
        driver.findElement(By.id("FloorplanDetailStandExhibit-representative-lastName")).sendKeys("Lname");

        driver.findElement(By.xpath("//*[@id=\"FloorplanDetailModal\"]/div/div[2]/form/div[5]/button[3]")).click();



         try {
             WebDriverWait timer = new WebDriverWait(driver, 60);
             timer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"render-target\"]/div/div[2]/div/div/div[1]")));
         }catch (NoSuchElementException e) {
             fail("Floorplan page not displayed:" + e.getMessage());
         }
         driver.findElement(By.xpath("//*[@id=\"render-target\"]/div/div[2]/div/div/div[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"FloorplanHeaderDraftStatus-buttons\"]/button[2]")).click();
        System.out.println("Exhibit published successfully");


    }








}
