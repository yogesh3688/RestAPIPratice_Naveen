package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// http GET Request
		HttpGet get = new HttpGet(url);
		
		//Hit the url
		CloseableHttpResponse httpresponse =  httpClient.execute(get);
		
		return httpresponse;
	}
	
	
	public CloseableHttpResponse get(String url, HashMap<String,String> headermap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// http GET Request
		HttpGet get = new HttpGet(url);
		
		
		for(Map.Entry<String,String> entry : headermap.entrySet()) {
			get.addHeader(entry.getKey(), entry.getValue());
		}
		
		//Hit the url
		CloseableHttpResponse httpresponse =  httpClient.execute(get);
		
		return httpresponse;
	}
}
