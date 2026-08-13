package com.vtiger.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class AccountsStepDefinations extends BaseStepDefinations {
    @When("user click on new account link")
    public void user_click_on_new_account_link() {
        driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();

    }

    @When("user enter accountname as {string}  and phone as {string} and click on save button")
    public void user_enter_accountname_and_phone_click_on_save_button(String acname, String phoneno, DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        List<Map<String, String>> dt = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : dt) {
            driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(row.get("acname"));
            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(row.get("phoneno"));
            driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();

        }}

    @Then("Accounts created successfully")
    public void account_created_successfully ()
    {
        driver.findElement(By.xpath("//td[text()='Account Name:']/following-sibling::td[1]")).isDisplayed();

    }


}
