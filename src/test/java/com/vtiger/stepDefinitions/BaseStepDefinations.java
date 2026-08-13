package com.vtiger.stepDefinitions;

import com.vtiger.pages.LeadsPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStepDefinations {

    static WebDriver  driver= new ChromeDriver();
    static LoginPage lp;
    static LeadsPage leadsp;
    static String TC_Name;
    //static UtilitiesPage utilities;;

}


