package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindJobPage extends BasePage {
    private static final String REQUEST_POSITION = "QA, Developer, Project Manager";
    private static final String REQUEST_COMPANY = "Apple, Facebook, Google";
    private static final String REQUEST_LOCATION = "Toronto, Tel-Aviv, Chicago, New-York";
    private static final String REQUEST_POSITION_MANAGER = "Manager";
    private static final String AUTODESK_POSITION = "QA";
    private static final String REQUEST_LOCATION_USA = "USA";
    private static final String AUTODESK_LOCATION = "Toronto";
    private static final String REQUEST_COMPANY_GOOGLE = "Google";
    private static final String AUTODESK = "Autodesk";
    private static final String AUTODESK_DESCRIPTION= "testing";
    private static final String INVALID_REQUEST = "gsfg45yfghfgh!!";
    private static final String POSITION = "//input[@placeholder='position']";
    private static final String COMPANY = "//input[@placeholder='company']";
    private static final String LOCATION = "//input[@placeholder='location']";
    private static final String DESCRIPTION = "//input[@placeholder='description']";
    private static final String SEARCH = "//button[@type='submit'][text()='search']";
    private static final String RESET = "//button[@type='submit'][text()='reset']";
    private static final String RESULTS_FORM_CITIES = "//article[@class='entry']";
    private static final String RESULTS_FORM_POSITIONS = "//article[@class='entry']";
    private static final String RESULTS_FORM_COMPANY = "//article[@class='entry']";
    private static final String XPATH_CITIES = "//li[@class='entry-content']";
    private static final String XPATH_POSITIONS = "//li[@class='entry-content']";
    private static final String XPATH_COMPANY = "//li[@class='entry-content']";
    private static final String ERR_MESSAGE = "//*[text()='No results found!']";


    public String getFindJobPageURL() {
        String urlFindJob = getCurrentPageURL();
        return urlFindJob;
    }

    public void sendKeysToPosition() {
        sendKeys(POSITION, REQUEST_POSITION);
    } public void sendKeysToPosition2() {
        sendKeys(POSITION, AUTODESK_POSITION);
    }

    public void sendKeysToLocation() {
        sendKeys(LOCATION, REQUEST_LOCATION);
    }
public void sendKeysToLocation2() {
        sendKeys(LOCATION, AUTODESK_LOCATION);
    }
    public void sendKeysToDescription() {
        sendKeys(DESCRIPTION, AUTODESK_DESCRIPTION);
    }

    public void sendKeysToCompany() throws InterruptedException {
        sendKeys(COMPANY, REQUEST_COMPANY);
        clickSearch();
        Thread.sleep(2000);
    }
  public void sendKeysToCompany2() throws InterruptedException {
        sendKeys(COMPANY, AUTODESK);
        clickSearch();
        Thread.sleep(2000);
    }

    public void sendKeysToMainFields()throws InterruptedException {
        sendKeys(LOCATION, REQUEST_LOCATION_USA);
        sendKeys(POSITION, REQUEST_POSITION_MANAGER);
        sendKeys(COMPANY, REQUEST_COMPANY_GOOGLE);
        clickSearch();
        Thread.sleep(2000);
    }

    public void sendKeysInvalid()throws InterruptedException {
        sendKeys(LOCATION, INVALID_REQUEST);
        sendKeys(COMPANY, INVALID_REQUEST);
        clickSearch();
        Thread.sleep(2000);
    }

    public String getTextPositions() {
        String textPosition = findElementByXpath(POSITION).getAttribute("value");
        return textPosition;
    }


    public String getTextLocations() {
        String textLocation = findElementByXpath(LOCATION).getAttribute("value");
        return textLocation;
    }

    public String getTextCompany() {
        String textCompany = findElementByXpath(COMPANY).getAttribute("value");
        return textCompany;
    }
    public String getTextDescription() {
        String textDescription = findElementByXpath(DESCRIPTION).getAttribute("value");
        return textDescription;
    }

    public void clickSearch() {
        clickElementByXpath(SEARCH);

    }   public void clickReset() {
        clickElementByXpath(RESET);
    }
    public void valueToReset() throws InterruptedException {
        sendKeysToPosition2();
        sendKeysToLocation2();

        sendKeysToDescription();
        sendKeysToCompany2();

    }

    public boolean verifyCity() {
        WebElement cityElements = webDriver.findElement(By.xpath(RESULTS_FORM_CITIES));
        java.util.List<WebElement> city = cityElements.findElements(By.xpath(XPATH_CITIES));
        List<String> cityNames1 = extractCityNames(city);
        for (String row : cityNames1) {
            String city1 = "Toronto";
            String city2 = "New-York";
            String city3 = "Tel-Aviv";
            String city4 = "Chicago";

            if (row.contains(city1) || row.contains(city2) || row.contains(city3) || row.contains(city4)) {
                return true;
            }
            //LOG CITY NAMES IF FOUND
//           if(row.contains(city1))
//                {logger.info("contains {}" +city1);}
//           if(row.contains(city2))
//                {logger.info("contains {}" +city2);}
//            if(row.contains(city3)){
//                logger.info("contains {}" +city3);}
//            if(row.contains(city4)){
//                logger.info("contains {}" +city4);}
        }
//            else{logger.info("Text does not contain any of the city names");}

        return false;
    }

    public boolean verifyValidRequest() {
        WebElement positionElements = webDriver.findElement(By.xpath(RESULTS_FORM_POSITIONS));
        java.util.List<WebElement> position = positionElements.findElements(By.xpath(XPATH_POSITIONS));
        List<String> positionNames1 = extractCityNames(position);
        for (String row : positionNames1) {
            String position1 = "USA";
            String position2 = "Google";
            String position3 = "Manager";

            if (row.contains(position1) && row.contains(position2) && row.contains(position3)) {
                return true;
            }
        }
        return false;
    }

    public String getErrMessage() {
        String errMessage = findElementByXpath(ERR_MESSAGE).getText();
        return errMessage;
    }

    public boolean verifyPosition() {
        WebElement positionNewElements = webDriver.findElement(By.xpath(RESULTS_FORM_POSITIONS));
        java.util.List<WebElement> position = positionNewElements.findElements(By.xpath(XPATH_POSITIONS));
        List<String> positionNames1 = extractCityNames(position);
        for (String row : positionNames1) {
            String position1 = "QA";
            String position2 = "Developer";
            String position3 = "Project Manager";

            if (row.contains(position1) || row.contains(position2) || row.contains(position3)) {
                return true;
            }
        }

        return false;
    }

    public boolean verifyCompany() {
        WebElement companyElements = webDriver.findElement(By.xpath(RESULTS_FORM_COMPANY));
        java.util.List<WebElement> company = companyElements.findElements(By.xpath(XPATH_COMPANY));
        List<String> companyNames1 = extractCityNames(company);
        for (String row : companyNames1) {
            String company1 = "Apple";
            String company2 = "Google";
            String company3 = "Facebook";

            if (row.contains(company1) || row.contains(company2) || row.contains(company3)) {
                return true;
            }
        }

        return false;
    }


    private static List<String> extractCityNames(List<WebElement> cityElements) {
        List<String> cityNames = new ArrayList<>();
        for (WebElement cityElement : cityElements) {
            cityNames.add(cityElement.getText());

        }
        return cityNames;
    }

}
