package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalReceipt {
    WebDriver driver;
    //contructor
    public FinalReceipt(WebDriver d){
        this.driver = d;
    }
    public void Alert(){
        String str = driver.findElement(By.xpath("//h2[contains(text(),'PAYMENT SUCCESS')]")).getText();
        System.out.println(" hfuhigfrg"+str);
        //return str;
    }
}
