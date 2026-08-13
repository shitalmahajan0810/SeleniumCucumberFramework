package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadsPage extends UtilitiesPage{

    WebDriver driver;
    public LeadsPage (WebDriver driver)  {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[contains(text(), 'Leads')])[1]")
    WebElement Leads_lnk;

    @FindBy(xpath = "//a[contains(text(),'New Lead')]")
    WebElement New_Lead_lnk;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement tb_lastname_newlead;

    @FindBy(xpath = "(//input[@name='lastname'])[2]")
    WebElement tb_lastname_search;

    @FindBy(xpath = "//input[@name='company']")
    WebElement tb_company_newlead;

    @FindBy(xpath = "(//input[@name='company'])[2]")
    WebElement tb_company_search;

    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    WebElement save_btn;

    @FindBy(xpath = "//input[@title='Search [Alt+Q]']")
    WebElement search_btn;

    @FindBy(xpath = "//td[text()='Last Name:']/following-sibling::td[1]")
    WebElement new_lead_success;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    WebElement lead_checkbox_clk;

    @FindBy(xpath= "(//input[@type='checkbox'])[3]/following::a[text()='edit'][1]")
    WebElement edit_hyperlnk;

    @FindBy(xpath = "//input[@value='Delete']")
    WebElement delete_btn;

    @FindBy(xpath ="//input[@name='fax']")
    WebElement tb_fax;

    @FindBy(xpath = "//select[@name='salutationtype']")
    WebElement salutationtype_DD;

    @FindBy(xpath = "//td[@id='cl1']")
    WebElement myAccountDnD_Source;

    @FindBy(xpath = "//td[@id='cl8']")
    WebElement myAccountDnD_Target;

    @FindBy(xpath="//a[normalize-space(text())='My Account']")
    WebElement myAccount_lnk;

    @FindBy(xpath="//input[@name='Customise']")
    WebElement customize_tab_lnk;

    public void leads_clk()
    {
        clickElm(Leads_lnk);
    }

    public void newLead_clk()
    {
        clickElm(New_Lead_lnk);
    }

    public void lastname_newlead(String lname)
    {
        setText(tb_lastname_newlead, lname);
    }

    public void lastname_search(String lname)
    {
        setText(tb_lastname_search, lname);
    }


    public void company_newlead(String cmp)
    {
        setText(tb_company_newlead, cmp);
    }

    public void company_search(String cmp)
    {
        setText(tb_company_search, cmp);
    }

    public void save ()
    {
        clickElm(save_btn);
    }

    public void search ()
    {
        clickElm(search_btn);
    }

    public void new_lead_success ()
    {
        verifyElement(new_lead_success);
    }

    public void lead_checkbox_clk ()
    {
        clickElm(lead_checkbox_clk);
    }

    public void edit()
    {
        clickElm(edit_hyperlnk);
    }

    public void delete()
    {
        clickElm(delete_btn);
    }

    public void fillfax(String fax)
    {
        setText(tb_fax,fax);
    }

    public  void selectSalutationtype(String salutationtype )
    {
        //dropdownHandling(salutationtype_DD, "Mrs.");
        dropdownHandling(salutationtype_DD,salutationtype);
    }

    public  void myAccountCustTabDnD()
    {
        dragAndDropHandling(myAccountDnD_Source,myAccountDnD_Target);
    }

    public void myAccount()
    {
        clickElm(myAccount_lnk);
    }

    public void customizeTab()
    {
        clickElm(customize_tab_lnk);
    }
 }

