package org.example.tests;

import configuration.ConfigProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.initDriver;

public abstract class BaseTest {


    @BeforeClass
    public static void setup() {
        initDriver(ConfigProperties.getProperty("browsername"));
        getDriver().get(ConfigProperties.getProperty("url"));
    }

    @AfterClass
    public static void closeBrowser() {
        getDriver().quit();
    }
}
