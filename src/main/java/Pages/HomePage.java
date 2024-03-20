package Pages;
import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.IOException;

public class HomePage extends BasePage {

    private static final String LOGO_IMG = "//*[@class='logo']";
    private static final String COMING_SOON = "//*[@alt='coming soon']";

    public static final String ABOUT_URL = "http://167.99.178.249:3000/about";
    public static final String ABOUT_BUTTON = "//*[@id='2']";
    public static final String LOGIN_BUTTON = "//a[@name='Log in/Register']";
    public static final String FIND_JOB_BUTTON = "//a[@name='Find Job']";

    public void navigateToToHomePage() {

        webDriver.get(Constants.HOME_URL);
    }

    public boolean isLogoVisible() {
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public String pageLoaded() {
        String homePageLoaded = getCurrentPageURL();
        return homePageLoaded;
    }

    public WebElement screenshot() throws IOException {
        WebElement screenshot = captureLogo(LOGO_IMG);
        return screenshot;
    }

    public boolean comingSoonVisible() {
        Boolean comingSoonIsVisible = elementExists(COMING_SOON);
        return comingSoonIsVisible;
    }

    public void logChecking() {
        logTest();

    }

    public AboutUsPage navigateToAboutUs() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ABOUT_BUTTON)));
        clickElementByXpath(ABOUT_BUTTON);
        return new AboutUsPage();
    }
    public LoginPage navigateToLogin() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGIN_BUTTON)));
        clickElementByXpath(LOGIN_BUTTON);
        return new LoginPage();
    }

    public FindJobPage navigateToFindJob() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIND_JOB_BUTTON)));
        clickElementByXpath(FIND_JOB_BUTTON);
        return new FindJobPage();
    }

}

