package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verfications extends CommonOps
{
    @Step("Verify Text In Element")
    public static void verfiyTextInElement(WebElement elem, String expexted)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(),expexted);
    }

    @Step("Verify Number Of Elements")
    public static void numberOfElements (List<WebElement> elems, int expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        Assert.assertEquals(elems.size(),expected);
    }

    @Step("Verify Visibility Of Elements (Soft-Assertion")
    public static void visibilityOfElements(List<WebElement> elems)
    {
        for (WebElement elem: elems)
        {
            softAssert.assertTrue(elem.isDisplayed(),elem.getText()+ " not displayed");
        }
        softAssert.assertAll();
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName)
    {
        try {
            screen.find(getData("ImageRepo")+expectedImageName+".PNG");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File: "+findFailed);
            fail("Error Comparing Image File: "+findFailed);
        }
    }

    @Step("Verify Element Displayed")
    public static void existanceOfElement (List<WebElement> elems)
    {
        assertTrue(elems.size()>0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonExistanceOfElement (List<WebElement> elems)
    {
        assertFalse(elems.size()>0);
    }

    @Step("Verify Text with Text")
    public static void verifyText (String actual, String expected)
    {
        assertEquals(actual, expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber (int actual, int expected)
    {
        assertEquals(actual, expected);
    }
}
