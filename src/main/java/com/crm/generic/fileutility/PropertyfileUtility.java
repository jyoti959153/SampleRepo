package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfileUtility 
{
	public String getDataFromPropertyfile(String key) throws Exception {
		FileInputStream fis=new FileInputStream("./ConfigAppdata/CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		System.out.println(data);
		return data;
	}

}
