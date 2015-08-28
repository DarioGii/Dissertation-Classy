package com.classy.project.dario.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionCategories {

	private HashMap<String, List<String>> catPermissions;
	private HashMap<String, Integer> catScores;
	private List<String> gamesPerms, gameSportsPerms, bookPerms, businessPerms, comicsPerms, commPerms, educationPerms,
	entPerms, financePerms, healthPerms, libPerms, lifestylePerms, wallPerms, mediaPerms,
	medicalPerms, musicPerms, newsPerms, personalizationPerms, photoPerms, prodPerms, shoppingPerms, socialPerms,
	sportsPerms, toolsPerms, transportPerms, travelPerms, weatherPerms, widgetsPerms;
	private AppInfo app;
	
	public PermissionCategories()
	{
		catPermissions = new HashMap<String, List<String>>();
		catScores = new HashMap<String, Integer>();
		catScores.put("Games", 0);
    	catScores.put("Books & Reference", 0);
    	catScores.put("Business", 0);
    	catScores.put("Comics", 0);
    	catScores.put("Communication", 0);
    	catScores.put("Education", 0);
    	catScores.put("Entertainment", 0);
    	catScores.put("Finance", 0);
    	catScores.put("Health & Fitness", 0);
    	catScores.put("Libraries & Demo", 0);
    	catScores.put("Lifestyle", 0);
    	catScores.put("Live Wallpaper", 0);
    	catScores.put("Media & Video", 0);
    	catScores.put("Medical", 0);
    	catScores.put("Music & Audio", 0);
    	catScores.put("News & Magazines", 0);
    	catScores.put("Personalization", 0);
    	catScores.put("Photography", 0);
    	catScores.put("Productivity", 0);
    	catScores.put("Shopping", 0);
    	catScores.put("Social", 0);
    	catScores.put("Sports", 0);
    	catScores.put("Tools", 0);
    	catScores.put("Transportation", 0);
    	catScores.put("Travel & Local", 0);
    	catScores.put("Weather", 0);
    	catScores.put("Widgets", 0);
		
    	gamesPerms = new ArrayList<String>();
    	gameSportsPerms = new ArrayList<String>();
		bookPerms = new ArrayList<String>();
		businessPerms = new ArrayList<String>();
		comicsPerms = new ArrayList<String>();
		commPerms = new ArrayList<String>();
		educationPerms = new ArrayList<String>();
		entPerms = new ArrayList<String>();
		financePerms = new ArrayList<String>();
		healthPerms = new ArrayList<String>();
		libPerms = new ArrayList<String>();
		lifestylePerms = new ArrayList<String>();
		wallPerms = new ArrayList<String>();
		mediaPerms = new ArrayList<String>();
		medicalPerms = new ArrayList<String>();
		musicPerms = new ArrayList<String>();
		newsPerms = new ArrayList<String>();
		personalizationPerms = new ArrayList<String>();
		shoppingPerms = new ArrayList<String>();
		prodPerms = new ArrayList<String>();
		socialPerms = new ArrayList<String>();
		sportsPerms = new ArrayList<String>();
		toolsPerms = new ArrayList<String>();
		transportPerms = new ArrayList<String>();
		travelPerms = new ArrayList<String>();
		photoPerms = new ArrayList<String>();
		weatherPerms = new ArrayList<String>();
		widgetsPerms = new ArrayList<String>();
    	
    	initCatCollections();
	}
	/*
	 * Initialises the HashMap with ArrayLists. The ArrayLists represent categories and are filled with 
	 * Strings containing permissions which are likely to be in their category.
	 */
	private void initCatCollections()
	{
		educationPerms.add("android.permission-group.COST_MONEY");
		educationPerms.add("android.permission.ACCESS_WIFI_STATE");
		educationPerms.add("android.permission.ACCESS_FINE_LOCATION");
		educationPerms.add("android.permission-group.LOCATION");
		educationPerms.add("com.android.vending.BILLING");
		educationPerms.add("android.permission.GET_ACCOUNTS");
		educationPerms.add("android.permission.READ_USER_DICTIONARY");
		educationPerms.add("android.permission.WRITE_USER_DICTIONARY");
		educationPerms.add("android.permission.ACCESS_NETWORK_STATE");
		educationPerms.add("android.permission.INTERNET");
		educationPerms.add("android.permission.WRITE_CALENDAR");
		educationPerms.add("android.permission.READ_CALENDAR");
		educationPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		educationPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		
		sportsPerms.add("android.permission.ACCESS_WIFI_STATE");
		sportsPerms.add("com.android.vending.BILLING");
		sportsPerms.add("android.permission.GET_ACCOUNTS");
		sportsPerms.add("android.permission.INTERNET");
		sportsPerms.add("android.permission.ACCESS_FINE_LOCATION");
		sportsPerms.add("android.permission.ACCESS_NETWORK_STATE");
		sportsPerms.add("android.permission.VIBRATE");
		
		transportPerms.add("android.permission-group.COST_MONEY");
		transportPerms.add("com.android.vending.BILLING");
		transportPerms.add("android.permission.ACCESS_WIFI_STATE");
		transportPerms.add("android.permission.ACCESS_FINE_LOCATION");
		transportPerms.add("android.permission-group.LOCATION");
		transportPerms.add("android.permission.ACCESS_NETWORK_STATE");
		transportPerms.add("android.permission.INTERNET");
		transportPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		transportPerms.add("android.permission.GET_ACCOUNTS");
		
		travelPerms.add("android.permission.ACCESS_WIFI_STATE");
		travelPerms.add("android.permission.ACCESS_FINE_LOCATION");
		travelPerms.add("android.permission.ACCESS_NETWORK_STATE");
		travelPerms.add("android.permission.INTERNET");
		travelPerms.add("android.permission-group.LOCATION");
		travelPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		travelPerms.add("android.permission.GET_ACCOUNTS");
		
		socialPerms.add("android.permission.READ_CONTACTS");
		socialPerms.add("android.permission.WRITE_CONTACTS");
		socialPerms.add("android.permission.BIND_DIRECTORY_SEARCH");
		socialPerms.add("android.permission.READ_CALL_LOG");
		socialPerms.add("android.permission.WRITE_CALL_LOG");
		socialPerms.add("android.permission.READ_PROFILE");
		socialPerms.add("android.permission.WRITE_PROFILE");
		socialPerms.add("android.permission.BODY_SENSORS");
		socialPerms.add("android.permission-group.LOCATION");
		socialPerms.add("android.permission.ACCESS_FINE_LOCATION");
		socialPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		socialPerms.add("android.permission.ACCESS_NETWORK_STATE");
		socialPerms.add("android.permission.ACCESS_WIFI_STATE");
		socialPerms.add("android.permission.ACCESS_GPS");
		socialPerms.add("android.permission.VIBRATE");
		socialPerms.add("android.permission.FLASHLIGHT");
		socialPerms.add("android.permission-group.CAMERA");
		socialPerms.add("android.permission.CAMERA");
		socialPerms.add("android.permission.GET_ACCOUNTS");
		socialPerms.add("android.permission.RECEIVE_BOOT_COMPLETED");
		socialPerms.add("android.permission.MANAGE_ACCOUNTS");
		socialPerms.add("android.permission.AUTHENTICATE_ACCOUNTS");
		socialPerms.add("android.permission.READ_CONTACTS");
		socialPerms.add("android.permission.WRITE_CONTACTS");
		socialPerms.add("android.permission.READ_PROFILE");
		socialPerms.add("android.permission.USE_CREDENTIALS");
		socialPerms.add("android.permission.RECORD_AUDIO");
		socialPerms.add("android.permission-group.PERSONAL_INFO");
		socialPerms.add("android.permission-group.SOCIAL_INFO");
		socialPerms.add("android.permission-group.MICROPHONE");
		socialPerms.add("com.google.android.c2dm.permission.RECEIVE");
		socialPerms.add("com.instagram.android.permission.C2D_MESSAGE");
		socialPerms.add("com.instagram.android.permission.RECEIVE_ADM_MESSAGE");
		socialPerms.add("com.nokia.pushnotifications.permission.RECEIVE");
		socialPerms.add("com.linkedin.android.permission.C2D_MESSAGE");
		
		weatherPerms.add("android.permission.ACCESS_WIFI_STATE");
		weatherPerms.add("android.permission.ACCESS_FINE_LOCATION");
		weatherPerms.add("android.permission.ACCESS_NETWORK_STATE");
		weatherPerms.add("android.permission-group.LOCATION");
		weatherPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		weatherPerms.add("android.permission.GET_ACCOUNTS");
		weatherPerms.add("android.permission.MANAGE_ACCOUNTS");
		weatherPerms.add("android.permission.READ_SYNC_SETTINGS");
		weatherPerms.add("android.permission.READ_SYNC_STATS");
		weatherPerms.add("android.permission.INTERNET");
		weatherPerms.add("android.permission.RECEIVE_BOOT_COMPLETED");
		weatherPerms.add("com.android.vending.BILLING");
		
		widgetsPerms.add("android.permission.ACCESS_WIFI_STATE");
		widgetsPerms.add("android.permission.ACCESS_NETWORK_STATE");
		widgetsPerms.add("android.permission-group.LOCATION");
		widgetsPerms.add("android.permission.ACCESS_FINE_LOCATION");
		widgetsPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		
		entPerms.add("android.permission-group.COST_MONEY");
		entPerms.add("com.android.vending.BILLING");
		entPerms.add("android.permission.ACCESS_WIFI_STATE");
		entPerms.add("android.permission.ACCESS_NETWORK_STATE");
		entPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		entPerms.add("android.permission.INTERNET");
		entPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		entPerms.add("android.permission.WAKE_LOCK");
		entPerms.add("android.permission.GET_ACCOUNTS");
		
		financePerms.add("android.permission-group.COST_MONEY");
		financePerms.add("com.android.vending.BILLING");
		financePerms.add("android.permission.ACCESS_NETWORK_STATE");
		financePerms.add("android.permission.ACCESS_WIFI_STATE");
		financePerms.add("android.permission.READ_CONTACTS");
		financePerms.add("android.permission.READ_EXTERNAL_STORAGE");
		financePerms.add("android.permission.INTERNET");
		financePerms.add("android.permission.ACCESS_GPS");
		financePerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		financePerms.add("android.permission.GET_ACCOUNTS");
		financePerms.add("android.permission.SEND_SMS");
		financePerms.add("android.permission.READ_CALENDAR");
		financePerms.add("android.permission.WRITE_CALENDAR");
		financePerms.add("android.permission.READ_CALL_LOG");
		financePerms.add("android.permission.CALL_PHONE");
		
		healthPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		healthPerms.add("android.permission.ACCESS_FINE_LOCATION");
		healthPerms.add("android.permission.ACCESS_NETWORK_STATE");
		healthPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		healthPerms.add("android.permission-group.LOCATION");
		healthPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		healthPerms.add("android.permission.ACCESS_WIFI_STATE");
		healthPerms.add("android.permission-group.COST_MONEY");
		healthPerms.add("android.permission.BLUETOOTH");
		healthPerms.add("android.permission.INTERNET");
		healthPerms.add("android.permission.WAKE_LOCK");
		
		libPerms.add("android.permission.ACCESS_NETWORK_STATE");
		libPerms.add("android.permission.ACCESS_WIFI_STATE");
		libPerms.add("android.permission.INTERNET");
		
		lifestylePerms.add("android.permission.ACCESS_NETWORK_STATE");
		lifestylePerms.add("android.permission.ACCESS_WIFI_STATE");
		lifestylePerms.add("android.permission.READ_EXTERNAL_STORAGE");
		lifestylePerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		lifestylePerms.add("android.permission.INTERNET");
		lifestylePerms.add("android.permission.GET_ACCOUNTS");
		lifestylePerms.add("android.permission-group.LOCATION");
		lifestylePerms.add("android.permission.ACCESS_COARSE_LOCATION");
		lifestylePerms.add("android.permission.ACCESS_FINE_LOCATION");
		lifestylePerms.add("android.permission.USE_CREDENTIALS");
		lifestylePerms.add("com.google.android.c2dm.permission.RECEIVE");
		
		wallPerms.add("android.permission-group.WALLPAPER");
		wallPerms.add("android.permission.INTERNET");
		wallPerms.add("android.permission.SET_WALLPAPER");
		wallPerms.add("android.permission.SET_WALLPAPER_HINTS");
		wallPerms.add("android.permission.ACCESS_NETWORK_STATE");
		wallPerms.add("android.permission.ACCESS_WIFI_STATE");
		wallPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		wallPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		
		medicalPerms.add("android.permission.READ_CALENDAR");
		medicalPerms.add("android.permission.WRITE_CALENDAR");
		medicalPerms.add("android.permission.INTERNET");
		medicalPerms.add("android.permission.ACCESS_NETWORK_STATE");
		medicalPerms.add("android.permission.ACCESS_WIFI_STATE");
		medicalPerms.add("android.permission-group.LOCATION");
		medicalPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		medicalPerms.add("android.permission.ACCESS_FINE_LOCATION");
		medicalPerms.add("android.permission.ACCESS_GPS");
		
		mediaPerms.add("android.permission-group.AUDIO_SETTINGS");
		mediaPerms.add("android.permission.MODIFY_AUDIO_SETTINGS");
		mediaPerms.add("android.permission.ACCESS_NETWORK_STATE");
		mediaPerms.add("android.permission.ACCESS_WIFI_STATE");
		mediaPerms.add("android.permission.RECORD_AUDIO");
		mediaPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		mediaPerms.add("android.permission.INTERNET");
		mediaPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		mediaPerms.add("android.permission.WAKE_LOCK");
		mediaPerms.add("android.permission-group.CAMERA");
		mediaPerms.add("android.permission.CAMERA");
		mediaPerms.add("android.permission-group.MICROPHONE");
		
		prodPerms.add("android.permission.ACCESS_NETWORK_STATE");
		prodPerms.add("android.permission.ACCESS_WIFI_STATE");
		prodPerms.add("android.permission.GET_ACCOUNTS");
		prodPerms.add("android.permission.RECORD_AUDIO");
		prodPerms.add("android.permission-group.MICROPHONE");
		prodPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		prodPerms.add("android.permission.INTERNET");
		prodPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		prodPerms.add("com.android.vending.BILLING");
		prodPerms.add("android.permission-group.COST_MONEY");
		prodPerms.add("android.permission.READ_USER_DICTIONARY");
		prodPerms.add("android.permission.WRITE_USER_DICTIONARY");
		prodPerms.add("android.permission.READ_CALENDAR");
		prodPerms.add("android.permission.WRITE_CALENDAR");
		
		photoPerms.add("android.permission.ACCESS_NETWORK_STATE");
		photoPerms.add("android.permission.ACCESS_WIFI_STATE");
		photoPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		photoPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		photoPerms.add("android.permission.SET_WALLPAPER");
		photoPerms.add("android.permission-group.CAMERA");
		photoPerms.add("android.permission.CAMERA");
		photoPerms.add("android.permission-group.MICROPHONE");
		photoPerms.add("android.permission-group.LOCATION");
		photoPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		photoPerms.add("android.permission.ACCESS_GPS");
		photoPerms.add("android.permission.ACCESS_FINE_LOCATION");
		photoPerms.add("android.permission.WAKE_LOCK");
		
		newsPerms.add("android.permission.ACCESS_NETWORK_STATE");
		newsPerms.add("android.permission.ACCESS_WIFI_STATE");
		newsPerms.add("android.permission.GET_ACCOUNTS");
		newsPerms.add("android.permission.INTERNET");
		newsPerms.add("android.permission.MANAGE_ACCOUNTS");
		newsPerms.add("android.permission.WAKE_LOCK");
		newsPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		newsPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		
		personalizationPerms.add("android.permission-group.COST_MONEY");
		personalizationPerms.add("android.permission.ACCESS_WIFI_STATE");
		personalizationPerms.add("android.permission.INTERNET");
		personalizationPerms.add("android.permission.ACCESS_NETWORK_STATE");
		personalizationPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		personalizationPerms.add("com.android.vending.BILLING");
		personalizationPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		personalizationPerms.add("android.permission.VIBRATE");
		personalizationPerms.add("android.permission.BIND_APPWIDGET");
		personalizationPerms.add("android.permission.READ_SMS");
		personalizationPerms.add("android.permission.WRITE_SMS");
		personalizationPerms.add("android.permission.SEND_SMS");
		
		shoppingPerms.add("android.permission.ACCESS_NETWORK_STATE");
		shoppingPerms.add("android.permission.ACCESS_WIFI_STATE");
		shoppingPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		shoppingPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		shoppingPerms.add("android.permission.GET_ACCOUNTS");
		shoppingPerms.add("android.permission.INTERNET");
		shoppingPerms.add("android.permission-group.LOCATION");
		shoppingPerms.add("android.permission.MANAGE_ACCOUNTS");
		shoppingPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		shoppingPerms.add("android.permission.ACCESS_FINE_LOCATION");
		shoppingPerms.add("android.permission.NFC");
		shoppingPerms.add("android.permission-group.CAMERA");
		shoppingPerms.add("android.permission.CAMERA");
		
		businessPerms.add("android.permission.ACCESS_NETWORK_STATE");
		businessPerms.add("android.permission.ACCESS_WIFI_STATE");
		businessPerms.add("android.permission-group.CAMERA");
		businessPerms.add("android.permission.CAMERA");
		businessPerms.add("android.permission.INTERNET");
		businessPerms.add("android.permission.VIBRATE");
		businessPerms.add("android.permission.GET_ACCOUNTS");
		businessPerms.add("android.permission.MANAGE_ACCOUNTS");
		businessPerms.add("android.permission.AUTHENTICATE_ACCOUNTS");
		businessPerms.add("android.permission.USE_CREDENTIALS");
		businessPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		businessPerms.add("com.android.vending.BILLING");
		businessPerms.add("android.permission-group.COST_MONEY");
		businessPerms.add("android.permission.WRITE_EXTERNAL_STORAGE");
		
		bookPerms.add("android.permission-group.COST_MONEY");
		bookPerms.add("com.android.vending.BILLING");
		bookPerms.add("android.permission.ACCESS_NETWORK_STATE");
		bookPerms.add("android.permission.INTERNET");
		bookPerms.add("android.permission.ACCESS_WIFI_STATE");
		bookPerms.add("android.permission.GET_ACCOUNTS");
		bookPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		bookPerms.add("android.permission.WAKE_LOCK");
		
		gameSportsPerms.add("android.permission.INTERNET");
		gameSportsPerms.add("android.permission.GET_ACCOUNTS");
		
		musicPerms.add("android.permission-group.COST_MONEY");
		musicPerms.add("android.permission-group.AUDIO_SETTINGS");
		musicPerms.add("android.permission.MODIFY_AUDIO_SETTINGS");
		musicPerms.add("android.permission.ACCESS_NETWORK_STATE");
		musicPerms.add("com.android.vending.BILLING");
		musicPerms.add("android.permission.INTERNET");
		musicPerms.add("android.permission.ACCESS_WIFI_STATE");
		musicPerms.add("android.permission-group.MICROPHONE");
		musicPerms.add("android.permission.RECORD_AUDIO");
		
		toolsPerms.add("android.permission.READ_CALENDAR");
		toolsPerms.add("android.permission.WRITE_CALENDAR");
		toolsPerms.add("android.permission.READ_USER_DICTIONARY");
		toolsPerms.add("android.permission.WRITE_USER_DICTIONARY");
		toolsPerms.add("android.permission-group.LOCATION");
		toolsPerms.add("android.permission.ACCESS_FINE_LOCATION");
		toolsPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		toolsPerms.add("android.permission.ACCESS_WIFI_STATE");
		toolsPerms.add("android.permission.CHANGE_WIFI_STATE");
		toolsPerms.add("android.permission.ACCESS_NETWORK_STATE");
		toolsPerms.add("com.goog.android.apps.chrometophone.permission.C2D_MESSAGE");
		toolsPerms.add("android.permission.CHANGE_NETWORK_STATE");
		toolsPerms.add("android.permission.SCORE_NETWORKS");
		toolsPerms.add("android.permission.USE_CREDEMTIALS");
		toolsPerms.add("android.permission.ACCESS_GPS");
		toolsPerms.add("android.permission.BLUETOOTH");
		toolsPerms.add("android.permission.NFC");
		toolsPerms.add("android.permission.VIBRATE");
		toolsPerms.add("android.permission.FLASHLIGHT");
		toolsPerms.add("android.permission.WAKE_LOCK");
		toolsPerms.add("android.permission.TRANSMIT_IR");
		toolsPerms.add("android.permission.MANAGE_USB");
		toolsPerms.add("android.permission.NET_ADMIN");
		toolsPerms.add("android.permission-group.MICROPHONE");
		toolsPerms.add("android.permission.REMOTE_AUDIO_PLAYBACK");
		toolsPerms.add("android.permission.RECORD_AUDIO");
		toolsPerms.add("android.permission-group.CAMERA");
		toolsPerms.add("android.permission.CAMERA");
		toolsPerms.add("android.permission.INTERNET");
		toolsPerms.add("android.permission.CAMERA");
		toolsPerms.add("android.permission.RECEIVE_BOOT_COMPLETED");
		
		gamesPerms.add("com.android.vending.BILLING");
		gamesPerms.add("android.permission.VIBRATE");
		gamesPerms.add("android.permission.INTERNET");
		gamesPerms.add("android.permission.GET_ACCOUNTS");
		gamesPerms.add("android.permission.ACCESS_NETWORK_STATE");
		gamesPerms.add("android.permission.WAKE_LOCK");
		gamesPerms.add("android.permission.ACCESS_WIFI_STATE");
		
		commPerms.add("android.permission.SEND_SMS");
		commPerms.add("android.permission.SEND_RESPOND_VIA_MESSAGE");
		commPerms.add("android.permission.RECEIVE_SMS");
		commPerms.add("android.permission.RECEIVE_MMS");
		commPerms.add("android.permission.READ_USER_DICTIONARY");
		commPerms.add("android.permission.WRITE_USER_DICTIONARY");
		commPerms.add("android.permission.READ_SMS");
		commPerms.add("android.permission.WRITE_SMS");
		commPerms.add("android.permission-group.LOCATION");
		commPerms.add("android.permission.ACCESS_FINE_LOCATION");
		commPerms.add("android.permission.ACCESS_COARSE_LOCATION");
		commPerms.add("android.permission.ACCESS_NETWORK_STATE");
		commPerms.add("android.permission.VIBRATE");
		commPerms.add("android.permission-group.MICROPHONE");
		commPerms.add("android.permission.RECORD_AUDIO");
		commPerms.add("android.permission.CAMERA");
		commPerms.add("android.permission-group.PERSONAL_INFO");
		commPerms.add("android.permission-group.SOCIAL_INFO");
		commPerms.add("com.nokia.pushnotifications.permission.RECEIVE");
		commPerms.add("com.google.android.c2dm.permission.RECEIVE");
		commPerms.add("android.permission.RECEIVE_BOOT_COMPLETED");
		
		comicsPerms.add("com.android.vending.BILLING");
		comicsPerms.add("android.permission.INTERNET");
		comicsPerms.add("android.permission.ACCESS_NETWORK_STATE");
		comicsPerms.add("android.permission.READ_EXTERNAL_STORAGE");
		comicsPerms.add("android.permission-group.COST_MONEY");
		
		catPermissions.put("Games", gamesPerms);
		catPermissions.put("Games_Sports", gameSportsPerms);
		catPermissions.put("Books & Reference", bookPerms);
		catPermissions.put("Business", businessPerms);
		catPermissions.put("Comics", comicsPerms);
		catPermissions.put("Communication", commPerms);
		catPermissions.put("Education", educationPerms);
		catPermissions.put("Entertainment", entPerms);
		catPermissions.put("Finance", financePerms);
		catPermissions.put("Health & Fitness", healthPerms);
		catPermissions.put("Libraries & Demo", libPerms);
		catPermissions.put("Lifestyle", lifestylePerms);
    	catPermissions.put("Live Wallpaper", wallPerms);
    	catPermissions.put("Media & Video", mediaPerms);
    	catPermissions.put("Medical", medicalPerms);
    	catPermissions.put("Music & Audio", musicPerms);
    	catPermissions.put("News & Magazines", newsPerms);
    	catPermissions.put("Personalization", personalizationPerms);
    	catPermissions.put("Photography", photoPerms);
    	catPermissions.put("Productivity", prodPerms);
    	catPermissions.put("Shopping", shoppingPerms);
    	catPermissions.put("Social", socialPerms);
    	catPermissions.put("Sports", sportsPerms);
    	catPermissions.put("Tools", toolsPerms);
    	catPermissions.put("Transportation", transportPerms);
    	catPermissions.put("Travel & Local", travelPerms);
    	catPermissions.put("Weather", weatherPerms);
    	catPermissions.put("Widgets", widgetsPerms);
	}
	
	/*
	 * This method gathers the permissions listed within each individual application
	 * and stores it in an ArrayList for comparison later against the HashMap of permissions.
	 */
	
	public HashMap<String, String[]> getPermissionList(AppInfo app)
	{
		this.app = app;
		HashMap<String, String[]> category;
		String[] appPerms = app.getAppPermissions();
		String[] appPermGroups = app.getAppPermissionGroups();
		List<String> perms = new ArrayList<String>();
		
		try
		{
			for(int i=0; i<appPerms.length; i++)
				perms.add(appPerms[i]);
		}
		catch(NullPointerException e) {}
		
		try
		{
			for(int i=0; i<appPermGroups.length; i++)
				perms.add(appPermGroups[i]);
			
			category = checkPermissions(perms);
			
			if(category == null || category.isEmpty())
			{
				category = new HashMap<String, String[]>();
				category.put("Unknown", new String[0]);
			}
		}
		catch(NullPointerException e)
		{
			category = checkPermissions(perms);
			
			if(category == null || category.isEmpty())
			{
				category = new HashMap<String, String[]>();
				category.put("Unknown", new String[0]);
			}
		}
		return category;
	}
	
	/*
	 * This method compares every permission in the application's ArrayList against all
	 * the permissions in the HashMap and saves the scores of each category comparison.
	 */
	
	public HashMap<String, String[]> checkPermissions(List<String> appPerms)
	{
		int currentScore;
		List<String> currentList;
		
		for (Map.Entry<String, List<String>> pair : catPermissions.entrySet())
		{
    	   String key = pair.getKey();
    	   currentList = pair.getValue();
			currentScore = 0;
    	   
			for(int i=0; i<appPerms.size(); i++)
			{
				if(appPerms.get(i).equals("permission-group"))
				{
					for(int j=0; j<currentList.size(); j++)
					{
						try
						{						
							if(appPerms.get(i).equals(currentList.get(j)))
							{
								currentScore += 2;
								break;
							}
						}
						catch(NullPointerException e) {}
					}
				}
				else
				{
					for(int j=0; j<currentList.size(); j++)
					{
						if(appPerms.get(i).equals(currentList.get(j)))
						{
							currentScore += 3;
							break;
						}
					}
				}
			}
			catScores.put(key, currentScore);
    	}
		return getBestCategory();
	}
	
	/*
	 * This method reviews the scores made by the comparison for each category
	 * and evaluates what the best suited category for the application should be.
	 */
	
	public HashMap<String, String[]> getBestCategory()
	{
		int highestScore = 0;
		HashMap<String, String[]> bestCategory = new HashMap<String, String[]>();
		
		for (Map.Entry<String, Integer> entry : catScores.entrySet())
		{
		    String category = entry.getKey();
		    int value = entry.getValue();
		    
		    if(value > highestScore)
		    {
		    	highestScore = value;
		    	bestCategory.put(category, catPermissions.get(category).toArray(new String[catPermissions.get(category).size()]));
		    }
		}
		resetCatScores();
		return bestCategory;
	}
	
	public void resetCatScores()
	{
		catScores.put("Games", 0);
    	catScores.put("Books & Reference", 0);
    	catScores.put("Business", 0);
    	catScores.put("Comics", 0);
    	catScores.put("Communication", 0);
    	catScores.put("Education", 0);
    	catScores.put("Entertainment", 0);
    	catScores.put("Finance", 0);
    	catScores.put("Health & Fitness", 0);
    	catScores.put("Libraries & Demo", 0);
    	catScores.put("Lifestyle", 0);
    	catScores.put("Live Wallpaper", 0);
    	catScores.put("Media & Video", 0);
    	catScores.put("Medical", 0);
    	catScores.put("Music & Audio", 0);
    	catScores.put("News & Magazines", 0);
    	catScores.put("Personalization", 0);
    	catScores.put("Photography", 0);
    	catScores.put("Productivity", 0);
    	catScores.put("Shopping", 0);
    	catScores.put("Social", 0);
    	catScores.put("Sports", 0);
    	catScores.put("Tools", 0);
    	catScores.put("Transportation", 0);
    	catScores.put("Travel & Local", 0);
    	catScores.put("Weather", 0);
    	catScores.put("Widgets", 0);
	}
}