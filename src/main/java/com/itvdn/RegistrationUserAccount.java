package com.itvdn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationUserAccount {
    private WebDriver driver;

    @FindBy(css = "#toTop > h1")
    WebElement title;

    public RegistrationUserAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTitle() {
        return title;
    }

}
