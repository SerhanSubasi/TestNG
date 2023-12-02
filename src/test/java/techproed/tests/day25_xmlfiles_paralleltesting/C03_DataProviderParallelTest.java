package techproed.tests.day25_xmlfiles_paralleltesting;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_DataProviderParallelTest {

    /*
       BlueRentalCar Sayfasına Gidelim
       Login butonuna tıklayalım
       Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
       Sayfayı kapatalım

          {"ayhancan@bluerentalcars.com", "ayhan"},
          {"beyhancan@bluerentalcars.com", "beyhan"},
          {"seyhan@bluerentalcars.com", "seyhan"},
          {"johnson@bluerentalcars.com", "johnson"}
*/

    @DataProvider (parallel = true) //paralel true ekledik ki hepsini aynı anda çalıştırsın
    public static Object[][] credentials() {
        return new Object[][]{
                {"ayhancan@bluerentalcars.com", "ayhan"},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"seyhan@bluerentalcars.com", "seyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }

    @Test(dataProvider = "credentials",invocationCount = 2) // bununla aynı testleri iki kere çalıştırır ki hata olursa bir daha baksın.
    public void test01(String email,String password) {
        // BlueRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //       Login butonuna tıklayalım
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //       Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password, Keys.ENTER);

        //       Sayfayı kapatalım
        Driver.closeDriver();

    }
}