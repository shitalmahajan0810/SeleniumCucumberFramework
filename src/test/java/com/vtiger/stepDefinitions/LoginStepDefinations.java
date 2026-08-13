package com.vtiger.stepDefinitions;

import com.vtiger.pages.LeadsPage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.vtiger.pages.UtilitiesPage.*;


public class LoginStepDefinations extends BaseStepDefinations {

//    @Before
//    public void setUp(Scenario scenario)
//    {
//
//
//        if (driver == null) {
//            driver = new ChromeDriver();
//        }
//
//            TC_Name =     scenario.getName().trim();
//        readExcel("Sheet1");
//    }


    @Given("the user is on login page")
    public void the_user_is_on_login_page() throws Exception {
        //driver = new ChromeDriver();

        readProperties();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("appUrl"));
        //driver.get("http://localhost:100/");
         lp = new LoginPage(driver);
        leadsp = new LeadsPage(driver);
    }

    @When("the user enter valid user id and password")
    public void user_enter_valid_usesrid_password()
    {
        //lp.login("admin","admin");
        lp.login(excelData.get(TC_Name).get("userid"),excelData.get(TC_Name).get("password"));
    }

    @When("click on login button")
    public void clickLoginButton()
    {
       lp.clickLoginBtn();
    }

    @Then("the user can enter on Home page")
    public void user_on_home_page ()
    {
        lp.verify_loginSuccess();
    }

    @When("the user enter invalid user id and password")
    public void user_invalid_userid_password ()
    {
        //lp.login("admin1","admin1");
        lp.login(excelData.get(TC_Name).get("userid"),excelData.get(TC_Name).get("password"));
    }

    @Then("the user can enter on login page only")
    public void user_can_enter_on_login_page()
    {
        lp.verify_error_msg();    }


}
