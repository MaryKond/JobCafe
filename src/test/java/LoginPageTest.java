import Pages.LoginPage;
import Utils.UseCaseBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pages.HomePage;
import Pages.AboutUsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;
public class LoginPageTest extends UseCaseBase{
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static final Logger logger=LogManager.getLogger(LoginPage.class);

    @BeforeAll
    public static void classSetUp(){

        homePage=new HomePage();
        loginPage=new LoginPage();
    }
    @BeforeEach
    public void beforeTest(){
        homePage.navigateToToHomePage();
        homePage.navigateToLogin();
    }
    @Test
    public void loginFormExist(){
        Boolean isFound= loginPage.loginFormIsVisible();
        try{
            assertTrue(isFound);
        }catch (AssertionError e){

            logger.info("Login Form is not found on the 'Login' page");
            throw e;
        }
    }

    }

