package com.flipkart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.accelarators.Base;

public class FlipKartPages extends Base {

	static WebDriver ldriver;

	public FlipKartPages(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ========================= PAGE METHODS ============================

	public FlipKartLoginPage LoginPage() {
		return new FlipKartLoginPage(ldriver);
	}
	public FlipKartHomePage HomePage() {
		return new FlipKartHomePage(ldriver);
	}
	
	public FlipKartGotoCartPage KartPage() {
		return new FlipKartGotoCartPage(ldriver);
	}
	
	
	
	
	
}
