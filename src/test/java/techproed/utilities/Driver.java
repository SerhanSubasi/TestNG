package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
static WebDriver driver;  //driver singleton olmalı, biricik olmalı. o yüzden static.

    /*
        Page Object Model'de driver için TestBase classına extends yaparak kullanmak yerine, Driver classı oluşturularak bu classtan
        static method aracılığı ile driver oluşturup kullanmak tercih edilir.
         */

    public static WebDriver getDriver () {

if (driver==null) {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
        return driver;
    }

/*
Driver'ı her çağırdığımızda yeni bir pencere açmaması için bir if block oluşturduk.

if(driver==null) ile eğer driver'a değer atanmamış ise driver'ı başlat dedik. Driver açıkken tekrar çağırılırsa
driver'a değer atanmış olduğu için if block çalışmayacak ve mevcut driver'ı tekrar return edecek. Böylece aynı driver üzerinden
test senaryolarımıza devam edebileceğiz.

 */


}
