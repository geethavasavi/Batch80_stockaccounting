package DriverScript.java;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CommonFunLibrary.ERP_Functions;
import utilities.ExcelFileUtil;

public class newtest {
	ERP_Functions erp=new ERP_Functions();

		@BeforeMethod
		public void adminlogin() throws Throwable
		{	
			
			erp.launchApp("http://webapp.qedge.com/login.php");
			erp.login("admin","master");
		}
		
		@Test
		public void f() throws Throwable 
		{
			ExcelFileUtil exl=new ExcelFileUtil();
			int rc=exl.rowCount("supplier");
			
			
		    for (int i = 1; i <= rc; i++) {
		    	
		    
			String sname=exl.getdata("supplier",i,0);
			String address=exl.getdata("supplier",i,1);
			String city=exl.getdata("supplier",i,2);
			String country=exl.getdata("supplier",i,3);
			String pnumber=exl.getdata("supplier",i,4);
			String cperson=exl.getdata("supplier",i,5);
			String mail=exl.getdata("supplier",i,6);
			String mnumber=exl.getdata("supplier",i,7);
			String note=exl.getdata("supplier",i,8);
			String result=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			exl.setData("Supplier", i, 9, result);	
			
			
			}
		}

	   @AfterMethod
	    public  void closeApp() throws Throwable
	    {
	    	
		    erp.logout();
		    erp.closebrw();
			
			
			
			
			
	    	
	    }

}
