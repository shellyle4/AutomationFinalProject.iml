package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.*;

public class ManagePages extends Base
{
    /*
    Methods description: Each method in this class initiate the pages in it's App
    Methods parameters: null
    Methods return: null
     */

    public static void initGrafana()
    {
        grafanaLogin = PageFactory.initElements(driver, LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, LeftMenuPage.class);
        grafanaServerAdminMenu = PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver,AddNewUserPage.class);
        grafanaEditUser = PageFactory.initElements(driver,EditUserPage.class);
    }

    public static void initmortgage()
    {
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    public static void initTodo()
    {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator()
    {
        caclMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }

}
