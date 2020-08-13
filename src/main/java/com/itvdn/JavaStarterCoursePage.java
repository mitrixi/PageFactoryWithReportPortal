package com.itvdn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaStarterCoursePage {
    private WebDriver driver;

    @FindBy(css = ".included-in-spec__specialities > a")
    WebElement button;

    public JavaStarterCoursePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getButton() {
        return button;
    }
}
