package com.tran.qa16.manager;

import com.tran.qa16.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {
    public WebDriver wd;

    public GroupHelper(WebDriver wd) {

        super (wd);
    }

    public boolean isGroupPresent() {
        return isElementPresent (By.name ("selected[]"));
    }

    public void returnToTheGroupPage() {
        click (By.linkText ("group page"));
    }



    public void submitGroupCreation() {
        click (By.name ("submit"));
    }

    public void fillGroupsForm(GroupDate group) {
        type (By.name ("group_name"), group.getName ( ));

        type (By.name ("group_header"), group.getHeader ( ));

        type (By.name ("group_footer"), group.getFooter ( ));
    }



    public void initGroupCreation() {
        click (By.name ("new"));
    }

    public void returnToGroupsPage() {
        click (By.linkText ("group page"));
    }

    public void groupDeletion() {
        click (By.name ("delete"));
    }

    public void goToGroupsPage() {
        if (!isElementPresent (By.xpath ("//h1[contains(text(),'Groups')]"))
                && !isElementPresent (By.name ("new"))) {
            click (By.linkText ("groups"));
        }
    }
    public void selectGroup() {
        click (By.name ("selected[]"));
    }

    public int getGroupsCount() {
        return wd.findElements (By.cssSelector ("span.group")).size ( );
    }

    public void selectGroupByIndex(int ind) {
        wd.findElements (By.name ("selected[]")).get (ind).click ( );
    }

    public void submitGroupModification() {
        click (By.name ("update"));
    }

    public void initGroupModification() {
        click (By.name ("edit"));
    }

    public void createGroup() {
        initGroupCreation ( );
        fillGroupsForm (new GroupDate ( )
                .withName ("testGroupName1")
                .withHeader ("testGroupHeader1")
                .withFooter ("testGroupFooter1"));
        submitGroupCreation ( );
        returnToTheGroupPage ( );
    }
}
