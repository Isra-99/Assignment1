package temperature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Checkout;
import pages.FinalReceipt;
import pages.HomePage;
import pages.Sunscreens;
import static org.testng.Assert.*;

public class Temperaturetest {

    private WebDriver driver;
    public void starttest(){
        System.setProperty("webdriver.chrome.driver","resourcess/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().window().maximize();
        HomePage homePage= new HomePage(driver);
        Sunscreens s = new Sunscreens(driver);
        homePage.clickTempButton();
        s.ClickButton1(driver);
        s.ClickButton2(driver);
        s.displayselecteditem();
        s.addToCart();
        Checkout c  = new Checkout(driver);
        c.billsum();
        c.checktotalprices();
        c.checkitems();
        c.payclick();
        //assertEquals(s.displayselecteditem(),c.checkitems());
        c.enteremail("icheetah1999@gmail.com");
        c.enterCrdnumber( "4242");
        c.enterCrdnumber( "4242");
        c.enterCrdnumber( "4242");
        c.enterCrdnumber( "4242");
        c.enterMonth("05");
        c.enterMonth("22");
        c.enterCVC("333");
        c.enterZipcode("35004");
        c.clickpaybutton(driver);
        FinalReceipt fr = new FinalReceipt(driver);
        //assertTrue(fr.Alert().contains(("PAYMENT SUCCESS")),"Alert is incorrrect");
        fr.Alert();



    }
    public static void main(String arg[]){
        // creating instant of TemperatureTest
        Temperaturetest testing = new Temperaturetest();
        testing.starttest();
    }
}
