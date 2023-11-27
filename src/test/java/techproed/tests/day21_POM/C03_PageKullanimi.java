package techproed.tests.day21_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C03_PageKullanimi {

    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım

        //kullanici=Admin

        //kullaniciSifre=admin123

        //Login Testinin basarili oldugunu test edelim

        //sayfayı kapatalim

    }

}
