package com.tran.qa16.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testlogin extends TestBase {
    @BeforeMethod
    public void  esurePreconditions(){
        app.getSessionHelper ().logout();
    }
    @Test
    public void loginTest(){
        app.getSessionHelper().login("admin","secret");

        Assert.assertTrue(app.isElementPresent (By.xpath ("//a[contains(text(),'Logout' ")));
    }
    @Test
    public void negativLoginTest(){
        app.getSessionHelper().login("admin","fgfhdhd");

        Assert.assertFalse (app.isElementPresent (By.xpath ("//a[contains(text(),'Logout')]" )));
    }
    @AfterMethod
    public void postconditionAfterLoginTest() {
        if (!app.getSessionHelper ( ).isLoggedIn ( )) {
            app.getSessionHelper ( ).login ("admin", "secret");
        }
    }
}
