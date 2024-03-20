package Utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


import Pages.BasePage;




    public class UseCaseBase {
        private static WebDriver webDriver;
        private static BasePage page;

        @BeforeAll
        public static void setUpMain(){
            page = new BasePage();
            webDriver= ShareDriver.getWebDriver(ShareDriver.Browser.CHROME);
            page.setWebDriver(webDriver);
        }
        @AfterAll
        public static void tearDown(){
            ShareDriver.closeDriver();
            webDriver=null;
        }
    }

