package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Ignore {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test @Ignore //Ignore ile görmezden geldirdik
    public void YoutubeTest() {
        driver.get("https://youtube.com");
    }

    @Test (enabled = false) //Bu şekilde kalıcı olarak devre dışı bırakır.
    public void AmazonTest() {
        driver.get("https://amazon.com");
    }

    @Test
    public void FacebookTest() {
        driver.get("https://facebook.com");
        throw new SkipException("Excel dosyası bağlantısında dosya bulunamadı"); // Bu da başka bir yöntem, skip olarak geçer aşağıdaki logda

        /*
        Bu testte skip exception kullanarak testin çalıştırılmasını run time'da dynamic olarak durdurabiliriz.
        SkipException fırlatıldığında test "Skipped" olarak işaretlenir.
        Dolayısıyla bu yöntem testin belirli koşullar altında atlanması gerektiğinde kullanılabilir.
         */

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}

