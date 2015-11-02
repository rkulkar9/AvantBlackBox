package com.test.blackbox;

import com.test.TestSuite;
import com.test.util.MyProfile;
import com.test.util.Registration;
import com.test.util.SignIn;
import org.junit.Test;

public class AvantBlackBoxTests extends TestSuite {

    @Test
    public void testSignIn() {
        SignIn.clickSignInLink();
        SignIn.enterEmail("test@test.com");
        SignIn.enterPassword("testtest");
        SignIn.clickSignIn();
        SignIn.verifySignInSuccess();
    }

    @Test
    public void testNewUserSignUp() {
        Registration.clickSignUpLink();
        Registration.enterEmail("testavant1@testavant.com");
        Registration.enterPassword("testtest");
        Registration.enterPasswordConfirm("testtest");
        Registration.clickSignUp();
        Registration.verifySignUpSuccess();
    }

    @Test
    public void testForgotPassword() {
        SignIn.clickSignInLink();
        SignIn.clickForgotPassword();
        SignIn.enterEmail("test@test.com");
        SignIn.clickPasswordResetInstructions();
        SignIn.verifyPasswordResetInstructionSuccess();
    }

    @Test
    public void testSignUpWithPasswordViolations() {
        String passwordMismatchErrorMessage = "Password confirmation doesn't match Password";
        String emptyPasswordErrorMessage="Password can't be blank";
        String passwordRestrictiveErrorMessage="Password is too short (minimum is 8 characters)";

        //password mismatch condition check
        Registration.clickSignUpLink();
        Registration.enterEmail("testavant2@testavant.com");
        Registration.enterPassword("password");
        Registration.enterPasswordConfirm("test");
        Registration.clickSignUp();
        Registration.verifySignUpFailure(passwordMismatchErrorMessage);

        //empty password condition check
        Registration.clickSignUp();
        Registration.verifySignUpFailure(emptyPasswordErrorMessage);

        //restrictive password condition check
        Registration.enterPassword("test");
        Registration.enterPasswordConfirm("test");
        Registration.clickSignUp();
        Registration.verifySignUpFailure(passwordRestrictiveErrorMessage);
    }

    @Test
    public void testSignUpWithEmailViolations() {
        String existingEmailErrorMessage = "Email has already been taken";
        String emptyEmailErrorMessage="Email can't be blank";

        //existing email condition check
        Registration.clickSignUpLink();
        Registration.enterEmail("test@test.com");
        Registration.enterPassword("password");
        Registration.enterPasswordConfirm("password");
        Registration.clickSignUp();
        Registration.verifySignUpFailure(existingEmailErrorMessage);

        //empty email condition check
        Registration.clearEmailId();
        Registration.enterEmail("");
        Registration.enterPassword("password");
        Registration.enterPasswordConfirm("password");
        Registration.clickSignUp();
        Registration.verifySignUpFailure(emptyEmailErrorMessage);
    }

    @Test
    public void testForgotPasswordWithEmptyEmail() {
        String emptyEmailErrorMessage = "Email can't be blank";
        SignIn.clickSignInLink();
        SignIn.clickForgotPassword();
        SignIn.clickPasswordResetInstructions();
        SignIn.verifyPasswordResetInstructionFailure(emptyEmailErrorMessage);
    }

    @Test
    public void testEndToEnd() {
        Registration.clickSignUpLink();
        Registration.enterEmail("testavant3@testavant.com");
        Registration.enterPassword("password");
        Registration.enterPasswordConfirm("password");
        Registration.clickSignUp();
        Registration.verifySignUpSuccess();
        MyProfile.clickEditProfileLink();
        MyProfile.enterFirstName("test");
        MyProfile.enterLasttName("test");
        MyProfile.enterCity("chicago");
        MyProfile.enterState("IL");
        MyProfile.enterZipcode("60606");
        MyProfile.enterBirthdate("01/01/2000");
        MyProfile.clickUpdateProfileLink();
        MyProfile.verifyProfileUpdateSuccess();
        MyProfile.clickSignoutLink();
        MyProfile.verifySignoutSuccess();
    }

}
