package com.tran.qa16;

import com.tran.qa16.tests.TestBase;
import org.testng.annotations.Test;

public abstract class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation(){
        app.initContactCreation ();
        app.fillContactForm (new ContactDate("qwert", "tyui", "asdfg123"));
        app.createContact ();
    }
    @Test
    public void testContactCreation1(){
        app.initContactCreation ();
        app.fillContactForm (new ContactDate("qsdft", "asdyui", "asdfg123"));
        app.createContact ();
    }
}
