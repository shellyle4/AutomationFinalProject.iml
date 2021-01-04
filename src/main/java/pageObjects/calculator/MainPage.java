package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage
{
    @FindBy(xpath = "//*[@AutomationId='num0Button']")
    private WebElement btn_zero;

    @FindBy(xpath = "//*[@AutomationId='num1Button']")
    private WebElement btn_one;

    @FindBy(xpath = "//*[@AutomationId='num2Button']")
    private WebElement btn_two;

    @FindBy(xpath = "//*[@AutomationId='num8Button']")
    private WebElement btn_eight;

    @FindBy(xpath = "//*[@AutomationId='plusButton']")
    private WebElement btn_plus;

    @FindBy(xpath = "//*[@AutomationId='divideButton']")
    private WebElement btn_divide;

    @FindBy(xpath = "//*[@AutomationId='multiplyButton']")
    private WebElement btn_multiply;

    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    private WebElement btn_equals;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    private WebElement field_result;

    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    private WebElement btn_clear;

    @FindBy(xpath = "//*[@AutomationId='backSpaceButton']")
    private WebElement btn_backSpace;


    public WebElement getBtn_zero() {
        return btn_zero;
    }
    public WebElement getBtn_one() {
        return btn_one;
    }
    public WebElement getBtn_eight() {
        return btn_eight;
    }
    public WebElement getBtn_plus() {
        return btn_plus;
    }
    public WebElement getBtn_divide() {
        return btn_divide;
    }
    public WebElement getBtn_equals() {
        return btn_equals;
    }
    public WebElement getField_result() {
        return field_result;
    }
    public WebElement getBtn_clear() {
        return btn_clear;
    }
    public WebElement getBtn_backSpace() {
        return btn_backSpace;
    }
    public WebElement getBtn_multiply() {
        return btn_multiply;
    }
    public WebElement getBtn_two() {
        return btn_two;
    }
}
