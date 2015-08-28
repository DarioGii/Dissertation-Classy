package com.classy.project.dario.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;

public class CollectionSerialiser
{
	public static final String HASH_PREFS = "MAP";
	public static final String STRING_PREFS = "STRING";
	public static final String LIST_PREFS = "LIST";
	public static final String HASH_NAME = "CAT_COLLECTION";
	public static final String STRING = "APP_CATS";
	public static final String CAT_LIST = "CAT_KEYS";
	private Context context;
	
	public CollectionSerialiser(Context context)
	{
		super();
		this.context = context;
	}
	
	public void savePairs(Context context, HashMap<String, String> appCats)
	{
		SharedPreferences settings;
		Editor editor;
		JSONObject jsonObject;
		String jsonPair;
		
		settings = context.getSharedPreferences(STRING_PREFS, Context.MODE_PRIVATE);
		jsonObject = new JSONObject(appCats);
		jsonPair = jsonObject.toString();
		editor = settings.edit();
		editor.remove(STRING).commit();
		editor.putString(STRING, jsonPair);
		editor.commit();
	}
	
	public HashMap<String, String> loadPairs(Context context)
	{
		SharedPreferences settings;
		JSONObject jsonObject;
		String jsonPairs;
		HashMap<String, String> appCats = new HashMap<String, String>();
		settings = context.getSharedPreferences(STRING_PREFS, Context.MODE_PRIVATE);
		
		if (settings.contains(STRING))
        {
        	try
        	{
        		jsonPairs = settings.getString(STRING, null);
	            jsonObject = new JSONObject(jsonPairs);
	            
	            Iterator<String> itr = jsonObject.keys();
	            
	            while(itr.hasNext())
	            {
	            	String key = itr.next();
	            	appCats.put(key, jsonObject.getString(key));
	            }
        	}
        	catch(JSONException e)
        	{
        		Log.e("Error", "No HashMap<String, String> in CollectionSerializers");
        		return null;
        	}
        }
		return appCats;
	}
	
	@TargetApi(Build.VERSION_CODES.KITKAT)
	public void saveMap(Context context, HashMap<String, List<AppInfo>> catCollection)
	{
		SharedPreferences settings;
		Editor editor;
		AppInfo temp;
		JSONArray jArray;
		JSONObject obj;
		JSONObject jsonMap = new JSONObject();
		
		settings = context.getSharedPreferences(HASH_PREFS, Context.MODE_PRIVATE);
		
		for(String key : catCollection.keySet())
		{
			jArray = new JSONArray();

			try
			{
				for (int i=0; i<catCollection.values().size(); i++)
				{
					temp = catCollection.get(key).get(i);
					obj = new JSONObject();
					
					try
					{
						JSONArray perms;
						JSONArray features;
						JSONArray permGroups;
						
						try {perms = new JSONArray(temp.getAppPermissions());}
						catch(NullPointerException e) {perms = new JSONArray();}
						
						try {features = new JSONArray(temp.getAppFeatures());}
						catch(NullPointerException e) {features = new JSONArray();}
						
						try {permGroups = new JSONArray(temp.getAppPermissionGroups());}
						catch(NullPointerException e) {permGroups = new JSONArray();}
						
						obj.put("appName", temp.getAppName());
						obj.put("packageName", temp.getPackageName());
						obj.put("version", temp.getVersion());
						obj.put("installed", temp.getInstalled());
						obj.put("lastModified", temp.getLastModified());
						obj.put("appPermissions", perms);
						obj.put("appFeatures", features);
						obj.put("appPermissionGroups", permGroups);
						
						jArray.put(obj);
					} 
					catch (JSONException e)
					{e.printStackTrace();}
				}
			}
			catch(IndexOutOfBoundsException e) {}
			try {jsonMap.put(key, jArray);}
			catch (JSONException e) {e.printStackTrace();}
		}
		
		String jsonCollection = jsonMap.toString();
		editor = settings.edit();
		editor.remove(HASH_NAME).commit();
		editor.putString(HASH_NAME, jsonCollection);
		editor.commit();
	}
	
