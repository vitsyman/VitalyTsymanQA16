import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.Locator;

import java.util.concurrent.TimeUnit;

public class Trello_Copy_Past {

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

    public class Trello {
        private WebDriver driver;

        @BeforeClass(alwaysRun = true)
        public void setUp()  {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }

        @Test
        public void testTrello() {
            openSite();
            driver.findElement(By.linkText("Зарегистрироваться")).click();
            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys("Vitaly");
            driver.findElement(By.id("email")).click();
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("vitsyman@gmail.com");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("signup")).click();
        }

        private void openSite() {
            driver.get("https://trello.com/");
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationError.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By locator) {
            try {
                driver.findElement(locator);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }

