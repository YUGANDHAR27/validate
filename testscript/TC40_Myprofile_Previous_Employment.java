package com.automationAspireportal.testscript;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationAspireportal.helper.DateHelper;
import com.automationAspireportal.helper.EmployeeloginHelper;
import com.automationAspireportal.helper.Validationhelper;
import com.automationAspireportal.testsuite.TestsuiteBase;
import com.automationAspireportal.utils.ReadTimesheetModuleLocators;

public class TC40_Myprofile_Previous_Employment extends TestsuiteBase
{
	ReadTimesheetModuleLocators read=new ReadTimesheetModuleLocators();
	@Test
	public void previousEmployment() throws InterruptedException
	{
		EmployeeloginHelper helper=new EmployeeloginHelper(driver);
		helper.employeelogin();
		Validationhelper validationhelper=new Validationhelper(driver);
		//DateHelper helper1=new DateHelper(driver);
		driver.findElement(By.xpath("//span[contains(text(),'My Profile')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Previous Employment')]")).click();
		driver.findElement(By.xpath("//button[@class=\"btn btn-info pull-right\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add_employment_form\"]/form/div[1]/div[1]/div/input")).sendKeys("ATMECS");
		driver.findElement(By.xpath("//*[@id=\"add_employment_form\"]/form/div[1]/div[2]/div/input")).sendKeys("Trainee - Software Engineer");
		driver.findElement(By.xpath("//*[@id=\"add_employment_form\"]/form/div[1]/div[3]/div/select")).sendKeys("Permanent");
		driver.findElement(By.xpath("//*[@id=\"add_employment_form\"]/form/div[1]/div[4]/div/input")).sendKeys("Software");
		//Thread.sleep(8000);
		//helper1.myProfile();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		WebElement startdate = driver.findElement(By.xpath("//input[@name=\"startDate\"]"));
		startdate.sendKeys(dtf.format(now));
		startdate.sendKeys(Keys.ENTER);
		WebElement endate = driver.findElement(By.xpath("//input[@name=\"exitDate\"]"));	
		endate.sendKeys(dtf.format(now.plusDays(12)));
		endate.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"add_employment_form\"]/form/div[2]/div[3]/div/input")).sendKeys("other empoyeement opportunities");
		driver.findElement(By.xpath("//*[@id=\"add_employment_form\"]/form/div[4]/div/input[2]")).click();
		validationhelper.validation("loc.employeedataalertmsg.txt","validate.employementdata.txt");
		System.out.println("Employment Data Saved successfully");

	}

}
