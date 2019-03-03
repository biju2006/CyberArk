package web.http2;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Test {

	public static void main(String[] args) {
		try {
		HttpClient httpClient=HttpClient.newHttpClient();
		HttpRequest httpReq=HttpRequest.newBuilder().uri(new URI("http://google.com")).GET().build();
		System.out.println("Request Data:");
		System.out.println(httpClient.version());
		System.out.println(httpReq.uri());
		System.out.println(httpReq.method());
		
		System.out.println("Response Data:");
		HttpResponse<String> httpRes=httpClient.send(httpReq, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpClient.version());
		System.out.println(httpRes.statusCode());
		System.out.println(httpRes.headers());
		System.out.println(httpRes.body());
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
