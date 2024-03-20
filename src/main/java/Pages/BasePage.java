package Pages;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

public class BasePage {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    protected static final Logger logger=LogManager.getLogger(BasePage.class);

    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(4));
    }
    //wrapper
    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;

    }
    protected boolean elementExists(String xpath) {
        try {
            //logger.info("Checking element with xpath:" + xpath);
            //findElementByXpath(xpath);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }


    protected String getCurrentPageURL() {
        return webDriver.getCurrentUrl();

    }
    protected void clearField(String xpath){
        findElementByXpath(xpath).clear();
    }
    public String getValue(String xpath) {
        String qtyValue= webDriver.findElement(By.xpath(xpath)).getAttribute("value");
        return qtyValue;
    }
    public String getText(String xpath) {
        String qtyTextValue= webDriver.findElement(By.xpath(xpath)).getText();
        return qtyTextValue;
    }
    public WebElement captureLogo(String xpath) throws IOException {
        WebElement logo =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        File file=logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

        return logo;
    }

    public void logTest(){
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();

        for (LogEntry e: logs){
            logger.info("Message: "+ e.getMessage());
            logger.info("Level: "+ e.getLevel());

            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());}
    }
    public void clickElementByXpath(String xpath){
        findElementByXpath(xpath).click();

    }
    public void sendKeys(String xpath, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }
//    public boolean void isTitleVisible(){
//   Boolean isVisible= findElementByXpath()
//    }


}
