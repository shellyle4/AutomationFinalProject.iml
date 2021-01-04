package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps
{
    @Step ("Business Flow: Add new task to the list")
    public static void addNewTask (String taskName)
    {
        UIActions.updateText(todoMain.txt_create,taskName);
        UIActions.insertKey(todoMain.txt_create,Keys.RETURN);
    }

    @Step ("Business Flow: Count and Return Number of Tasks in List")
    public static int getNumberOfTasks ()
    {
        return todoMain.list_tasks.size();
    }

    @Step ("Business Flow: Empty List from Tasks")
    public static void emptyList ()
    {
        for (int i = getNumberOfTasks();i>=1;i--)
        {
            UIActions.click(todoMain.listBtn_delete.get(todoMain.listBtn_delete.size()-i));
        }
    }

    @Step ("Business Flow: Click on Complete Task Button")
    public static void markCompleteTasks ()
    {
        for (int i = 1; i<=getNumberOfTasks();i++)
        {
            UIActions.click(todoMain.listBtn_complete.get(todoMain.listBtn_complete.size()-i));
        }

    }

    @Step ("Business Flow: Count and Return Number of Completed Tasks in List")
    public static int getNumberOfCompletedTasks ()
    {
        return todoMain.list_completed.size();
    }

//    @Step ("Business Flow: Delete Tasks")
//    public static void deleteTasks ()
//    {
//        for (int i = getNumberOfTasks();i>=1;i--)
//        {
//            UIActions.click(todoMain.listBtn_delete.get(todoMain.listBtn_delete.size()-i));
//        }
//    }

    @Step ("Business Flow: Choose Task Color")
    public static void chooseColor(int index)
    {
        UIActions.click(todoMain.btn_arrowIcon);
        UIActions.click(todoMain.list_colors.get(index));
    }

    @Step ("Business Flow: Returns the Color of the task")
    public static String chosenColor()
    {
        for (WebElement elem: todoMain.list_taskStyle){
            return elem.getAttribute("style");
        }
        return null;
    }

    @Step (("Business Flow: Change Task Name"))
    public static void changeName(String newName)
    {
        UIActions.doubleClick(todoMain.list_taskTitle.get(todoMain.list_taskTitle.size()-1));
        UIActions.clearData(todoMain.txt_editField);
        UIActions.updateText(todoMain.txt_editField, newName);
        UIActions.insertKey(todoMain.txt_editField,Keys.RETURN);
    }

    @Step ("Business Flow: Return the task title from the List")
    public static String getTaskTitle ()
    {
        return todoMain.list_taskTitle.get(todoMain.list_taskTitle.size()-1).getText();

    }
}
