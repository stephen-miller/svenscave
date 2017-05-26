package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args)  throws IOException  {
		SpringApplication.run(AddressBookApplication.class, args);
		runIntegrationTests();
	}

	private static void runIntegrationTests() throws IOException {
		System.out.println("testing saveNewAddress:");
		sendPost("http://localhost:8082/savenewaddress/street/123 Fake Street/city/Springfield/statecode/IL/zipcode/67834/zipcodeext/8922", null);

		System.out.println("testing getAddressById:");
		sendGet("http://localhost:8082/getaddressbyid/1");
	}

	private static void sendGet(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("Sending get request : "+ url);
		System.out.println("Response code : "+ responseCode);
		// Reading response from input Stream
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String output;
		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();
		System.out.println(response.toString());
	}


	private static void sendPost(String url, String json) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type","application/json");
		if(json != null && !json.equals("")) {
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(json);
			wr.flush();
			wr.close();
		}
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String output;
		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();
		System.out.println(response.toString());
	}
}
