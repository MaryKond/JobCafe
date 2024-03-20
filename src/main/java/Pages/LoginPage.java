package Pages;

public class LoginPage extends BasePage{
    private final String LOGIN_FORM="//*[text()='Log In']";
    public String getLoginPageURL(){
        String urlLogin = getCurrentPageURL();
        return urlLogin;
}
public boolean loginFormIsVisible(){
        Boolean loginFormExists=elementExists(LOGIN_FORM);
        return loginFormExists;
}
}
