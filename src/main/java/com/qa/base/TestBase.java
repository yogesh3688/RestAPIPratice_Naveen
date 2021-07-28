package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	public int RESPONSE_STAUS_CODE_200 = 200;
	public int RESPONSE_STAUS_CODE_400 = 400;
	public int RESPONSE_STAUS_CODE_500 = 500;
	public int RESPONSE_STAUS_CODE_201 = 201;
	public TestBase() {
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		catch(IOException e) {
			
		}
	}

}
