package techproed.tests.day22_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PropertiesTest {

    @Test
    public void test01() {
        String amazonUrl = ConfigReader.getProperty("amazonUrl");
        Driver.getDriver().get(amazonUrl);

        // Veya
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @Test
    public void test02() throws InterruptedException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();

        //kullanici=Admin
        //kullaniciSifre=admin123
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("OpenSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("OpenSourcePassword"));
        openSourcePage.submitButton.click();

        Thread.sleep(3000);

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashBoard.isDisplayed());

        //sayfayı kapatalim
        Driver.closeDriver();
    }
}
