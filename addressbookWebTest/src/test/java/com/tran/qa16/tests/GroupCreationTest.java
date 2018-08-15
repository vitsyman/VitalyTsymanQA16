package com.tran.qa16.tests;

import com.tran.qa16.GroupDate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getGroupHelper ( ).goToGroupsPage ();
        int before = app.getGroupHelper ( ).getGroupsCount ();
        app.getGroupHelper ( ).initGroupCreation ();
        app.getGroupHelper ( ).fillGroupsForm (new GroupDate ()
                .withName("testGroupName1")
                .withHeader( "testGroupHeader1")
                .withFooter( "testGroupFooter1"));
        app.getGroupHelper ( ).submitGroupCreation ();
        app.getGroupHelper ( ).returnToTheGroupPage ();
        int after = app.getGroupHelper ( ).getGroupsCount ();

        Assert.assertEquals(after,before+1);
    }

    @Test
    public void testGroupCreationWithEmptyFields() {
        app.getGroupHelper ( ).goToGroupsPage ();
        app.getGroupHelper ( ).initGroupCreation ();
        app.getGroupHelper ( ).fillGroupsForm (new GroupDate().
                withName("").
                withHeader( "").
                withFooter(""));
        app.getGroupHelper ( ).submitGroupCreation ();
        app.getGroupHelper ( ).returnToTheGroupPage ();
    }

    @Test
    public void testGroupCreationWithLongName() {
        app.getGroupHelper ( ).goToGroupsPage ();
        app.getGroupHelper ( ).initGroupCreation ();
        app.getGroupHelper ( ).fillGroupsForm (new GroupDate().
                withName("testGroupName1oooooooooooooooooooooooooooooo").
                withHeader( "testGroupHeader1000000000000000000000000000").
                withFooter( "testGroupFooter1iiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
        app.getGroupHelper ( ).submitGroupCreation ();
        app.getGroupHelper ( ).returnToTheGroupPage ();
    }


}
