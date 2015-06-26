package com.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class used to invoke Google Time Zone API REST service by jersey client
 * 
 * @author Chathuri
 *
 */
public class GoogleAPIClient {
	
	public static final String URI = 
			"https://maps.googleapis.com/maps/api/timezone/json?location=39.6034810,-119.6822510" + 
					"&timestamp=1331161200&key";

	public static void main(String[] args) {
		
		try {		
			System.out.println("--- Calling Google Time Zone API REST service --- \n");
			 
			//Create new instances of Client.
			Client client = ClientBuilder.newClient();
			
			WebTarget target = client.target(URI);
			
			//Add API key
			WebTarget targetWithQueryParam = 
					target.queryParam("key", "AIzaSyDMxZfVGqBYgG1LFTd_eZperx2RVDIKx80");
			
			//Create a new invocation builder instance to start building a new HTTP request invocation
			Invocation.Builder invocationBuilder =
					targetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
			 
			Response response = invocationBuilder.get();
			
			System.out.println("Status is : " + response.getStatusInfo());
			System.out.println(response.readEntity(String.class));
	 
		  } catch (Exception e) {	 
			System.out.println("Exception occured : " + e.getMessage()); 
		  }		
	}
}
