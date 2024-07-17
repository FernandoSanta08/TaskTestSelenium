package com.castor.crudtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Test
public class CreateTask {
	
	/*
	 * Initialize the web driver and the recurrent variables
	 * */
	
	WebDriver driver;
	  
	By titleBoxLocator = By.xpath("/html/body/div[1]/form/div/input");
	By selectTask = By.xpath("/html/body/div[1]/div/div[1]/div[1]/a");
	By alertLocator = By.xpath("/html/body/div[1]/form/h6");
	
	// Select chrome driver, open the browser in URL to navigate 
  
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8000/tareas");
	}
	
	/**
	   * In this case select the field and write the name of the task and save the task and validate
	   *  the correct alert
	   */
  @Test
  public void Create() {
	
	WebElement titleBox = driver.findElement(titleBoxLocator);
	
	titleBox.clear();
	titleBox.sendKeys("Prueba");
	titleBox.submit();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(alertLocator));
	
	
	WebElement alert = driver.findElement(alertLocator);
	String textAlert = alert.getText();
	
	Assert.assertEquals("Tarea creada correctamente", textAlert );
  }
  
  /**
   * In this case select the field and write the name of the task without the name of
   * characters required and save the task and validate
   *  the correct alert of error
   */
  
	@Test
	public void CreateWithoutMinimumCharacters() {
				
		WebElement titleBox = driver.findElement(titleBoxLocator);
				
		titleBox.clear();
		titleBox.sendKeys("Pr");
		titleBox.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(alertLocator));
		
		WebElement alert = driver.findElement(alertLocator);
		String textAlert = alert.getText();
		
		Assert.assertEquals("The title field must be at least 3 characters.", textAlert );
	 }
	
	/**
	   * In this case select the field, clear the field and submit the the form empty without name of
	   * task required and validate the correct alert of error
	   */
	
	@Test
	public void CreateWithoutText() {
			
		WebElement titleBox = driver.findElement(titleBoxLocator);
		titleBox.clear();
		titleBox.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(alertLocator));
		
		WebElement alert = driver.findElement(alertLocator);
		String textAlert = alert.getText();
		
		Assert.assertEquals("The title field is required.", textAlert );
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
