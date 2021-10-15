package org.example.tests;

import configuration.ConfigProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.initDriver;

public abstract class BaseTest {


    @BeforeClass
    public static void setup() throws MalformedURLException {
        initDriver(ConfigProperties.getProperty("run"));
        getDriver().get(ConfigProperties.getProperty("url"));
    }

    @AfterClass
    public static void closeBrowser() throws MalformedURLException {
        getDriver().quit();
    }
}
