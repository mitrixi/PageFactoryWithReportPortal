package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    WebDriver driver;

    public DriverWrapper() {
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
//        this.driver = new ChromeDriver();
    }

    public void init() {
        this.driver = new ChromeDriver();
        this.driver.get("https://itvdn.com/ru");
        this.driver.manage().window().maximize();
//        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        this.driver.quit();
    }
}
