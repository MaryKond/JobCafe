package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ShareDriver {
    private static WebDriver webDriver;
    public enum Browser{
        CHROME,
        FIREFOX
    }


    public static WebDriver getWebDriver(Browser browser){
        switch (browser){
            case CHROME : {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                webDriver = new ChromeDriver();
                }
                break;
                case FIREFOX:

                    //WebDriverManager.firefoxdriver().setup();
                    System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");

                    webDriver=new FirefoxDriver();
                    break;
            }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return webDriver;
        }
    protected static void closeDriver(){
        if (webDriver!=null){
            webDriver.close();
            //webDriver.quit();
        }

    }
}

