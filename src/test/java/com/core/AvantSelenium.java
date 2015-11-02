package com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class AvantSelenium {

    private static WebDriver webDriverInstance;
    private static String defaultUrl = null;
    private static WebDriverWait wait;

    public AvantSelenium(String baseUrl, WebDriver webDriver, WebDriverWait webDriverWait) {
        defaultUrl = baseUrl;
        webDriverInstance = webDriver;
        wait = webDriverWait;
    }

    public static void clickLink(String locatorType, String locator) {
        if (locatorType.equals("xpath"))
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
        else if (locatorType.equals("cssSelector"))
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator))).click();
    }

    public static void inputElement(String locatorType, String locatorValue, String inputValue) {
        if (locatorType.equals("id"))
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue))).sendKeys(inputValue);
    }

    public static void clickButton(String locatorType, String locatorValue) {
        if (locatorType.equals("name"))
            webDriverInstance.findElement(By.name(locatorValue)).click();
    }

    public static String getText(String locatorType, String locatorValue) {
        if (locatorType.equals("xpath"))
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue))).getText();
        else if (locatorType.equals("className"))
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue))).getText();
        else
            return null;
    }

    public static String getPageTitle() {
        return webDriverInstance.getTitle();
    }

    public static void selectElement(String locatorType, String locatorValue, String inputValue) {
        Select select = null;
        if (locatorType.equals("id"))
            select = new Select(webDriverInstance.findElement(By.id(locatorValue)));

        select.selectByValue(inputValue);
    }

    public static void resetData(String locatorType, String locatorValue) {
        if (locatorType.equals("id"))
            webDriverInstance.findElement(By.id(locatorValue)).clear();
    }

    public static void openBrowser(String url) {
        webDriverInstance.navigate().to(url);
    }
}
