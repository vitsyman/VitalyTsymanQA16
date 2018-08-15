package com.tran.qa16.tests;

import com.tran.qa16.GroupDate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {

        app.getGroupHelper ( ).goToGroupsPage ();
        if (!app.isGroupPresent ( )) {
            app.getGroupHelper ( ).createGroup ( );
        }
        int before = app.getGroupHelper ( ).getGroupsCount ();
        app.getGroupHelper ( ).selectGroup ();
       // initGroupCreation();
        app.getGroupHelper ( ).initGroupModification ();
        app.getGroupHelper ( ).fillGroupsForm (new GroupDate ()
                .withName("modifyedTestGroupName1")
                .withHeader("modifyedTestGroupHeader1")
                .withFooter("modifyedTestGroupFooter1"));
        app.getGroupHelper ( ).submitGroupModification ();
        app.getGroupHelper ( ).returnToGroupsPage ();
int after = app.getGroupHelper ( ).getGroupsCount ();
        Assert.assertEquals(after,before-1);

    }


}
