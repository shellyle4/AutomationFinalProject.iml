package sanity;

import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps
{
    @Test(description = "Test 01 - Add And Verify New Task")
    @Description("This test adds new task and verifies it in the list of tasks")
    public void test01_addAndVerifyNewTask()
    {
        ElectronFlows.addNewTask("Learn Java");
        Verfications.verifyNumber(ElectronFlows.getNumberOfTasks(),1);
    }

    @Test(description = "Test 02 - Add And Verify New Task")
    @Description("This test adds new tasks and verifies it in the list of tasks")
    public void test02_addAndVerifyNewTasks()
    {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        Verfications.verifyNumber(ElectronFlows.getNumberOfTasks(),3);
    }

    @Test(description = "Test 03 - Add a New Task and Mark Complete and verify")
    @Description("This test adds new task and mark it as complete")
    public void test03_addAndVerifyCompleteTask()
    {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.markCompleteTasks();
        Verfications.verifyNumber(ElectronFlows.getNumberOfCompletedTasks(),1);
    }

    @Test(description = "Test 04 - Add New Tasks and Mark Complete and verify")
    @Description("This test adds new tasks and mark it as complete")
    public void test04_addAndVerifyCompleteTasks()
    {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.markCompleteTasks();
        Verfications.verifyNumber(ElectronFlows.getNumberOfCompletedTasks(),3);
    }

    @Test(description = "Test 05 - Add New Task, Delete and verify")
    @Description("This test adds new task and delete it and verifies this in the list of tasks")
    public void test05_addDeleteAndVerifyTask()
    {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.emptyList();
        Verfications.verifyNumber(ElectronFlows.getNumberOfTasks(),0);
    }

    @Test(description = "Test 06 - Add New Tasks, Delete and verify")
    @Description("This test adds new tasks and delete it and verifies this in the list of tasks")
    public void test06_addDeleteAndVerifyTasks()
    {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.emptyList();
        Verfications.verifyNumber(ElectronFlows.getNumberOfTasks(),0);
    }

    @Test(description = "Test 07 - Choose Task Color, Add New Task and Verify ")
    @Description("This test add new task in different background color and verifies this in the list of tasks")
    public void test07_chooseColorAndVerify()  {
        ElectronFlows.chooseColor(5);
        ElectronFlows.addNewTask("Learn Java");
        Verfications.verifyText(ElectronFlows.chosenColor(),"background: rgb(210, 137, 226);");
    }

    @Test(description = "Test 08 - Change Title of a Task")
    @Description("This test change the title of an existent task and verifies it in the list of tasks")
    public void test08_changeTitleAndVerify()  {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.changeName("Hello");
        Verfications.verifyText(ElectronFlows.getTaskTitle(),"Hello");
    }
}
