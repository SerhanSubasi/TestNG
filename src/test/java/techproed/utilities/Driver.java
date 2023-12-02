package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


        /*
        POM modelde Driver class'ından object oluşturarak getDriver methodu kullanımını engellemeliyiz.
        Bu nedenle singleton pattern kullanımı benimsenmiştir.
        Singleton Pattern: Bir class'ın farklı classlardan object oluşturarak kullanılmasını engellemek için kullanılır.
        Bu yüzden constructor'ı private yaptık.
         */

    static WebDriver driver;  //driver singleton olmalı, biricik olmalı. o yüzden static.

        //WebDriver tipinde bir ThreadLocal objecti olusturduk
        //Bu sayede paralel test yaparken her threadin kendi webdriver objectine sahip olmasini sagladik
        //ve böylece pralel olarak calisan farkli threadler birbirlerinin webdriverlerini etkileyemezler
        // ThreadLocal ile her thread için ayrı bir WebDriver objesi oluşturuyoruz.
        private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

        public static WebDriver getDriver() {
            if (driverPool.get() == null) {
                // WebDriver i thread bazında oluşturuyoruz.
                switch (ConfigReader.getProperty("browser")) {
                    case "chrome":
                        driverPool.set(new ChromeDriver());
                        break;
                    case "edge":
                        driverPool.set(new EdgeDriver());
                        break;
                    case "safari":
                        driverPool.set(new SafariDriver());
                        break;
                    default:
                        driverPool.set(new ChromeDriver());
                }

                // Oluşturulan WebDriveri yapılandırıyoruz.
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            }
            // Thread'a özgü WebDriver objecti return ediyoruz.
            return driverPool.get();
        }

        private Driver() {
            // Singleton pattern
        }

  /*
        Page Object Model'de driver için TestBase classına extends yaparak kullanmak yerine, Driver classı oluşturularak bu classtan
        static method aracılığı ile driver oluşturup kullanmak tercih edilir.
         */
/*
Driver'ı her çağırdığımızda yeni bir pencere açmaması için bir if block oluşturduk.

if(driver==null) ile eğer driver'a değer atanmamış ise driver'ı başlat dedik. Driver açıkken tekrar çağırılırsa
driver'a değer atanmış olduğu için if block çalışmayacak ve mevcut driver'ı tekrar return edecek. Böylece aynı driver üzerinden
test senaryolarımıza devam edebileceğiz.
 */

    public static void closeDriver() {
        // Açık olan WebDriver örneğini kapatıyoruz.
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove(); // ThreadLocal'daki referansı temizliyoruz.
        }
    }
}

/*
 if (driver!=null) demeseydik nullPointer hatası alırdık.
 driver=null; bir daha kullanabilmek için de yeniden null verdik. Aryıca hatayı da önler.
 */



