package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verfications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps
{
    @Step("Business Flow: Login using DataConfig.xml")
    public static void login (String user, String pass)
    {
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Login using Database Credentials")
    public static void loginUsingDB ()
    {
        String query = "SELECT name, password FROM Employees WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.txt_username, cred.get(0));
        UIActions.updateText(grafanaLogin.txt_password, cred.get(1));
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step ("Business Flow: Create New User")
    public static void createNewUser(String name, String email, String username, String password)
    {
        UIActions.click(grafanaServerAdminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name, name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_userName, username);
        UIActions.updateText(grafanaAddNewUser.txt_password, password);
        UIActions.click(grafanaAddNewUser.btn_create);
    }

    @Step ("Business Flow: Delete Last User")
    public static void deleteLastUser()
    {
        UIActions.click(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size()-1));
        UIActions.click(grafanaEditUser.btn_deleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }

    @Step ("Business Flow: Search and Verify User")
    public static void searchAndVerifyUser(String user, String shouldExist)
    {
        UIActions.updateTextHuman(grafanaServerAdminMain.txt_search, user);
        if (shouldExist.equalsIgnoreCase("exists"))
            Verfications.existanceOfElement(grafanaServerAdminMain.rows);
        else if (shouldExist.equalsIgnoreCase("not-exist"))
            Verfications.nonExistanceOfElement(grafanaServerAdminMain.rows);
        else
            throw new RuntimeException("Invalid Expected Output option in Data Driven Testing, should be exists or not-exist");
    }

    @Step ("Business Flow: Add Data Source")
    public static void addDataSource( String dataSourceName)
    {
        if (grafanaConfigurationMain.list_addMoreSource.size()==0){
            UIActions.click(grafanaConfigurationMain.btn_addNewSource);
        }
        else
            UIActions.click(grafanaConfigurationMain.list_addMoreSource.get(0));

        UIActions.selectFromList(grafanaAddDataSource.list_sourceNames, dataSourceName);
        UIActions.click(grafanaAddDataSource.btn_back);
    }

    @Step ("Business Flow: Delete All Data Source")
    public static void deleteDataSource()
    {
        for (int i = grafanaConfigurationMain.list_dataSources.size()-1; i >= 0 ; i--)
        {
            UIActions.click(grafanaConfigurationMain.list_dataSources.get(i));
            UIActions.click(grafanaAddDataSource.btn_deleteDataSource);
            UIActions.click(grafanaAddDataSource.btn_confirmDelete);
        }
    }
}
