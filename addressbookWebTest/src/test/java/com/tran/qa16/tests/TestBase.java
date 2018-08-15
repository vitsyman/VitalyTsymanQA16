package com.tran.qa16.tests;

import com.tran.qa16.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {

   public ApplicationManager app = new ApplicationManager (System
           .getProperty ("browser",BrowserType.CHROME));

    @BeforeSuite
    public void setUp() {
        app.start ( );
    }

    @AfterSuite
    public void tearDown(){

        app.exit ();
    }

}