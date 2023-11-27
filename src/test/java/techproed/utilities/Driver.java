package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
static WebDriver driver;

    /*
        Page Object Model'de driver için TestBase classına extends yaparak kullanmak yerine, Driver classı oluşturularak bu classtan
        static method aracılığı ile driver oluşturup kullanmak tercih edilir.
         */

    public static WebDriver getDriver () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;

    }




}
