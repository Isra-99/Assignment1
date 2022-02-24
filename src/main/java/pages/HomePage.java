package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    private By currentTemp = By.id("temperature");

    public void clickTempButton() {
        var  tempstats = driver.findElement(currentTemp).getText();
        System.out.println(" the temperature is given as "+ tempstats);
        String str = tempstats.replaceAll("[^0-9]","");
        System.out.println(str);
        int stats = Integer.parseInt(str);
        int number = 70;
        stats = number;
        if (stats <= 19) {
           clickMoistButton();
        }
        else if (stats >= 34) {
            clickSunsButton();
        }
        else{
            System.out.println("invalid");
        }

    }
    public static Moistures clickMoistButton () {
        driver.findElement(By.linkText("Buy moisturizers")).click();
        return new Moistures(driver);
    }
    public static Sunscreens clickSunsButton () {
        driver.findElement(By.linkText("Buy sunscreens")).click();
        return new Sunscreens(driver);
    }
}
