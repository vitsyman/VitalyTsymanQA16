package com.tran.qa16;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation(){
        initContactCreation();
        fillContactForm();
        createContact();
    }

    private void createContact() {
    }

    private void fillContactForm() {
    }

    private void initContactCreation() {

    }
}
