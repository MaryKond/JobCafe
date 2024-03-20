import Utils.UseCaseBase;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pages.HomePage;
import Pages.AboutUsPage;


public class AboutUsPageTest extends UseCaseBase{
    private static HomePage homePage;
    private static AboutUsPage aboutUsPage;
    private static final Logger logger=LogManager.getLogger(AboutUsPageTest.class);

    @BeforeAll
    public static void classSetUp(){
        homePage=new HomePage();

        aboutUsPage=new AboutUsPage();
    }
    @BeforeEach
    public void beforeTest(){
        homePage.navigateToToHomePage();
        homePage.navigateToAboutUs();

    }

    @Test
    public void isHeaderVisible(){

        Boolean isVisible=aboutUsPage.isHeaderVisible();
        try{
            assertTrue(isVisible);
        }catch(AssertionError er){
            logger.info("Header 'About us' is not found");
            throw er;
        }
    }
    @Test
    public void logoIsVisble(){
    Boolean logoIsVisble=aboutUsPage.isLogoVisible();
    try{
    assertTrue(logoIsVisble);
    }
    catch (AssertionError e){

        logger.info("Logo is not found on 'About Us' page");
        throw e;
    }
}
    @Test
    public void logTest(){
        aboutUsPage.logChecking();
    }
}
