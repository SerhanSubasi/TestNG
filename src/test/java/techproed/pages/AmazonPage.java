package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonPage {

    public AmazonPage() { // ilk iş default constructor açmak

        /*
        Bu kod bu classtaki öğeleri driver ile ilişkilendirir.
        Bu sayede classtaki webElementlere erişebilmek için @FindBy gibi PageFactory'e yardımcı olan
        notasyonları kullanılabilir hale getiririz.
         */
             PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox; //searchBox'ı artık istediğimiz kadar kullanabiliriz <3

}
