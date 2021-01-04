package sanity;

import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps
{

    @Test(description = "Test 01 - Verify Addition command")
    @Description("This test verifies the Addition command")
    public void test01_verifyAdditioncommand()
    {
        DesktopFlows.calculateAddition();
        Verfications.verfiyTextInElement(caclMain.getField_result(),"Display is 9");
    }

    @Test(description = "Test 02 - Verify invalidity of division by Zero")
    @Description("This test verifies that dividing number by zero is invalid")
    public void test02_verifyDivisionByZero()
    {
        DesktopFlows.divideByZero();
        Verfications.verfiyTextInElement(caclMain.getField_result(),"Display is Cannot divide by zero");
    }

    @Test(description = "Test 03 - Clear History")
    @Description("This test verifies that the data that was enterd is clear")
    public void test03_clearHistory()
    {
        DesktopFlows.clearData();
        Verfications.verfiyTextInElement(caclMain.getField_result(),"Display is 0");
    }

    @Test(description = "Test 04 - Delete last number")
    @Description("This test verifies the backspace button")
    public void test04_deleteLastNumber()
    {
        DesktopFlows.deleteLastNumber();
        Verfications.verfiyTextInElement(caclMain.getField_result(),"Display is 8");
    }

    @Test(description = "Test 05 - Continue multiplying - 2*2 for 5 times")
    @Description("This test verifies the the result for a multi multiplication")
    public void test05_continueMultiplying()
    {
        DesktopFlows.additionMultiplication();
        Verfications.verfiyTextInElement(caclMain.getField_result(),"Display is 64");
    }
}
