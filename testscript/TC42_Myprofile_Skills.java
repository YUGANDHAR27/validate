package com.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.automationAspireportal.helper.EmployeeloginHelper;
import com.automationAspireportal.testsuite.TestsuiteBase;
import com.automationAspireportal.utils.ReadTimesheetModuleLocators;

public class TC42_Myprofile_Skills extends TestsuiteBase
{
	ReadTimesheetModuleLocators read=new ReadTimesheetModuleLocators();
	@Test
	public void skills() throws InterruptedException
	{
		EmployeeloginHelper helper=new EmployeeloginHelper(driver);
		helper.employeelogin();
	}
}
