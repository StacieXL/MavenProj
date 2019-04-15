package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductNServicesPage;
import com.TestUtil.TestUtil;

public class ProductNServicesPageTest extends TestBase {
	LoginPage loginpage;
	ProductNServicesPage productNServicesPage;
//	TestUtil testutil;
	String SheetName = "NewServiceInfo";	
	
	public ProductNServicesPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws Exception  {
		initil();

		
		productNServicesPage = new ProductNServicesPage();
        loginpage = new LoginPage();
		
		loginpage.VerifyLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
	}
	
	@DataProvider  //To communicate with Excel
	public Object [][] moon() throws Exception{
		Object [][] data = TestUtil.getTestData(SheetName);
		return data;
		
		
	}
	
	
	
	
	@Test (dataProvider = "moon")  //to specify where the data is-which is "moon". "dataProvider" is also keyword
	public void CreateNewOrder(String Name, String SalesPrice, String ItemNumber, String Desc) throws Exception {
		Thread.sleep(1000);
		productNServicesPage.ProductsNServices();
		Thread.sleep(1000);
		productNServicesPage.NewService();
		Thread.sleep(1000);
		
		productNServicesPage.AddService(Name, SalesPrice, ItemNumber, Desc);
		
//		productNServicesPage.AddService("S", "23", "tshirt", "clothing");
		Thread.sleep(1000);
		 
		boolean Message = productNServicesPage.AddServiceSuccess();
		Assert.assertTrue(Message); 
	}
		 
	@AfterMethod
	 public void Teardown() throws InterruptedException {
		 driver.quit();	 
	 }








}
