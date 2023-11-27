package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class WebAppPage {

    public WebAppPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement Login;

    @FindBy(id = "user_password")
    public WebElement Password;

    @FindBy(name = "submit")
    public WebElement SignIn;

}