	public HashMap<String, List<AppInfo>> loadMap(Context context)
	{
		SharedPreferences settings;
		HashMap<String, List<AppInfo>> catCollection = new HashMap<String, List<AppInfo>>();
		settings = context.getSharedPreferences(HASH_PREFS, Context.MODE_PRIVATE);
		
		try
		{
			if(settings.contains(HASH_NAME))
			{
				String jsonCollection = settings.getString(HASH_NAME, (new JSONObject()).toString());
				JSONObject jsonObject = new JSONObject(jsonCollection);
				System.out.println(jsonCollection);
				JSONObject obj;
				AppInfo appInfo;
				List<AppInfo> list;
				Iterator<String> keysItr = jsonObject.keys();
				
				while(keysItr.hasNext())
				{
					list = new ArrayList<AppInfo>();
					String key = keysItr.next();
					
					JSONArray jsonArray = (JSONArray) jsonObject.get(key);
					JSONArray perms;
					JSONArray feats;
					JSONArray permGroups;
					
					try
					{
						for(int i=0; i<jsonArray.length(); i++)
						{
							obj = jsonArray.getJSONObject(i);
							String appName = obj.getString("appName");
							String packageName = obj.getString("packageName");
							String version = obj.getString("version");
							String installed = obj.getString("installed");
							String lastModified = obj.getString("lastModified");
							
							// To convert String into Drawable
							Drawable appIcon = context.getPackageManager().getApplicationIcon(packageName); //Resource not found exception
							
							perms = (JSONArray) obj.get("appPermissions");
							feats = (JSONArray) obj.get("appFeatures");
							permGroups = (JSONArray) obj.get("appPermissionGroups");
							
							String[] appPermissions;
							String[] appFeatures;
							String[] appPermissionGroups;
							
							try
							{
								appPermissions = new String[perms.length()];
								
								for(int j=0; j<perms.length(); j++)
								{
									appPermissions[j] = perms.get(j).toString();
									System.out.println(appPermissions[j]);
								}
							}
							catch(JSONException e) {appPermissions = null;}
							
							try
							{
								appFeatures = new String[feats.length()];
								
								for(int j=0; j<perms.length(); j++)
									appFeatures[j] = feats.get(j).toString();
							}
							catch(JSONException e) {appFeatures = null;}
							
							try
							{
								appPermissionGroups = new String[permGroups.length()];
								
								for(int j=0; j<perms.length(); j++)
									appPermissionGroups[j] = permGroups.get(j).toString();
							}
							catch(JSONException e) {appPermissionGroups = null;}
							
							
							appInfo = new AppInfo(appName, packageName, version, installed, lastModified,
									appIcon, appPermissions, appFeatures, appPermissionGroups);
							list.add(appInfo);
						}
					}
					catch(IndexOutOfBoundsException e) {Log.e("IndexOutOfBoundsException", "Putting empty list in map");}
					catch(JSONException e) {Log.e("JSONException", "Putting empty list in map");}
					catch(NameNotFoundException e) {Log.e("NameNotFoundException","Drawable not found");}
					catCollection.put(key, list);
				}
			}
			else
				return null;
		}
		catch(JSONException e)
		{
			Log.e("Error", "Could not load HashMap from CollectionSerializers");
			return null;
		}
		return catCollection;
	}
	
	public void saveList(Context context, List<String> list)
	{
		SharedPreferences settings;
		Editor editor;
		JSONArray jsonList;
		String jsonCatList;
		
		settings = context.getSharedPreferences(LIST_PREFS, Context.MODE_PRIVATE);
		editor = settings.edit();
		jsonList = new JSONArray(list);
		jsonCatList = jsonList.toString();
		
		editor.remove(CAT_LIST).commit();
		editor.putString(CAT_LIST, jsonCatList);
		editor.commit();
	}
	
	public List<String> loadList(Context context)
	{
		SharedPreferences settings;
        List<String> catList = new ArrayList<String>();
 
        settings = context.getSharedPreferences(LIST_PREFS, Context.MODE_PRIVATE);
 
        if (settings.contains(CAT_LIST))
        {
        	try
        	{
        		String value;
	            String jsonCatList = settings.getString(CAT_LIST, null);
	            JSONArray jsonList = new JSONArray(jsonCatList);
	
	            for(int i=0; i<jsonList.length(); i++)
	            {
	            	value = (String) jsonList.get(i);
	            	catList.add(value);
	            }
        	}
        	catch(JSONException e)
        	{
        		Log.e("Error", "No List in CollectionSerializers");
        		return new ArrayList<String>();
        	}
        } 
        else
            return new ArrayList<String>();
        return catList;
	}
}