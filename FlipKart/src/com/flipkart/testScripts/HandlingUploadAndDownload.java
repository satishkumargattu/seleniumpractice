package com.flipkart.testScripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingUploadAndDownload {
	
    public static void main(String[] args) throws InterruptedException {
    	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		WebDriver webDriver = new ChromeDriver(options);
		webDriver.manage().window().maximize();
        String baseUrl = "http://demo.guru99.com/test/upload/";        

        webDriver.get(baseUrl);
        WebElement uploadElement = webDriver.findElement(By.id("uploadfile_0"));
        
        uploadElement.click();
		uploadFile("C:\\workspace\\IUCommonPage.java");
		Thread.sleep(2000);

        /*// enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\workspace\\IUCommonPage.java");

*/        // check the "I accept the terms of service" check box
        webDriver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        webDriver.findElement(By.name("send")).click();
        }
    
    
    public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
}