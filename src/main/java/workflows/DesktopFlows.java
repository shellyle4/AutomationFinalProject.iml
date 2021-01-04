package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps
{
    @Step("Business Flow: Calculate Addition - 1 + 8")
    public static void calculateAddition()
    {
        UIActions.click(caclMain.getBtn_clear());
        UIActions.click(caclMain.getBtn_one());
        UIActions.click(caclMain.getBtn_plus());
        UIActions.click(caclMain.getBtn_eight());
        UIActions.click(caclMain.getBtn_equals());
    }

    @Step("Business Flow: Division by zero")
    public static void divideByZero()
    {
        UIActions.click(caclMain.getBtn_clear());
        UIActions.click(caclMain.getBtn_eight());
        UIActions.click(caclMain.getBtn_divide());
        UIActions.click(caclMain.getBtn_zero());
        UIActions.click(caclMain.getBtn_equals());
    }

    @Step("Business Flow: Clear data")
    public static void clearData()
    {
        UIActions.click(caclMain.getBtn_one());
        UIActions.click(caclMain.getBtn_clear());
    }

    @Step("Business Flow: Delete last number -81")
    public static void deleteLastNumber()
    {
        UIActions.click(caclMain.getBtn_clear());
        UIActions.click(caclMain.getBtn_eight());
        UIActions.click(caclMain.getBtn_one());
        UIActions.click(caclMain.getBtn_backSpace());
    }

    @Step("Business Flow: Continue multiplying by click on equal button - 5 times")
    public static void additionMultiplication()
    {
        UIActions.click(caclMain.getBtn_clear());
        UIActions.click(caclMain.getBtn_two());
        UIActions.click(caclMain.getBtn_multiply());
        UIActions.click(caclMain.getBtn_two());
        UIActions.click(caclMain.getBtn_equals());
        UIActions.click(caclMain.getBtn_equals());
        UIActions.click(caclMain.getBtn_equals());
        UIActions.click(caclMain.getBtn_equals());
        UIActions.click(caclMain.getBtn_equals());
    }
}
