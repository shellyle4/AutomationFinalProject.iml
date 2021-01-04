package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServerAdminMainPage
{
    @FindBy(css = "table[class='filter-table form-inline filter-table--hover']>tbody>tr")
    public List<WebElement> rows;

    @FindBy(css = "a[class='btn btn-primary']")
    public WebElement btn_newUser;

    @FindBy(css = "input[placeholder='Find user by name/login/email']")
    public WebElement txt_search;
}
