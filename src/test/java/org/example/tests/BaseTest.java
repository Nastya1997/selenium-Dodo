package org.example.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.initDriver;

public abstract class BaseTest {


    @BeforeClass
    public static void setup() {
        initDriver();
        getDriver().get("https://dodopizza.ru");
    }

    @AfterClass
    public static void closeBrowser() {
        getDriver().quit();
    }
}
