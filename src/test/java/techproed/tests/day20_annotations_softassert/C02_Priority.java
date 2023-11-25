package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {
WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void YoutubeTest() {
        driver.get("https://youtube.com");
    }

    @Test (priority = 2)  //önceliklendirme yaptık artık numarası 2
    public void AmazonTest() {
        driver.get("https://amazon.com");
    }

    @Test (priority = -1)
    public void FacebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod //Numaralandırmadık, default olarak 0 numarası alır.
    public void tearDown() {
        driver.close();
    }


}
