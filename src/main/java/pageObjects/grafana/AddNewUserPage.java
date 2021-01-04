package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage
{
    @FindBy(css = "input[ng-model='user.name']")
    public WebElement txt_name;

    @FindBy(css = "input[ng-model='user.email']")
    public WebElement txt_email;

    @FindBy(css = "input[ng-model='user.login']")
    public WebElement txt_userName;

    @FindBy(css = "input[ng-model='user.password']")
    public WebElement txt_password;

    @FindBy(css = "button[ng-click='create()']")
    public WebElement btn_create;
}
