package org.example.tests;

import configuration.ConfigProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.initDriver;

public abstract class BaseTest {


    @BeforeAll
    public static void setup() {
        initDriver(ConfigProperties.getProperty("run"));
        getDriver().get(ConfigProperties.getProperty("url"));
    }

    @AfterAll
    public static void closeBrowser() {
        getDriver().quit();
    }
}
