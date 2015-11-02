package com.test.util;

import com.core.AvantSelenium;

public class SignIn {

    private static String SIGN_IN_LINK = "//h1/a[2]";
    private static String EMAIL_TEXT_BOX_ID = "user_email";
    private static String PASSWORD_TEXT_BOX_ID = "user_password";
    private static String LOGIN_BUTTON = "commit";
    private static String SUCCESS_MESSAGE_CLASS_NAME = "alert-warning";
    private static String FORGOT_PASSWORD_LINK = "a[href='/users/password/new']";
    private static String ID_LOCATOR = "id";
    private static String NAME_LOCATOR = "name";
    private static String XPATH_LOCATOR = "xpath";
    private static String CSS_LOCATOR = "cssSelector";
    private static String CLASSNAME_LOCATOR = "className";
    private static String LOGIN_SUCCESS_MESSAGE = "Signed in successfully.";
    private static String PASSWORD_RESET_INSTRUCTIONS_BUTTON = "commit";
    private static String ERROR_PAGE_TITLE = "We're sorry, but something went wrong (500)";
    private static String ERROR_MESSAGE_CLASS_NAME = "//div[@id='error_explanation']/ul/li";

    public static void clickSignInLink() {
        AvantSelenium.clickLink(XPATH_LOCATOR, SIGN_IN_LINK);
    }

    public static void enterEmail(String email) {
        AvantSelenium.inputElement(ID_LOCATOR, EMAIL_TEXT_BOX_ID, email);
    }

    public static void enterPassword(String password) {
        AvantSelenium.inputElement(ID_LOCATOR, PASSWORD_TEXT_BOX_ID, password);
    }

    public static void clickSignIn() {
        AvantSelenium.clickButton(NAME_LOCATOR, LOGIN_BUTTON);
    }

    public static void verifySignInSuccess() {
        String actualSuccessMessage = AvantSelenium.getText(CLASSNAME_LOCATOR, SUCCESS_MESSAGE_CLASS_NAME);
        assert actualSuccessMessage.equals(LOGIN_SUCCESS_MESSAGE);
    }

    public static void clickForgotPassword() {
        AvantSelenium.clickLink(CSS_LOCATOR, FORGOT_PASSWORD_LINK );
    }

    public static void clickPasswordResetInstructions() {
        AvantSelenium.clickButton(NAME_LOCATOR, PASSWORD_RESET_INSTRUCTIONS_BUTTON);
    }

    public static void verifyPasswordResetInstructionSuccess() {
        assert AvantSelenium.getPageTitle().equals(ERROR_PAGE_TITLE);
    }

    public static void verifyPasswordResetInstructionFailure(String expectedMessage) {
        String actualErrorMessage = AvantSelenium.getText(XPATH_LOCATOR, ERROR_MESSAGE_CLASS_NAME);
        assert actualErrorMessage.equals(expectedMessage);
    }
}
