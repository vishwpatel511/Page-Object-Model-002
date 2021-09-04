package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
 
	@DataProvider
	  public static Object[][] datapro(){
		
		  Object[][] data = new Object[3][2];
		  
		  data[0][0] = "Johny";
		  data[0][1] = "Walker";
		  data[1][0] = "Peter";
		  data[1][1] = "Parker";
		  data[2][0] = "Robert";
		  data[2][1] = "Junior";
		  
		  return data;
		  
	  }

}
