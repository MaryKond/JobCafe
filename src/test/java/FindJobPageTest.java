import Pages.FindJobPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class FindJobPageTest extends UseCaseBase {
    private static FindJobPage findJobPage;
    private static HomePage homePage;
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @BeforeAll
    public static void classSetUp() {

        findJobPage = new FindJobPage();
        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToToHomePage();
        homePage.navigateToFindJob();
    }

    @Test
    public void cityResult() {
        findJobPage.sendKeysToLocation();
        String location = findJobPage.getTextLocations();
        assertEquals("Toronto, Tel-Aviv, Chicago, New-York", location);
        Boolean city = findJobPage.verifyCity();
        assertTrue(city);
    }

    //TEST HAS ISSUES WITH GETTING RESULTS AFTER SENDING KEYS. REQUIRES CLICKING SEARCH AND MAKING A PAUSE
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void companyResult() throws InterruptedException {
        findJobPage.sendKeysToCompany();
        String company = findJobPage.getTextCompany();
        assertEquals("Apple, Facebook, Google", company);
        Boolean company1 = findJobPage.verifyCompany();

        assertTrue(company1);
    }

    @Test
    public void positionResult() {
        findJobPage.sendKeysToPosition();
        String position = findJobPage.getTextPositions();
        assertEquals("QA, Developer, Project Manager", position);
        Boolean positionName = findJobPage.verifyPosition();

        assertTrue(positionName);
    }

    @Test
    public void validRequest() throws InterruptedException {
        findJobPage.sendKeysToMainFields();
        String positionNew = findJobPage.getTextPositions();
        assertEquals("Manager", positionNew);

        String locationNew = findJobPage.getTextLocations();
        assertEquals("USA", locationNew);

        String companyNew = findJobPage.getTextCompany();
        assertEquals("Google", companyNew);
        Boolean validRequest = findJobPage.verifyValidRequest();

        assertTrue(validRequest);
    }

    @Test
    public void invalidRequest() throws InterruptedException {
        findJobPage.sendKeysInvalid();
        String err = findJobPage.getErrMessage();

        assertEquals("No results found!", err);
    }
    @Test
    public void reset() throws InterruptedException {
        findJobPage.valueToReset();
       findJobPage.clickReset();
        String positionNew = findJobPage.getTextPositions();
        assertEquals("", positionNew);
        String locationNew = findJobPage.getTextLocations();
        assertEquals("", locationNew);
        String companyNew = findJobPage.getTextCompany();
        assertEquals("", companyNew);
        String description = findJobPage.getTextDescription();
        assertEquals("", description);

    }
}
