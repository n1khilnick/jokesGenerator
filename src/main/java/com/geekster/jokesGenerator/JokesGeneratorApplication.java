package com.geekster.jokesGenerator;

import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.sql.SQLOutput;

public class JokesGeneratorApplication {

	public static void main(String[] args)throws Exception {
		URL getUrl= new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		int respondCode=connection.getResponseCode();
		if(respondCode==200){
			BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseData= new StringBuilder();
			String readLine=null;
			while((readLine=in.readLine())!=null){
				responseData.append(readLine);}
			in.close();
			JSONObject randomJokeData= new JSONObject(responseData.toString());
			System.out.println(randomJokeData.toString(4));
		}
		else{
			System.out.println("This is not valid URL "+respondCode);
		}
	}

}
