package Tests;

import Browsers.WebDriverFactory;
import Pages.Register;
import Pages.login;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Screenshots;
import utils.jsonReader;

import java.util.Objects;

public class loginTest extends BaseTest {
    jsonReader loginData;
    Register register;
    login login;
    Faker faker = new Faker();

//    @Test
//    public void validLoginWithUserName() {
//        register = new Register(driver);
//        driver.get("http://dev.ees.cloud4rain.com:6329/auth/register");
//        register.registerAsNonCandidate("Ahmed Essam", "ahmedessam0077101@gmail.com","01019751081","Ahmed.essam@001","Ahmed.essam@001","29508181401095","مصر", faker.regexify("[A-Z][0-9]{8}"));
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText(),"تم إنشاء الحساب بنجاح");
//        login = new login(driver);
//        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
//        login.loginByUserName("Ahmed Essam", "Ahmed.essam@001");
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText(),"تم تسجيل الدخول بنجاح");
//    }

    @Test
    public void validLoginWithID() {
        register = new Register(driver);
        login = new login(driver);
        loginData= new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/register");

        register.registerAsNotAmember("Ahmed Essam", "01278823950","ahmedessam999@gmail.com","السعودية","Ahmed.essam@001","Ahmed.essam@001","29804147892413", faker.regexify("[A-Z][0-9]{8}"));
        try {
            Screenshots.AddScreenshot(driver, "validLoginWithID_registration_failure");
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText().contains("تم إنشاء الحساب بنجاح"));
        } catch (AssertionError e) {

            throw e;
        }
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");

        login.loginByID("29508181401045", "Ahmed.essam@001");

        try {
            Screenshots.AddScreenshot(driver, "validLoginWithID_login_failure");
            Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.ees.cloud4rain.com:6329/home/setting/personal-profile"));
        } catch (AssertionError e) {

            throw e;
        }

        login.logOut();
        try {
            Screenshots.AddScreenshot(driver, "validLoginWithID_logout_failure");
            Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.ees.cloud4rain.com:6329/auth/login"));
        } catch (AssertionError e) {

            throw e;
        }



    }

    @Test
    @Description("verify that the user can login with email")
    @Tag("Valid login with email")
    @TmsLink("")
    @Issue("")
    @Severity(SeverityLevel.NORMAL)
    public void validLoginWithEmail()   {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("valid Login With Email");
        });
        register = new Register(driver);
        login = new login(driver);
        loginData= new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/register");
        register.registerAsNotAmember(loginData.getData("registerName"), loginData.getData("registerPhone"), loginData.getData("registerEmail"), "مصر" , loginData.getData("registerPassword"), loginData.getData("registerConfirmPassword"), loginData.getData("registerID"), ""+ faker.regexify("[A-Z][0-9]{8}"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText().contains("تم إنشاء الحساب بنجاح"));
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), loginData.getData("password"));
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.ees.cloud4rain.com:6329/home/setting/personal-profile"));
        login.logOut();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.ees.cloud4rain.com:6329/auth/login"));


    }

    @Test
    public void forgetPassword() {
        register= new Register(driver);
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/register");
        register.registerAsNotAmember("Ahmed Essam", "ahmedessam00717@gmail.com","01019751022","Ahmed.essam@008","Ahmed.essam@008","29508181401030","السعودية", faker.regexify("[A-Z][0-9]{8}"));
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.forgetPassword("ahmedessam00717@gmail.com", "Ahmed.essam@008");
    }

    // Edge Case Tests
    @Test
    @Description("Verify login fails with invalid email format")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidEmailFormat() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("invalidemail", "Ahmed.essam@001");
        // Add assertion to verify error message or user stays on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with invalid ID format")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidIDFormat() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByID("123456789", "Ahmed.essam@001");
        // Add assertion to verify error message or user stays on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with empty username field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with empty password field")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyPassword() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example.com", "");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with both username and password empty")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyCredentials() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("", "");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with incorrect password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithIncorrectPassword() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), "WrongPassword123");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with incorrect email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithIncorrectEmail() {
        login = new login(driver);
        loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("nonexistent@example.com", loginData.getData("password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with incorrect ID")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithIncorrectID() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByID("12345678901234", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with SQL injection attempt")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithSQLInjectionAttempt() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("' OR '1'='1", "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with special characters in username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithSpecialCharactersInUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@#$%^&*()", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with spaces in password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithSpacesInPassword() {
        login = new login(driver);
        loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), "Ahmed.essam@001 ");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with very long email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithVeryLongEmail() {
        login = new login(driver);
        String longEmail = "a".repeat(100) + "@example.com";
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(longEmail, "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with case-sensitive password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithWrongPasswordCase() {
        login = new login(driver);
        loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), "ahmed.essam@007");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with whitespace-only username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithWhitespaceOnlyUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("     ", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with whitespace-only password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithWhitespaceOnlyPassword() {
        login = new login(driver);
       loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), "     ");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with Arabic characters in email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithArabicCharactersInEmail() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("اختبار@example.com", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with numbers only as username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithNumbersOnlyAsUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("1234567890", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with null-like string")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithNullLikeString() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("null", "null");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // Negative Test Cases - Security and Validation
    @Test
    @Description("Verify login fails with XSS injection attempt in email")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithXSSInjectionInEmail() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("<script>alert('XSS')</script>", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with XSS injection attempt in password")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithXSSInjectionInPassword() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example.com", "<img src=x onerror=alert('XSS')>");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with NoSQL injection attempt")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithNoSQLInjectionAttempt() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("{\"$ne\": \"\"}", "{\"$ne\": \"\"}");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with LDAP injection attempt")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithLDAPInjectionAttempt() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("*", "*");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with command injection attempt")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithCommandInjectionAttempt() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example.com; rm -rf /", "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with path traversal attempt")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithPathTraversalAttempt() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("../../../etc/passwd", "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with only special characters")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithOnlySpecialCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("!@#$%^&*()", "!@#$%^&*()");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with tab characters")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithTabCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test\t@example.com", "pass\tword");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with newline characters")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithNewlineCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test\n@example.com", "pass\nword");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with carriage return characters")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithCarriageReturnCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test\r@example.com", "pass\rword");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with null byte injection")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithNullByteInjection() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test\0@example.com", "pass\0word");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with very short password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithVeryShortPassword() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example.com", "a");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with single character")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithSingleCharacter() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("a", "b");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with common default password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithCommonDefaultPassword() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), "12345678");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with another common default password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithAnotherCommonPassword() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username"), "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with email@email.com format")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithStandardTestEmail() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@test.com", "test");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with admin username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithAdminUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("admin", "admin");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with root username")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithRootUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("root", "root");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with comment syntax in username")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithCommentSyntaxInUsername() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example.com#", "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with wildcard characters")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithWildcardCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test%@example.com", "pass%word");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with Unicode characters")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithUnicodeCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test\u0000@example.com", "password\u0000");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with emoji characters")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmojiCharacters() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example😀.com", "pass😀word");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with leading spaces in email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithLeadingSpacesInEmail() {
        login = new login(driver);
        loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("  " + loginData.getData("username"), loginData.getData("password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with trailing spaces in email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithTrailingSpacesInEmail() {
        login = new login(driver);
       loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail(loginData.getData("username") + "  ", loginData.getData("password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with both leading and trailing spaces")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithLeadingAndTrailingSpaces() {
        login = new login(driver);
        loginData = new jsonReader("loginData");
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("  " + loginData.getData("username") + "  ", "  " + loginData.getData("password") + "  ");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with missing @ symbol in email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithMissingAtSymbol() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("testeexample.com", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with missing domain extension")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithMissingDomainExtension() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with double @ symbols")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithDoubleAtSymbols() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@@example.com", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with space instead of @")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithSpaceInsteadOfAt() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test example.com", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with consecutive spaces")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithConsecutiveSpaces() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test    @example.com", "Ahmed.essam@001");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with less than sign")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithLessThanSign() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("<test@example.com", "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Verify login fails with greater than sign")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithGreaterThanSign() {
        login = new login(driver);
        driver.get("http://dev.ees.cloud4rain.com:6329/auth/login");
        login.loginByEmail("test@example.com>", "password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

}

