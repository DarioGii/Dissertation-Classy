package com.classy.project.dario.viewcontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.classy.project.dario.R;
import com.classy.project.dario.model.AppDataWrapper;
import com.classy.project.dario.model.AppInfo;
import com.classy.project.dario.model.MarketLookup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Spannable;
import android.view.MenuItem;
import android.widget.TextView;
 
public class AppView extends Activity {
 
    private TextView packageName, classyCat, marketCat, version, features, permissions, installed, lastModified;
    private String classyCategory, marketCategory;
    private String[] catPermissions;
    private List<String> badCats;
    private boolean equal;
    private AppInfo appInfo;
    private MarketLookup lookup;
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_info);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	StrictMode.setThreadPolicy(policy);
        AppDataWrapper appData = (AppDataWrapper) getApplicationContext();
        
        badCats = new ArrayList<String>();
        lookup = new MarketLookup();
        appInfo = appData.getAppInfo();
        classyCategory = appData.getCategory();
        marketCategory = lookup.lookup(appInfo.getPackageName());

        equal = (classyCategory.equals(marketCategory) || classyCategory == marketCategory) ? true : false;
        
        findViewsById();
        getActionBar().setTitle(appInfo.getAppName());
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setIcon(appInfo.getAppIcon());
        setValues();
        checkCount();
    }
    
	private void findViewsById()
    {
        packageName = (TextView) findViewById(R.id.package_name);
        classyCat = (TextView) findViewById(R.id.classy_category);
        marketCat = (TextView) findViewById(R.id.market_category);
        
        try
        {
	        if(equal)
	        {
	        	classyCat.setBackgroundColor(Color.parseColor("#86DA5E"));
	        	marketCat.setBackgroundColor(Color.parseColor("#86DA5E"));
	        }
	        else
	        {
	        	classyCat.setBackgroundColor(Color.parseColor("#49C8C8"));
	        	marketCat.setBackgroundColor(Color.parseColor("#F24967"));
	        }
        }
        catch(NullPointerException e) {}
        
        version = (TextView) findViewById(R.id.version_name);
        features = (TextView) findViewById(R.id.req_feature);
        permissions = (TextView) findViewById(R.id.req_permission);
        installed = (TextView) findViewById(R.id.insdate);
        lastModified = (TextView) findViewById(R.id.last_modify);
    }
 
	private void setValues()
    {
        packageName.setText(appInfo.getPackageName());
        classyCat.setText(classyCategory);
        marketCat.setText(marketCategory);
        version.setText(appInfo.getVersion());
        installed.setText(appInfo.getInstalled());
        lastModified.setText(appInfo.getLastModified());
        
        String[] perms = appInfo.getAppPermissions();
        String[] feats = appInfo.getAppFeatures();
        catPermissions = appInfo.getCatPermissions();
        
        try
        {
	        if(feats.length != 0)
	        	setFeatures(feats);
	        else
	        	features.setText("None");
        }
        catch(NullPointerException e) {features.setText("None");}
        
        try
        {
	        if(perms.length != 0)
	        	setPermissions(perms);
	        else
	        	permissions.setText("None");
        }
        catch(NullPointerException e) {permissions.setText("None");}
    }
	
	public void checkCount()
	{
		if(badCats.size() >= 15)
		{
			String cats = printBadCats();
			displayMessage(cats);
		}
	}
	
	public String printBadCats()
	{
		String cats = "";
		
		for(String cat : badCats)
			cats += cat+ ", ";
		
		cats.trim();
		return cats.substring(0, cats.length());
	}
 
    @SuppressLint("SimpleDateFormat")
    private String setDateFormat(long time)
    {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDate = formatter.format(date);
        return strDate;
    }
    
    public void setPermissions(String[] perms)
    {
    	boolean flag;
    	
    	for(String perm : perms)
    	{
    		flag = true;
    		System.out.println(perms);
    		for(int i=0; i<catPermissions.length; i++)
    		{
	    		if(!(perm.equals(catPermissions[i])))
	    		{}
	    		else
	    		{
	    			flag = false;
	    			break;
	    		}
    		}
    		
    		if(flag)
    		{
    			permissions.setBackgroundColor(Color.parseColor("#F24967"));
    			badCats.add(perm);
    		}
    		else
    			permissions.setBackgroundColor(Color.parseColor("#86DA5E"));
    		permissions.append(perm+ "\n");
    	}
    }
    
    public void setFeatures(String[] feats)
    {
    	for(String feat : feats)
    		features.append(feat+ "\n");
    }
 
    @Override
	public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
	        case android.R.id.home:
	            Intent intent = new Intent(this, MainView.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
    	}
	}
    
    public void displayMessage(String cats)
    {
    	new AlertDialog.Builder(this)
        .setTitle("WARNING")
        .setMessage("This application contains permissions that are not common in this category: \n"+cats)
        .setCancelable(false)
        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) { 
            	dialog.cancel();
            }
         }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }
}