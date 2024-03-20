import Pages.FindJobPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Pages.HomePage;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class FindJobPageTest extends UseCaseBase {
    private static FindJobPage findJobPage;
    private static HomePage homePage;
    private static final Logger logger= LogManager.getLogger(HomePageTest.class);
    @BeforeAll
    public static void classSetUp(){

        findJobPage=new FindJobPage();
        homePage=new HomePage();
    }
    @BeforeEach
    public void beforeTest(){
        homePage.navigateToToHomePage();
        homePage.navigateToFindJob();
    }

    @Test
    public void locationResult(){
        findJobPage.sendKeysToLocation();
        String location = findJobPage.getTextLocations();
       assertEquals(location, "Toronto, Tel-Aviv, Chicago, New-York");
    }
    @Test
    public void positionsResult(){
        findJobPage.sendKeysToPosition();
        String positons = findJobPage.getTextPositions();
       assertEquals(positons, "QA, Developer, Project Manager");
       findJobPage.clickSearch();
    }
    @Test
    public void cityResult(){
        findJobPage.sendKeysToLocation();
        String location = findJobPage.getTextLocations();
        assertEquals(location, "Toronto, Tel-Aviv, Chicago, New-York");
      findJobPage.verifyCity();
//
////        assertTrue(text.contains("New York") || text.contains("Chicago") || text.contains("Tel-Aviv")|| text.contains("Toronto"),
////                "Text does not contain any of the three words");
//
//        assertTrue(text.contains("er") || text.contains("dfg") || text.contains("sdfg")|| text.contains("sdfg"),
//                "Text does not contain any of the three words");
    }
}
