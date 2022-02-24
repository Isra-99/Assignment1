package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Sunscreens<i> {
    private static WebDriver driver;
    private static ArrayList<Integer> list;

    //contructor
    public Sunscreens(WebDriver d) {
        this.driver = d;
    }

    public int ClickButton1(WebDriver driver1) {
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver1.findElements(By.xpath(" //p[contains(text(),('SPF-30')) or contains(text(),('spf-30')) ]//following-sibling::p[contains(text(),('Price')) ]"));
        int[] intArray = new int[0];
        for (WebElement lists : list) {
            String textList = lists.getText();
            String str = textList.replaceAll("[^0-9]", "");
            int prices = Integer.parseInt(str);
            intArray = new int[]{prices};
        }
        int minimum;
        minimum = minValue(intArray);
        lowPricebutton(minimum).click();
        return minimum;

    }
    public int ClickButton2(WebDriver driver1) {

        ArrayList<WebElement> list1 = (ArrayList<WebElement>) driver1.findElements(By.xpath(" //p[contains(text(),('SPF-50')) or contains(text(),('spf-50')) ]//following-sibling::p[contains(text(),('Price')) ]"));
        int[] intArray1 = new int[0];
        for (WebElement lists1 : list1) {
            String textList1 = lists1.getText();
            String str1 = textList1.replaceAll("[^0-9]", "");
            int prices1 = Integer.parseInt(str1);
            intArray1 = new int[]{prices1};

        }
        int minimum1;
        minimum1 = minValue(intArray1);
        lowPricebutton(minimum1).click();
        return minimum1;
    }



    private static int minValue(int[] arr) {
        int min = arr[0];
        for (int ktr = 1; ktr < arr.length; ktr++) {
            if (arr[ktr] < min) {
                min = arr[ktr];
            }
        }
        return min;
    }

    public   WebElement lowPricebutton(int value){

        WebElement element = driver.findElement(By.xpath("//p[contains(text(),('" + value + "'))]" + "//following-sibling::button[@class='btn btn-primary']"));
        return element;
    }

    public static Checkout addToCart(){
        driver.findElement(By.xpath("//button[@class='thin-text nav-link']")).click();
        return new Checkout(driver);
    }

    public String checkselecteditem1(){
        int min1 = ClickButton1(driver);
        WebElement text1 = driver.findElement(By.xpath("//p[contains(text(),('"+ min1 + "'))]//preceding-sibling::p[@class='font-weight-bold top-space-10']"));
        String item1  = text1.getText();
        return item1;
    }
    public String checkselecteditem2(){
        int min2 = ClickButton2(driver);
        WebElement text2 = driver.findElement(By.xpath("//p[contains(text(),('"+ min2 + "'))]//preceding-sibling::p[@class='font-weight-bold top-space-10']"));
        String item2  = text2.getText();
        return item2;


    }
    public ArrayList<String> displayselecteditem(){
        String item1 = checkselecteditem1();
        String item2 = checkselecteditem2();
        ArrayList<String> list= new ArrayList<String>();
        list.add(item1);
        list.add(item2);
        System.out.println("So the items added to the car are :");
        System.out.println(list);
        return list;
    }





}
