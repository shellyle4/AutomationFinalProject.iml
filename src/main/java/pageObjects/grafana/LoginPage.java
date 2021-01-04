package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
    @FindBy(name = "user")
    public WebElement txt_username;

    @FindBy(name = "password")
    public WebElement txt_password;

    @FindBy(css = "button[type='submit']")
    public WebElement btn_login;

    @FindBy(css = "a[class='btn btn-link']")
    public WebElement btn_skip;
}
