package com.itvdn;

import com.DriverWrapper;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(ReportPortalTestNGListener.class)
public class MainPageTest {

    private final DriverWrapper driverWrapper = new DriverWrapper();
    private final static Logger LOGGER = LogManager.getLogger("FileManager");

    @BeforeMethod
    void setUp() {
        LOGGER.info("Init driver");
        driverWrapper.init();
    }

    @AfterMethod
    void tearDown() {
        LOGGER.info("Close browser");
        driverWrapper.close();
    }

    @Test
    void search() {
        LOGGER.info("Search");
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.search("QA");
        SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
        List<WebElement> results = searchPage.getResults();
        assertEquals(10, results.size());
    }

    @Test
    public void findInHomeSearchAndSelectJavaDeveloper() {
        LOGGER.info("Find In Home Search And Select \"Java Developer\"");
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.findInHomeSearchAndSelectJavaDeveloper();
        JavaDeveloperPage javaDeveloperPage = new JavaDeveloperPage(driverWrapper.getDriver());

        assertEquals(6, javaDeveloperPage.getListQuestions().size());
    }

    @Test
    public void registrationUserAccount() {
        LOGGER.info("Registration User Account");
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.registrationUserAccount();
        RegistrationUserAccount registration = new RegistrationUserAccount(driverWrapper.getDriver());

        assertTrue(registration.getTitle().isDisplayed());
    }

    @Test
    public void openPageWithCatalogCourses() {
        LOGGER.info("Open Page With Catalog Courses");
        new MainPage(driverWrapper.getDriver()).openPageWithCatalogCourses();
        CatalogueCoursesPage catalogue = new CatalogueCoursesPage(driverWrapper.getDriver());

        assertEquals("Курсы программирования: каталог курсов по сложности, стоимости и авторству", catalogue.getTitle());
    }

    @Test
    public void openStudyingWithTrainer() {
        LOGGER.info("Open Studying With Trainer");
        new MainPage(driverWrapper.getDriver()).openStudyingWithTrainer();
        StudyWithTrainerPage studyWithTrainer = new StudyWithTrainerPage(driverWrapper.getDriver());

        assertTrue(studyWithTrainer.getButton().isEnabled());
    }
}