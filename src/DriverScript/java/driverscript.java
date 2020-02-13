package DriverScript.java;

import CommonFunLibrary.ERP_Functions;
import utilities.ExcelFileUtil;

public class driverscript {

	public static void main(String[] args) throws Throwable {
          ExcelFileUtil exl=new ExcelFileUtil();
		
		 ERP_Functions erp=new ERP_Functions();
		
		int rc=exl.rowCount("Supplier");
		
		for(int i=1;i<=rc;i++)
		{
			String sname=exl.getdata("Supplier", i, 0);
			String address=exl.getdata("Supplier", i, 1);
			String city=exl.getdata("Supplier", i, 2);
			String country=exl.getdata("Supplier", i, 3);
			String pnumber=exl.getdata("Supplier", i, 4);
			String cperson=exl.getdata("Supplier", i, 5);
			String mail=exl.getdata("Supplier", i, 6);
			String mnumber=exl.getdata("Supplier", i, 7);
			String note=exl.getdata("Supplier", i, 8);		
					
					erp.launchApp("http://webapp.qedge.com");
					erp.login("admin", "master");
					String result=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
					erp.closebrw();
					exl.setData("Supplier", i, 9, result);					
		}

	}




	}


