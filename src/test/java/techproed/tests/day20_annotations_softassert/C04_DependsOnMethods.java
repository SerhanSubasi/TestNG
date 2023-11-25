package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {
/*
    TestNG de tum  @Test methodlar birbirlerinden bagimsiz olarak calisirlar
    Eger methodlari bagimli hale getirmek istersem, dependsOnMethods parametresi kullanilir
    Burdaki ornekte, test02 methodu test01 methoduna bagimlidir
    test02 den once test01 calisir
    Eger test01 basarili ise test02 calisir.
    Eget test01 basarisiz ise, test02 IGNORE edilir
 */
WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void test01() {

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratiniz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();
        Assert.assertEquals(2,3); //bilerek hatalı girdik, fail alınca 2. olan skip oluyor

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {

        //sonuc yazisinin iphone icerdigini test edelim
        String sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
