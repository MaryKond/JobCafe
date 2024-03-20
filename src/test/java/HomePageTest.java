import Pages.FindJobPage;
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

public class HomePageTest extends UseCaseBase {
    private static HomePage homePage;
    private static final Logger logger=LogManager.getLogger(HomePageTest.class);

    @BeforeAll
    public static void classSetUp(){

        homePage=new HomePage();
    }
    @BeforeEach
    public void beforeTest(){homePage.navigateToToHomePage();
    }

    @Test
   public void homePageLoadTest() {
        String pageLoaded=homePage.pageLoaded();
        assertEquals("http://167.99.178.249:3000/",pageLoaded);
    }

    @Test
    public void logoTest() {
        Boolean logoIsVisible=homePage.isLogoVisible();
        assertTrue(logoIsVisible);
    }
    @Test
    public void logoScreenshot() throws IOException {
        WebElement logo=homePage.screenshot();
        assertNotNull(logo);
    }
    @Test
    public void comingSoonExist(){
        Boolean imageIsVisible= homePage.comingSoonVisible();
        assertNotNull(imageIsVisible);
    }

    @Test
    public void logTest(){
      homePage.logChecking();
        }
        @Test
    public void navigateToAboutUs(){
        AboutUsPage aboutUsPage=homePage.navigateToAboutUs();
        String isLoaded = aboutUsPage.getAboutPageURL();
            try{
                assertEquals("http://167.99.178.249:3000/about", isLoaded);
            }
            catch (AssertionError e){
                logger.info("About Us Page is not loaded or URL mismatch");
                throw e;
            }
    }
        @Test

    public void navigateToLogin(){
        LoginPage loginPage=homePage.navigateToLogin();
        String isLoaded = loginPage.getLoginPageURL();
        try{
            assertEquals("http://167.99.178.249:3000/login", isLoaded);
        }catch (AssertionError e){
            logger.info("Login Page is not loaded or URL mismatch");
            throw e;
        }
        }
        @Test

        public void navigateToFindJob(){
        FindJobPage findJobPage=homePage.navigateToFindJob();
        String isLoaded = findJobPage.getFindJobPageURL();
        try{
            assertEquals("http://167.99.178.249:3000/job-page", isLoaded);
        }catch (AssertionError e){
            logger.info("Find Job Page is not loaded or URL mismatch");
            throw e;
        }
        }

}
