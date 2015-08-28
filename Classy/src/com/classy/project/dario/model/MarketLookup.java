package com.classy.project.dario.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.NetworkOnMainThreadException;
import android.util.Log;

public class MarketLookup
{
	private String access_token, lookupURL;
	
	public MarketLookup()
	{
		access_token = "f2634c5990cde0b5cb6e8bd2b271f1d360803ce7";
		lookupURL = "https://42matters.com/api/1/apps/lookup.json?p=";
	}
	
	public String getAccessToken() {return access_token;}
	
	public String getLookupURL() {return lookupURL;}
	
	public void resetLookupURL() {lookupURL = "https://42matters.com/api/1/apps/lookup.json?p=";}
	
	public String lookup(String packageName)
	{
		URL url;
		Scanner scan;
		String jsonContents = "";
		JSONObject appCategory;
		String cat;
	    
		lookupURL += packageName + "&access_token=" + access_token;
		
		try
		{
			// lookup url for app
			url = new URL(lookupURL);
			scan = new Scanner(url.openStream());
			
			// Put contents into String
		    while (scan.hasNext()) {jsonContents += scan.nextLine();}
		    scan.close();
		    
		    appCategory = new JSONObject(jsonContents);
		    cat = appCategory.getString("category");
		}
		catch (MalformedURLException e)
		{
			Log.e("URL ERROR", "Invalid URL");
			return null;
		}
		catch (IOException e)
		{
			Log.e("I/O ERROR", "Could not find " + packageName);
			return null;
		}
		catch (JSONException e)
		{
			Log.e("JSON ERROR", "Check JSONObject");
			return null;
		}
		catch(NetworkOnMainThreadException e)
		{
			Log.e("Network ERROR", "Check stack trace");
			return null;
		}
		resetLookupURL();
		return cat;
	}
}