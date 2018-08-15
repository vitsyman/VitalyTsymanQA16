package com.tran.qa16.manager;

import com.tran.qa16.ContactDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public WebDriver wd;
 SessionHelper sessionHelper ;
    GroupHelper groupHelper ;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if(browser.equals (BrowserType.CHROME)){


        wd = new ChromeDriver ();
        }else if(browser.equals (BrowserType.FIREFOX)){
            wd = new FirefoxDriver ();
        }

        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        sessionHelper= new SessionHelper (wd);
        sessionHelper.openSite ("http://localhost/addressbook/");
        sessionHelper.login ("admin", "secret");
        groupHelper = new GroupHelper (wd);
    }

    public void exit() {
        stop ( );
    }

    public void stop() {
        wd.quit();
    }
    //public void click(By locator) {
       // wd.findElement (locator).click ( );
   // }

    public void createContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactDate contactDate) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactDate.getFirstname());

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactDate.getLastname());

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactDate.getAddress());
    }

    public boolean isElementPresent(By locator){
        try{
            wd.findElement(locator);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public boolean isGroupPresent(){
        return isElementPresent (By.name ("selected[]"));
    }

    public void initContactCreation() {

    }

    public boolean isElementsPresent(By locator){
      return wd.findElements(locator).size ()>0;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
