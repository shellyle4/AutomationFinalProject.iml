package sanity;

import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps
{
    @Test(description = "Test 01 - login to Grafana using DB credentials")
    @Description("This test login with DB credentials and verifies main header")
    public void test01_loginDBAndVerifyHeader()
    {
        WebFlows.loginUsingDB();
        Verfications.verfiyTextInElement(grafanaMain.head_Deshboard,"Home Dashboard");
    }


}
