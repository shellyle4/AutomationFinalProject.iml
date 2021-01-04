package sanity;

import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps
{
    @Test(description = "Test 01 - Verify Mortgage")
    @Description("This test fill in mortgage fields and calculate mortgage")
    public void test01_verifyMortgage()
    {
        MobileFlows.calculateMortgage("1000","3", "4");
        Verfications.verfiyTextInElement(mortgageMain.txt_repayment,"£30.03");
    }
}
