package com.vtiger.comcast.gereriUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Sanjai
 *
 */

public class FileUtility {
		/**
		 * its used to read the data from commonData.properties File based on Key which you pass as an argument
		 * @param key
		 * @throws Throwable 
		 */
	    public String getPropertyKeyValue(String key) throws Throwable {
	    	 FileInputStream fis = new FileInputStream("./datafile/datafile.properties");
	    	 Properties pobj = new Properties();
	    	 pobj.load(fis);
	    	 String value = pobj.getProperty(key);
			return value;
	    	
	    }
		
	
	    
}
