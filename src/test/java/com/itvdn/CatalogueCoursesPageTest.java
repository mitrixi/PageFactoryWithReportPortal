package com.itvdn;

import com.DriverWrapper;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners(ReportPortalTestNGListener.class)
public class CatalogueCoursesPageTest {

    private final DriverWrapper driverWrapper = new DriverWrapper();
    private final static Logger LOGGER = LogManager.getLogger("FileLogger");

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
    public void openCertainCourse() {
        LOGGER.info("Open Certain Course");
        new CatalogueCoursesPage(driverWrapper.getDriver()).openCertainCourse();
        JavaStarterCoursePage javaStarter = new JavaStarterCoursePage(driverWrapper.getDriver());

        assertTrue(javaStarter.getButton().isEnabled());
    }
}
