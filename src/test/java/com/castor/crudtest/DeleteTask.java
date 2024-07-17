package com.castor.crudtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteTask {
	
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
	   * In this case select the task to delete and validate the correct alert
	   */
	@Test
	public void Delete() {
		
		WebElement taskDelete = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/form/button"));
		
		taskDelete.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(alertLocator));
		
		WebElement alert = driver.findElement(alertLocator);
		String textAlert = alert.getText();
		
		Assert.assertEquals("Tarea eliminada correctamente", textAlert );
	}

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
}
