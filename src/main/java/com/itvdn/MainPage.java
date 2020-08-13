package com.itvdn;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;

    @FindBy(css = "#search-on-top")
    WebElement searchElement;
    @FindBy(css = "input#home-search")
    WebElement homeSearch;
    @FindBy(css = "a[data-index='1']")
    WebElement foundOption;
    @FindBy(css = ".top-header .subscription-block a[href='/ru/account/register?jumpStart=true&returnUrl=/ru'")
    WebElement registration;
    @FindBy(css = ".itvdnicon-video-catalog.menu-item-icon")
    WebElement catalogCourses;
    @FindBy(css = "li.desktop.menu-liveonline-item a div span.menu-icon-EduWithTrainer.menu-item-icon")
    WebElement studyingWithTrainer;
    @FindBy(css = "//div[@class='dropdown-block lo-specialities']//span[text()='Java Developer']")
    WebElement javaDeveloperOption;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void search(final String query) {
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", searchElement);
        searchElement.click();
        searchElement.sendKeys(query);
        searchElement.sendKeys(Keys.ENTER);
    }

    public void findInHomeSearchAndSelectJavaDeveloper() {
        homeSearch.sendKeys("Java");
        new WebDriverWait(driver, 10, 500).until(webDriver -> foundOption.isDisplayed());
        foundOption.click();
    }

    public void registrationUserAccount() {
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", registration);
        new WebDriverWait(driver, 10, 500).until(ExpectedConditions.elementToBeClickable(registration)).click();
//        registration.click();
    }

    public void openPageWithCatalogCourses() {
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", catalogCourses);
        catalogCourses.click();
    }

    public void openStudyingWithTrainer() {
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", studyingWithTrainer);
        new WebDriverWait(driver, 20, 500).until(ExpectedConditions.visibilityOf(studyingWithTrainer)).click();
//        studyingWithTrainer.click();
        new WebDriverWait(driver, 20, 500).until(ExpectedConditions.visibilityOf(javaDeveloperOption)).click();
//        javaDeveloperOption.click();
    }
}
