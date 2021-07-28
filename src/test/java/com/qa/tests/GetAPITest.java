package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.utils.TestUtils;

public class GetAPITest extends TestBase {

	TestBase testbase;
	String actualUrl;
	CloseableHttpResponse httpresponse;
	RestClient restclient;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		String url  = prop.getProperty("URL");
		String serviceurl  = prop.getProperty("serviceURL");
		
		 actualUrl = url+serviceurl;
		
	}
	
	@Test(priority = 1)
	public void getTestWithoutHeaders() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		httpresponse = restclient.get(actualUrl);
		int statusCode = httpresponse.getStatusLine().getStatusCode();
		System.out.println("statusCode --> "+statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STAUS_CODE_200 , "Status code is not 200");
		
		
		String responseString = EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
//		System.out.println("responseString ---> "+responseString);
		
		
		
		JSONObject jsonObject  = new JSONObject(responseString);
//		System.out.println("jsonObject --> "+jsonObject);
		
		///-------------------------------------------------------
		
		String per_page_value = TestUtils.getValueByJPath(jsonObject,"/per_page");
		
		System.out.println("Value of per_page is "+per_page_value);
		
		Assert.assertEquals(per_page_value, "6"," per_page value mismatch");
		
		///-------------------------------------------------------
		
		String total_value = TestUtils.getValueByJPath(jsonObject,"/total");
		
		System.out.println("Value of per_page is "+total_value);
		
		Assert.assertEquals(total_value, "12"," total_value value mismatch");
		
		//----------------- JSON Array -----------------------------
		
		String id = TestUtils.getValueByJPath(jsonObject,"/data[0]/id");
		String email = TestUtils.getValueByJPath(jsonObject,"/data[0]/email");
		String first_name = TestUtils.getValueByJPath(jsonObject,"/data[0]/first_name");
		String last_name = TestUtils.getValueByJPath(jsonObject,"/data[0]/last_name");
		
		System.out.println("id is "+id);
		System.out.println("email is "+email);
		System.out.println("first Name is "+first_name);
		System.out.println("Last Name is "+last_name);

		
		
		Header [] headerArray = httpresponse.getAllHeaders();
//		System.out.println("headerArray -->  "+headerArray);
		
		HashMap <String,String> allHeaders= new HashMap<String, String>();
		
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		
//		System.out.println("allHeaders ---> "+allHeaders);
	}
	
	@Test(priority = 2)
	public void getTestWithHeaders() throws ClientProtocolException, IOException {
		
		HashMap <String,String> headers = new HashMap<String, String>();
		
//		headers.put("username", "test");
//		headers.put("password", "test123");
//		headers.put("Auth Token", "1234");
		headers.put("Content-Type", "application/json");
		
		restclient = new RestClient();
		httpresponse = restclient.get(actualUrl,headers);
		int statusCode = httpresponse.getStatusLine().getStatusCode();
		System.out.println("statusCode --> "+statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STAUS_CODE_200 , "Status code is not 200");
		
		
		String responseString = EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
//		System.out.println("responseString ---> "+responseString);
		
		
		
		JSONObject jsonObject  = new JSONObject(responseString);
//		System.out.println("jsonObject --> "+jsonObject);
		
		///-------------------------------------------------------
		
		String per_page_value = TestUtils.getValueByJPath(jsonObject,"/per_page");
		
		System.out.println("Value of per_page is "+per_page_value);
		
		Assert.assertEquals(per_page_value, "6"," per_page value mismatch");
		
		///-------------------------------------------------------
		
		String total_value = TestUtils.getValueByJPath(jsonObject,"/total");
		
		System.out.println("Value of per_page is "+total_value);
		
		Assert.assertEquals(total_value, "12"," total_value value mismatch");
		
		//----------------- JSON Array -----------------------------
		
		String id = TestUtils.getValueByJPath(jsonObject,"/data[0]/id");
		String email = TestUtils.getValueByJPath(jsonObject,"/data[0]/email");
		String first_name = TestUtils.getValueByJPath(jsonObject,"/data[0]/first_name");
		String last_name = TestUtils.getValueByJPath(jsonObject,"/data[0]/last_name");
		
		System.out.println("id is "+id);
		System.out.println("email is "+email);
		System.out.println("first Name is "+first_name);
		System.out.println("Last Name is "+last_name);

		
		
		Header [] headerArray = httpresponse.getAllHeaders();
//		System.out.println("headerArray -->  "+headerArray);
		
		HashMap <String,String> allHeaders= new HashMap<String, String>();
		
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		
//		System.out.println("allHeaders ---> "+allHeaders);
	}
	
	
}
