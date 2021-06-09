package com.cyient.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;

public class SignUpTest extends WebDriverWrapper 
{
	@Test
	
	public void signInTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//nav[@class='headerTopNav__menu']//span[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Create an account']")).click();
		
		driver.findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys("Praveen");
		//driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("//input[@data-placeholder='Last name/Surname']")).sendKeys("Kashyap");
		
		driver.findElement(By.xpath("//span[contains(text(),'Month')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'April')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Day')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),' 4 ')]")).click();
		
		driver.findElement(By.xpath("//input[@data-placeholder='Year']")).sendKeys("2000");
		
		driver.findElement(By.xpath("//span[contains(text(),'Country/Region of residence')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[(text()=' India ')]")).click();
		
		driver.findElement(By.xpath("//input[@data-placeholder='Email address']")).sendKeys("praveen@gmail.com");
		driver.findElement(By.xpath("//input[@data-placeholder='Create new password']")).sendKeys("Praveen@#$123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Select one security question')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='What elementary school did you go to?']")).click();
		
		driver.findElement(By.xpath("//input[@data-placeholder='Answer']")).sendKeys("ABC");
		
		driver.findElement(By.xpath("//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Done']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Royal Caribbean");
	}
	
	@Test
	public void invalidCredentialTest() { 
		
		driver.findElement(By.xpath("//div[@class='email-capture__body']//*[local-name()='svg']")).click();
		driver.findElement(By.xpath("//div[@class='headerMainToolbar__menu__icon']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Find a Cruise ')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'2021-2022 Cruises')]")).click();
		driver.findElement(By.xpath("//input[@id='rciFirstName']")).click();
		driver.findElement(By.xpath("//input[@id='rciFirstName']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@id='rciLastName']")).click();
		driver.findElement(By.xpath("//input[@id='rciLastName']")).sendKeys("ABC");
		driver.findElement(By.xpath("//select[@class='md-input']")).click();
		driver.findElement(By.xpath("//option[@value='IND']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		
		String actualValue= driver.findElement(By.id("rciEmailAddressMissing")).getText();
		Assert.assertEquals( actualValue,"Missing Email Address");
		
	}


}
