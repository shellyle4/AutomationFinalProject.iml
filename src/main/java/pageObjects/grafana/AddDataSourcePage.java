package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddDataSourcePage {

    @FindBy (css = "span.add-data-source-item-text")
    public List<WebElement> list_sourceNames;

    @FindBy (css = "button[class='btn btn-danger']")
    public WebElement btn_deleteDataSource;

    @FindBy (css = "button[ng-show='onConfirm']")
    public WebElement btn_confirmDelete;

    @FindBy (css = "a[class='btn btn-inverse']")
    public WebElement btn_back;

}
