package com.itvdn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JavaDeveloperPage {
    private WebDriver driver;

    @FindBy(css = ".accordion__toggle")
    List<WebElement> listQuestions;

    public JavaDeveloperPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getListQuestions() {
        return listQuestions;
    }
}
