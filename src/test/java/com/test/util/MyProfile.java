package com.test.util;

import com.core.AvantSelenium;

public class MyProfile {

    private static String EDIT_PROFILE_LINK = "//div/h1/a[2]";
    private static String XPATH_LOCATOR = "xpath";
    private static String ID_LOCATOR = "id";
    private static String CSS_LOCATOR = "cssSelector";
    private static String NAME_LOCATOR = "name";
    private static String CLASSNAME_LOCATOR = "className";
    private static String FIRST_NAME_TEXT_BOX="profile_first_name";
    private static String LAST_NAME_TEXT_BOX="profile_last_name";
    private static String CITY_TEXT_BOX="profile_city";
    private static String STATE_SELECT_LIST="profile_state";
    private static String ZIPCODE_TEXT_BOX="profile_zip";
    private static String BIRTHDATE_TEXT_BOX="profile_birthdate";
    private static String SIGN_OUT_LINK="a[href='/users/sign_out']";
    private static String UPDATE_PROFILE_BUTTON = "commit";
    private static String PROFILE_UPDATE_SUCCESS_MESSAGE = "Succesfully updated profile";
    private static String SUCCESS_MESSAGE_CLASS_NAME = "alert-success";

    public static void clickEditProfileLink() {
        AvantSelenium.clickLink(XPATH_LOCATOR, EDIT_PROFILE_LINK);
    }

    public static void enterFirstName(String fname) {
        AvantSelenium.inputElement(ID_LOCATOR, FIRST_NAME_TEXT_BOX, fname);
    }

    public static void enterLasttName(String lname) {
        AvantSelenium.inputElement(ID_LOCATOR, LAST_NAME_TEXT_BOX, lname);
    }

    public static void enterCity(String city) {
        AvantSelenium.inputElement(ID_LOCATOR, CITY_TEXT_BOX, city);
    }

    public static void enterState(String state) {
        AvantSelenium.selectElement(ID_LOCATOR, STATE_SELECT_LIST, state);
    }

    public static void enterZipcode(String zipcode) {
        AvantSelenium.inputElement(ID_LOCATOR, ZIPCODE_TEXT_BOX, zipcode);
    }

    public static void enterBirthdate(String bdate) {
        AvantSelenium.inputElement(ID_LOCATOR, BIRTHDATE_TEXT_BOX, bdate);
    }

    public static void clickSignoutLink() {
        AvantSelenium.clickLink(CSS_LOCATOR, SIGN_OUT_LINK);
    }

    public static void clickUpdateProfileLink() {
        AvantSelenium.clickButton(NAME_LOCATOR, UPDATE_PROFILE_BUTTON);
    }

    public static void verifyProfileUpdateSuccess() {
        String actualSuccessMessage = AvantSelenium.getText(CLASSNAME_LOCATOR, SUCCESS_MESSAGE_CLASS_NAME);
        assert actualSuccessMessage.equals(PROFILE_UPDATE_SUCCESS_MESSAGE);
    }

    public static void verifySignoutSuccess() {
        assert AvantSelenium.getPageTitle().equals("AvantQaTest");
    }
}
