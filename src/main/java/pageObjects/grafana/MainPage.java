package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage
{
    @FindBy(xpath = "//div[@class='text-center dashboard-header']/span")
    public WebElement head_Deshboard;

    @FindBy(xpath = "//div[@class='progress-tracker']/div")
    public List<WebElement> list_progressSteps;
}
