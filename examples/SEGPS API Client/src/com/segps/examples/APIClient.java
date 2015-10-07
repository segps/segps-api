package com.segps.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class APIClient {

	private static ClientResponse useJerseyClient(String query) {
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
		WebResource webResource = client.resource(query);
		ClientResponse clientResponse = webResource.get(ClientResponse.class);
		return clientResponse;
	}

	private static HttpResponse useHTTP(String query) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(query);

		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return response;

	}

	public static void main(String[] args) {
		String query = "http://aseg.cs.concordia.ca/segps/...";
		//sample client query using jersey
		ClientResponse response = APIClient.useJerseyClient(query);
		System.out.println("Status: " + response.getStatus());
		System.out.println("Message: " + response.getEntity(String.class));

		//sample client query using httpget
		HttpResponse httpResponse = APIClient.useHTTP(query);
		System.out.println("Response Code : " + httpResponse.getStatusLine().getStatusCode());

		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		try {
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println(result.toString());
	}
}
