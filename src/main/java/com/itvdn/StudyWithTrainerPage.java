package com.itvdn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudyWithTrainerPage {
    private WebDriver driver;

    @FindBy(css = "face__button btn-filled-orange consultation-open-btn consult-btn-js")
    WebElement button;

    public StudyWithTrainerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getButton() {
        return button;
    }
}
