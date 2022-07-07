package sanity;

import extensions.UIActions;
import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps
{
    @Test(description = "Test 01 - Verify Header")
    @Description("This test login and verifies main header")
    public void test01_verifyHeader()
    {
        WebFlows.login(getData("UserName"),getData("Password"));
        Verfications.verfiyTextInElement(grafanaMain.head_Deshboard,"Home Dashboard");
    }

    @Test (description = "Test 02 - Verify Default Users")
    @Description("This test verifies the default users")
    public void test02_verifyDefultUsers()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_server,grafanaServerAdminMenu.link_users);
        Verfications.numberOfElements(grafanaServerAdminMain.rows,1);
    }

    @Test (description = "Test 03 - Verify New User")
    @Description("This test verifies a new user has been added")
    public void test03_verifyNewUser()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_server,grafanaServerAdminMenu.link_users);
        WebFlows.createNewUser("Shelly", "shelly@bb.com","shelly","12345");
        Verfications.numberOfElements(grafanaServerAdminMain.rows,2);
    }

    @Test (description = "Test 04 - Verify Last User Deletion")
    @Description("This test verifies the deletion of the last user in the list")
    public void test04_verifyUserDeletion()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_server,grafanaServerAdminMenu.link_users);
        WebFlows.deleteLastUser();
        Verfications.numberOfElements(grafanaServerAdminMain.rows,1);
    }

    @Test (description = "Test 05 - Verify Progress Steps")
    @Description("This test verifies the default progress steps are displayed (using soft assertion)")
    public void test05_verifyProgressSteps()
    {
        Verfications.visibilityOfElements(grafanaMain.list_progressSteps);
    }

    @Test (description = "Test 06 - Verify Avatar Icon")
    @Description("This test verifies the avatar image using Sikuli tool")
    public void test06_verifyAvatarIcon()
    {
        Verfications.visualElement("GrafanaAdminAvatar");
    }

    @Test (description = "Test 07 - Search Users", dataProvider = "data-provider-users",dataProviderClass = utilities.ManageDDT.class)
    @Description("This test Search Users in a table using DDT")
    public void test07_searchUsers(String user, String shouldExist)
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_server,grafanaServerAdminMenu.link_users);
        WebFlows.searchAndVerifyUser(user, shouldExist);
    }

    @Test (description = "Test 08 - Add New Data Source")
    @Description("This test add data source")
    public void test08_addDataSource()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_configuration,grafanaConfigurationMenu.link_dataSources);
        int i = UIActions.getListSize( grafanaConfigurationMain.list_dataSources);//2
        WebFlows.addDataSource("Loki");//1
        Verfications.verifyNumber(UIActions.getListSize( grafanaConfigurationMain.list_dataSources),i+1);

    }

    @Test (description = "Test 09 - Remove Data Source from list")
    @Description("This test remove data source")
    public void test09_removeDataSource()
    {
        UIActions.mouseHover(grafanaLeftMenu.btn_configuration,grafanaConfigurationMenu.link_dataSources);
        WebFlows.deleteDataSource();
        Verfications.verfiyTextInElement(grafanaConfigurationMain.txt_noDataSource,"There are no data sources defined yet");

    }
}
