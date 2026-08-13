package com.vtiger.pages;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.*;

public class UtilitiesPage {

    WebDriver driver;
    WebDriverWait wait;
   public static Map<String, Map<String, String>> excelData;
    public static Properties prop;

    public UtilitiesPage(WebDriver driver)  {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }


    public void setText(WebElement elm, String text) {
        try {

            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

    public void clickElm(WebElement elm) {
        try {

            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

    public void checkboxElm(WebElement elm) {
        try {

            wait.until(ExpectedConditions.visibilityOf(elm));
//          Actions action = new Actions(driver);
            elm.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

    public void verifyElement(WebElement elm) {
        try {

            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }


    public void getText(WebElement elm) {
        try {

            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            elm.getText();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void alerthandling() {
        try {
            Alert alert = driver.switchTo().alert();

            wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

    public void dropdownHandling(WebElement elm, String text) {
        try {

            Select select = new Select(elm);
            wait.until(ExpectedConditions.elementToBeSelected(elm));
            select.selectByVisibleText(text);


        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

    public void dragAndDropHandling(WebElement source, WebElement target) {
        try {

            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.elementToBeClickable(source));
            act.dragAndDrop(source,target).perform();

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }

   public static  void readExcel(String SheetName) {
       excelData = new LinkedHashMap<>();
    // fillo read excel
    try {
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\UITestData.xlsx");
        String strQuery = "Select * from "+SheetName;
        Recordset recordset = connection.executeQuery(strQuery);

        int colmcount = recordset.getFieldNames().size();
        //System.out.println(recordset.getFieldNames());

        List<String> colmValues = recordset.getFieldNames();

        while (recordset.next()) {

            Map<String, String> rowData = new HashMap<>();

            String tcName = "";

            for (String column : colmValues) {

                String value = recordset.getField(column);

                if (column.equalsIgnoreCase("TC_Name")) {
                    tcName = value;
                }
                else
                {
                    rowData.put(column, value);
                }
            }

            excelData.put(tcName, rowData);


        }

        recordset.close();
        connection.close();
        System.out.println(excelData);
    }

    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
}


public static void readProperties() {

    try {
         prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties");
        prop.load(fis);


    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
}





    }
