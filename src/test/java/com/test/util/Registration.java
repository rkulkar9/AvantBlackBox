package com.test.util;

import com.core.AvantSelenium;

public class Registration {

    private static String SIGN_UP_LINK = "//h1/a[1]";
    private static String EMAIL_TEXT_BOX_ID = "user_email";
    private static String PASSWORD_TEXT_BOX_ID = "user_password";
    private static String PASSWORD_CONFIRM_TEXT_BOX_ID = "user_password_confirmation";
    private static String SIGN_UP_BUTTON_NAME = "commit";
    private static String ID_LOCATOR = "id";
    private static String NAME_LOCATOR = "name";
    private static String CLASSNAME_LOCATOR = "className";
    private static String XPATH_LOCATOR = "xpath";
    private static String SUCCESS_MESSAGE_CLASS_NAME = "alert-warning";
    private static String ERROR_MESSAGE_CLASS_NAME = "//div[@id='error_explanation']/ul/li";
    private static String SIGN_UP_SUCCESS_MESSAGE = "You need to edit your profile before doing any querying";

    public static void clickSignUpLink() {
        AvantSelenium.clickLink(XPATH_LOCATOR, SIGN_UP_LINK);
    }

    public static void enterEmail(String email) {
        AvantSelenium.inputElement(ID_LOCATOR, EMAIL_TEXT_BOX_ID, email);
    }

    public static void enterPassword(String password) {
        AvantSelenium.inputElement(ID_LOCATOR, PASSWORD_TEXT_BOX_ID, password);
    }

    public static void enterPasswordConfirm(String passwordConfirm) {
        AvantSelenium.inputElement(ID_LOCATOR, PASSWORD_CONFIRM_TEXT_BOX_ID, passwordConfirm);
    }

    public static void clickSignUp() {
        AvantSelenium.clickButton(NAME_LOCATOR, SIGN_UP_BUTTON_NAME);
    }

    public static void verifySignUpSuccess() {
        String actualSuccessMessage = AvantSelenium.getText(CLASSNAME_LOCATOR, SUCCESS_MESSAGE_CLASS_NAME);
        assert actualSuccessMessage.equals(SIGN_UP_SUCCESS_MESSAGE);
    }

    public static void verifySignUpFailure(String expectedMessage) {
        String actualErrorMessage = AvantSelenium.getText(XPATH_LOCATOR, ERROR_MESSAGE_CLASS_NAME);
        assert actualErrorMessage.equals(expectedMessage);
    }

    public static void clearEmailId() {
        AvantSelenium.resetData(ID_LOCATOR, EMAIL_TEXT_BOX_ID);
    }
}
