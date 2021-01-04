package sanity;


import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaApi extends CommonOps
{

    @Test(description = "Test 01 - Add Team And Verify")
    @Description("This Test adds team to Grafana and Verify it")
    public void test01_addTeamAndVerify()
    {
        ApiFlows.postTeam("ShellyTeam", "shelly@gmaill.com");
        Verfications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "ShellyTeam");
    }

    @Test(description = "Test 02 - Get Team From Grafana")
    @Description("This Test Verify Team Property")
    public void test02_verifyTeam()
    {
        Verfications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "ShellyTeam");
    }

    @Test(description = "Test 03 - Update Team And Verify")
    @Description("This Test updates team in Grafana and Verify it")
    public void test03_updateTeamAndVerify()
    {
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.updateTeam("ShellyTeam", "shelly@help.com", id);
        Verfications.verifyText(ApiFlows.getTeamProperty("teams[0].email"), "shelly@help.com");
    }

    @Test(description = "Test 04 - Delete Team And Verify")
    @Description("This Test deletes team in Grafana and Verify it")
    public void test04_deleteTeamAndVerify()
    {
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.deleteTeam(id);
        Verfications.verifyText(ApiFlows.getTeamProperty("totalCount"), "0");
    }

    @Test(description = "Test 05 - Add User And Verify")
    @Description("This Test adds user to Grafana and Verify it")
    public void test05_addUserAndVerify()
    {
        ApiFlows.postUser("userShelly","shelly@gmail.com","shelly","shelly123");
        Verfications.verifyText(ApiFlows.getUserProperty("users[1].name"),"userShelly");
    }

    @Test(description = "Test 06 - Delete User And Verify")
    @Description("This Test deletes user in Grafana and Verify it")
    public void test06_deleteUserAndVerify()
    {
        String id = ApiFlows.getUserProperty("users[1].id");
        ApiFlows.deleteUser(id);
        Verfications.verifyText(ApiFlows.getUserProperty("totalCount"), "1");
    }

}
