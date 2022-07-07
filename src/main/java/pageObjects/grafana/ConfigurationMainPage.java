package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConfigurationMainPage {

//    @FindBy(css = "a[class='btn btn-primary']")
//    public WebElement btn_addMoreSource;

    @FindBy(css = "a[class='btn btn-primary']")
    public List<WebElement> list_addMoreSource;

    @FindBy (css = "a.css-t1unuy-button")
    public WebElement btn_addNewSource;

    @FindBy (css = "div.card-item-body")
    public List<WebElement> list_dataSources;

    @FindBy (className = "css-m2iibx")
    public WebElement txt_noDataSource;
}
