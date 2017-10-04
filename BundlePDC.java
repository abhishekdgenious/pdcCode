package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BundlePDC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://dc.hmhco.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBundlePDC() throws Exception {
    driver.get(baseUrl + "/hmhstorefront/dashboard");
    driver.findElement(By.linkText("BUNDLES")).click();
    driver.findElement(By.linkText("Create Bundles")).click();
    driver.findElement(By.cssSelector("input.createBudleAdd")).click();
    driver.findElement(By.id("createBundleBtn")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("25sepbundle1");
    driver.findElement(By.id("subject")).clear();
    driver.findElement(By.id("subject")).sendKeys("sci");
    driver.findElement(By.id("grade")).clear();
    driver.findElement(By.id("grade")).sendKeys("1");
    driver.findElement(By.id("quantity")).click();
    driver.findElement(By.id("quantity")).clear();
    driver.findElement(By.id("quantity")).sendKeys("1");
    driver.findElement(By.id("emailConfirmation")).click();
    driver.findElement(By.cssSelector("input.form")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
