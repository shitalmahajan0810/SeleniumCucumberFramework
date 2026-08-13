package com.vtiger.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.vtiger.pages.UtilitiesPage.excelData;

public class LeadsStepDefinations extends BaseStepDefinations {


    @When("user click on new lead link")
    public void user_click_on_new_lead_link() {

        leadsp.leads_clk();
        leadsp.newLead_clk();

    }

    @When("user enter firstname with salutationtype DD")
    public void user_enter_firstname_with_salutationtype_DD() {
        leadsp.selectSalutationtype(excelData.get(TC_Name).get("salutationtype"));

    }


    @When("user enter lastname and company and click on save button")
    public void user_enter_lastname_and_company_and_click_on_save_button() {
//        leadsp.lastname_newlead("Mahajan");
//        leadsp.company_newlead("ING");

        leadsp.lastname_newlead(excelData.get(TC_Name).get("lastname"));
        leadsp.company_newlead(excelData.get(TC_Name).get("company"));
        leadsp.save();

    }
    @Then("lead created successfully")
    public void lead_created_successfully() {

        leadsp.new_lead_success();

    }

    @When("user enter lastname only and click on save button")
    public void user_enter_lastname_only_and_click_on_save_button() {

        leadsp.save();
        leadsp.alerthandling();
        //leadsp.lastname_newlead("Mahajan");
        leadsp.lastname_newlead(excelData.get(TC_Name).get("lastname"));
        leadsp.save();

    }
    @Then("lead alert generated for mandatory fields")
    public void lead_alert_generated_for_mandatory_fields() {

        leadsp.alerthandling();
        //leadsp.company_newlead("HSBC");
        leadsp.company_newlead(excelData.get(TC_Name).get("company"));
        leadsp.save();
    }

    @When("user enter lastname as {string}  and company as {string} and click on save button")
    public void user_enter_lastname_as_and_company_as_and_click_on_save_button(String lname, String company, io.cucumber.datatable.DataTable dataTable)
    {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //

        // For other transformations you can register a DataTableType.

        List<Map<String, String>> dt =dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : dt) {

            leadsp.lastname_newlead(row.get("lastname"));
            leadsp.company_newlead(row.get("company"));
            leadsp.save();
            leadsp.newLead_clk();

         }

    }

    @When("user click on leads link")
    public void user_click_on_leads_link()
    {
            leadsp.leads_clk();
    }
    @When("user enter lastname and company and click on search button")
    public void user_enter_lastname_and_company_and_click_on_search_button()
    {
            //leadsp.lastname_search("Mahajan");
            //leadsp.company_search("TCS");
        leadsp.lastname_search(excelData.get(TC_Name).get("lastname"));
        leadsp.company_search(excelData.get(TC_Name).get("company"));
        leadsp.search();
    }

    @Then("user can edit selected lead successfully")
    public void user_can_edit_selected_lead_successfully() {
        leadsp.lead_checkbox_clk();
        leadsp.edit();
        leadsp.fillfax(excelData.get(TC_Name).get("fax"));
        leadsp.save();


    }

    @Then("user can delete selected lead successfully")
    public void user_can_delete_lead_successfully()
    {
            leadsp.lead_checkbox_clk();
            leadsp.delete();
    }


    @When("user click on My Account link")
    public void user_click_on_my_account_link() {
            leadsp.myAccount();
    }
    @When("user select Customize Tab")
    public void user_select_customize_tab() {
            leadsp.customizeTab();
    }
    @Then("user is able to drag and drop tabs successfully")
    public void user_is_able_to_drag_and_drop_tabs_successfully() {

        leadsp.myAccountCustTabDnD();
    }



}