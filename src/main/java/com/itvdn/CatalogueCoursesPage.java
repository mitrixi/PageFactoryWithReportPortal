package com.itvdn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CatalogueCoursesPage {
    private final WebDriver driver;

    @FindBy(css = ".itvdnicon-video-catalog.menu-item-icon")
    WebElement itvdniconVideoCatalogMenuItemIcon;
    @FindBy(css = "a[href='/ru/video/java-starter'] div")
    WebElement courseJavaStarter;

    public CatalogueCoursesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void openCertainCourse() {
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".itvdnicon-video-catalog.menu-item-icon"))).click();
        itvdniconVideoCatalogMenuItemIcon.click();

//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", itvdniconVideoCatalogMenuItemIcon);

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.visibilityOf(courseJavaStarter));
        courseJavaStarter.click();


    }
}
