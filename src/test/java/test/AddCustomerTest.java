package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src/main/java/testData/TF_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phoneNo = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
//	//Test Data
//	String userName = "demo@techfios.com";
//	String password = "abc123";
//	String dashboardValidationText = "Dashboard";
//	String fullName = "Selenium";
//	String company = "Techfios";
//	String email =  "abc@techfios.com";
//	
	@Test
	public void userShouldBeAbleToCreateCustomer() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage("Add Contact");
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNum(phoneNo);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.selectCountry(country);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSaveButton();
		
	}

}
