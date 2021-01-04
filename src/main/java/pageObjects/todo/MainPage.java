package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage
{
    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy(className = "view_2Ow90")
    public List<WebElement> list_tasks;

    @FindBy(className = "destroy_19w1q")
    public WebElement btn_x;

    @FindBy(css = "div[class='view_2Ow90']>label")
    public List<WebElement> listBtn_complete;

    @FindBy(css = "div[class='view_2Ow90']>label>svg>path")
    public List<WebElement> list_completed;

    @FindBy(css = "div[class='view_2Ow90']>svg")
    public List<WebElement> listBtn_delete;

    @FindBy(css = "svg[class='downArrowIcon_3Zu5N']")
    public WebElement btn_arrowIcon;

    @FindBy(css = "div[class='wrapper_3Kpfj vertical_di1oV tagList_2NRe0']>span[class='tag_21fhY']")
    public List<WebElement> list_colors;

    @FindBy(css = "span[class='tag_3u4he']")
    public List<WebElement> list_taskStyle;

    @FindBy(css = "label[class='label_5i8SP']")
    public List<WebElement> list_taskTitle;

    @FindBy(css = "input[class='editingTextInput_2-zuQ']")
    public WebElement txt_editField;

    @FindBy(css = "svg[class='handle dragIcon_1L0_R']")
    public List<WebElement> list_dragHandle;
}


