package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends UtilitiesPage {


    public  WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }



//    String uid = "user_name";
//    String pwd = "user_password";

    //By uid = By.name("user_name");

    // WebElement uid = driver.findElement(By.name("user_name"));

    @FindBy(name= "user_name")
    WebElement tb_uid;

    @FindBy(name= "user_password")
    WebElement tb_pwd;

    @FindBy(name= "Login")
    WebElement login_Btn;

    @FindBy(linkText= "Logout")
    WebElement logout_lnk;

    @FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement errorMsg;




    public void user_enter_valid_usesrid_password()
    {
       // driver.findElement(By.name(uid)).sendKeys("admin");
        //driver.findElement(By.name(pwd)).sendKeys("admin");
        //driver.findElement(uid).sendKeys("admin");


//        tb_uid.sendKeys("admin");
//        tb_pwd.sendKeys("admin");

        setText(tb_uid,"admin");
        setText(tb_pwd,"admin");


    }

    public  void clickLoginBtn()
    {

        clickElm(login_Btn);
        //login_Btn.click();
    }


    public void login(String userID, String password)
    {
//        tb_uid.sendKeys(userID);
//        tb_pwd.sendKeys(password);

        setText(tb_uid,userID);
        setText(tb_pwd,password);


    }

    public  void verify_loginSuccess()
    {
//        logout_lnk.isDisplayed();
//        logout_lnk.click();

        verifyElement(logout_lnk);
        clickElm(logout_lnk);
    }

    public  void verify_error_msg()
    {
       // errorMsg.isDisplayed();
        verifyElement(errorMsg);
    }



}
