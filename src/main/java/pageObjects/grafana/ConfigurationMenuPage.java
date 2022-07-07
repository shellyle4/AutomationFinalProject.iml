package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurationMenuPage {

    @FindBy(xpath = "//a[@href='/datasources']")
    public WebElement link_dataSources;

    @FindBy(xpath = "//a[@href='/org/users']")
    public WebElement link_users;

    @FindBy(xpath = "//a[@href='/org/teams']")
    public WebElement link_teams;

    @FindBy(xpath = "//a[@href='/plugins']")
    public WebElement link_plugins;

    @FindBy(xpath = "//a[@href='/org']")
    public WebElement link_preferences;

    @FindBy(xpath = "a[@href='/org/apikeys']")
    public WebElement link_apikeys;
}
