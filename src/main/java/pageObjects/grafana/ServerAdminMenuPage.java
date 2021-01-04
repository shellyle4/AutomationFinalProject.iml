package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminMenuPage
{
    @FindBy(xpath = "//a[@href='/admin/users']")
    public WebElement link_users;

    @FindBy(xpath = "//a[@href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(xpath = "//a[@href='/admin/settings']")
    public WebElement link_settings;

    @FindBy(xpath = "//a[@href='/admin/stats']")
    public WebElement link_stats;
}
