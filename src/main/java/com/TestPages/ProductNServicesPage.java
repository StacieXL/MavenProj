package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductNServicesPage extends TestBase{

	
	
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement Name;

	@FindBy(xpath="//input[@id=\"sales_price\"]")
	WebElement SalesPrice;
	
	@FindBy(xpath="//input[@id=\"item_number\"]")
	WebElement ItemNumber;

	@FindBy(xpath="//a[text()='New Service']")	
	WebElement Service;
	
	@FindBy(xpath="//button[@id=\"submit\"]")	
	WebElement Submit;
	
	@FindBy(xpath="//span[text()='Products & Services']")
	WebElement Products;
	
	@FindBy(xpath="//textarea[@class=\"form-control\"]")
	WebElement Description;
	
	@FindBy(xpath="//*[@class=\"alert alert-success fade in\"]")
	WebElement Success;
	
	public ProductNServicesPage() {
		PageFactory.initElements(driver, this);
	}	
		
	public void ProductsNServices() {
		Products.click();
	}
	public void NewService() {   
		Service.click();               
	}                                   

	public void AddService(String name, String price, String item, String desc) {	
    		Name.sendKeys(name);
    		SalesPrice.sendKeys(price);
    		ItemNumber.sendKeys(item);
    		Description.sendKeys(desc);
    		
    		Submit.click();
    		
    		
    }

	public boolean AddServiceSuccess() {
		return Success.isDisplayed();
		
		
	}


}



	










