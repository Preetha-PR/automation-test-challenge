package com.pan.pages.pagecomponents.homepage;

import com.pan.utils.PageActionsHelper;
import org.openqa.selenium.By;

public class SearchComponent {

    private static final String SEARCH_BOX="//input[@name='search']";
    private static final String SEARCH_CLICK=SEARCH_BOX+"/following-sibling::span/button";

    public SearchComponent keySearchItem(String itemName){
        PageActionsHelper.waitAndSendKeys(By.xpath(SEARCH_BOX),itemName,"Search");
        return this;
    }

    public SearchComponent clickSearchButton(){
        PageActionsHelper.waitAndClick(By.xpath(SEARCH_CLICK), "Search Button");
        return this;
    }

}
