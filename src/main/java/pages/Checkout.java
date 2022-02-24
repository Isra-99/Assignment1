package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Checkout<sum> {

    private WebDriver driver;
    public Checkout(WebDriver d) {
        this.driver =  d;
    }

    public int  billsum() {
        ArrayList<WebElement> bill;
        bill = (ArrayList<WebElement>) driver.findElements(By.xpath("//td[ contains (text(),'SPF') or contains (text(),'spf')] //following-sibling::td"));
        System.out.println("siiiizeee"+ bill.size());
        int sum = 0;
        for (WebElement b : bill) {
            String billout = b.getText();
            String str = billout.replaceAll("[^0-9]", "");
            int prices = Integer.parseInt(str);
            sum += prices;
            System.out.println(sum);

        }

        return sum;
    }

    public void checktotalprices(){
        WebElement s = driver.findElement(By.xpath("//p[@class='justify-content-center h4 top-space-20']"));
        String str = s.getText();
        String newstr = str.replaceAll("[^0-9]", "");
        int total  = Integer.parseInt(newstr);
        int sum = billsum();
        if (total == sum)
        {
            System.out.println("Total price is correct");
        }
        else
        {
            System.out.println("Total price is incorrect");

        }
    }
    public ArrayList<String> checkitems() {

        ArrayList<WebElement> items = (ArrayList<WebElement>) driver.findElements(By.xpath("//td[ contains (text(),'SPF') or contains (text(),'spf')]"));
        ArrayList<String> list = new ArrayList<>();
        System.out.println("the final list is");
        for (WebElement i : items) {
            String str= i.getText();
           list.add(str);
        }
        System.out.println(list);
        return list;
    }

    public void payclick(){
        driver.findElement(By.xpath("//button[@class='stripe-button-el']")).click();
    }
    private void switchtoEditArea() {
        driver.switchTo().frame("stripe_checkout_app");

    }

    private void switchtoMainArea() {
        driver.switchTo().parentFrame();
    }

    public void enteremail(String text) {
        switchtoEditArea();
        driver.findElement(By.id("email")).sendKeys(text);
        switchtoMainArea();
    }

    public void enterCrdnumber(String text) {
        switchtoEditArea();
        driver.findElement(By.id("card_number")).sendKeys(text);
        switchtoMainArea();
    }

    public void enterMonth(String text) {
        switchtoEditArea();
        driver.findElement(By.id("cc-exp")).sendKeys(text);
        switchtoMainArea();
    }

    public void enterCVC (String text){
        switchtoEditArea();
        driver.findElement(By.id("cc-csc")).sendKeys(text);
        switchtoMainArea();

    }

    public FinalReceipt clickpaybutton(WebDriver driver) {
        switchtoEditArea();
        driver.findElement(By.id("submitButton")).click();
        switchtoMainArea();
        return new FinalReceipt(driver);

    }

    public void enterZipcode(String text) {
        switchtoEditArea();
        driver.findElement(By.id("billing-zip")).sendKeys(text);
        switchtoMainArea();
    }


}

