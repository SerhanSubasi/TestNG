package techproed.tests.day21_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.pages.WebAppPage;
import techproed.utilities.Driver;

public class C04_Odev {




    @Test
    public void test01() {

        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Personal"));

        //2. Sign in butonuna basin
        WebAppPage webAppPage = new WebAppPage();
        webAppPage.signInButton.click();

        //3. Login kutusuna "username" yazin
        webAppPage.Login.sendKeys("username");

        //4. Password kutusuna "password" yazin
        webAppPage.Password.sendKeys("password");

        //5. Sign in tusuna basin
        webAppPage.SignIn.click();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        //7. "Purchase Foreign Currency" tusuna basin
        //8. "Currency" drop down menusunden Eurozone'u secin
        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)")
    }

}
