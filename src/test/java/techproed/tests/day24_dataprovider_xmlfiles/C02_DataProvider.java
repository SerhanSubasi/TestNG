package techproed.tests.day24_dataprovider_xmlfiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProvider {


    @DataProvider(name = "googleurunler")
    public static Object[][] urunler() {
        return new Object[][]{
                {"laptop"},{"iphone"},{"mouse"}
        };
    }

    @Test(dataProvider = "googleurunler")
    public void test01(String data) {

        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //DataProvider ile istediğimiz arac isimlerini aratalım
        new GooglePage().searchBox.sendKeys(data, Keys.ENTER);

        //sayfayı kapatalım
        Driver.closeDriver();

    }

    @Test(dataProvider = "urunler")
    public void test02(String data) {

        //amazon sayfasına gidelim,
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();

        //aramakutusunda dataprovider'dan gelen verileri aratalım
        new AmazonPage().searchBox.sendKeys(data,Keys.ENTER);


        //sayfayı kapatınız
        Driver.closeDriver();

    }
}