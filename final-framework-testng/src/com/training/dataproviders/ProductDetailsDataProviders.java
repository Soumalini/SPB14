package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

/**
 * This class reads data from different data sources
 * @author SoumaliniBhattachary
 *
 */
public class ProductDetailsDataProviders {

	/*
	 * This method read data from database
	 */
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
	
	@DataProvider(name = "ProductDetailsData") 
	public Object[][] productDetailsData(){ 

		String fileName="C:/Users/SoumaliniBhattachary/Documents/DataProvider/Book4.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}
	
	@DataProvider(name = "AddValidProductDetails") 
	public Object[][] validProductDeatilsData(){ 

		String fileName="C:/Users/SoumaliniBhattachary/Documents/DataProvider/AddValidProductDetails.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}
	@DataProvider(name = "AddInvalidProductDetails") 
	public Object[][] invalidProductDeatilsData(){ 

		String fileName="C:/Users/SoumaliniBhattachary/Documents/DataProvider/AddInvalidproductdetails.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}
	
	
	
	
}
