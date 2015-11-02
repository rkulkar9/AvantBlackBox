package com.test;

import com.core.AvantSelenium;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestSuite {

    public static WebDriverWait wait;
    private static final String defaultBaseUrl = "https://avant-qa-screening.herokuapp.com/";
    private static WebDriver webDriver;

    @Before
    public void testSetUp() {
        webDriver = new FirefoxDriver();
        wait = new WebDriverWait(webDriver, 10);
        new AvantSelenium(defaultBaseUrl, webDriver, wait);
        AvantSelenium.openBrowser(defaultBaseUrl);
    }

    @After
    public void testTearDown() {
        webDriver.quit();
    }
}
