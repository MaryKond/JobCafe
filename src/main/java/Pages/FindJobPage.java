package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindJobPage extends BasePage{
    private static final String REQUEST_POSITION="QA, Developer, Project Manager";
    private static final String POSITION="//input[@placeholder='position']";
    private static final String REQUEST_LOCATION="Toronto, Tel-Aviv, Chicago, New-York";
    private static final String LOCATION="//input[@placeholder='location']";
    private static final String SEARCH="//button[@type='submit']";
    private static final String RESULTS_FORM_CITIES="//article[@class='entry']";
    private static final String XPATH_CITIES="//li[@class='entry-content']";


    public String getFindJobPageURL(){
        String urlFindJob = getCurrentPageURL();
        return urlFindJob;
    }
   public void sendKeysToPosition(){
        sendKeys(POSITION,REQUEST_POSITION);
   }

   public void sendKeysToLocation(){
        sendKeys(LOCATION,REQUEST_LOCATION);
   }

   public String getTextPositions(){
       String textPosition = findElementByXpath(POSITION).getAttribute("value");
     return textPosition;
   }
   public String getTextLocations(){
       String textLocation = findElementByXpath(LOCATION).getAttribute("value");
     return textLocation;
   }
   public void clickSearch(){
        clickElementByXpath(SEARCH);
   }

    public String verifyCity(){
        WebElement cityElements=webDriver.findElement(By.xpath(RESULTS_FORM_CITIES));
        java.util.List<WebElement> city = cityElements.findElements(By.xpath(XPATH_CITIES));
        List<String> cityNames1 = extractCityNames(city);
        for (String row:cityNames1){
            String city1="Toronto";
            String city2="New-York";
            String city3="Tel-Aviv";
            String city4="Chicago";
            if(row.contains(city1)||row.contains(city2)||row.contains(city3)||row.contains(city4))
            {
           if(row.contains(city1))
                {logger.info("contains {}" +city1);}
           if(row.contains(city2))
                {logger.info("contains {}" +city2);}
            if(row.contains(city3)){
                logger.info("contains {}" +city3);}
            if(row.contains(city4)){
                logger.info("contains {}" +city4);}
            }
//            else{logger.info("Text does not contain any of the city names");}

        }
//        System.out.println(cityNames1);
        return cityNames1.toString();
    }
    private static List<String> extractCityNames(List<WebElement> cityElements) {
        List<String> cityNames = new ArrayList<>();
        for (WebElement cityElement : cityElements) {
            cityNames.add(cityElement.getText());

        }
        return cityNames;
    }
}
