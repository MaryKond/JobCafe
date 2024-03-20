package Pages;


import org.junit.jupiter.api.Test;

public class AboutUsPage extends BasePage{
private static final String ABOUT_US_HEADER="//h2[text()='About Us']";
    public static final String ABOUT_URL = "http://167.99.178.249:3000/about";
    private static final String LOGO_IMG = "//*[@scr='img/logo16.png']";

    public boolean isHeaderVisible(){
        return elementExists(ABOUT_US_HEADER);
    }
    public void logChecking() {
        logTest();

    }
    public String getAboutPageURL(){
        String urlAbout = getCurrentPageURL();
        return urlAbout;
    }
    public boolean isLogoVisible() {
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

}
