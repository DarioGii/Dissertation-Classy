package com.classy.project.dario.viewcontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.classy.project.dario.R;
import com.classy.project.dario.model.AppDataWrapper;
import com.classy.project.dario.model.AppInfo;
import com.classy.project.dario.model.CollectionSerialiser;
import com.classy.project.dario.model.PermissionCategories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;


public class MainView extends Activity {
	
	private PackageManager packageManager;
	private HashMap<String, List<AppInfo>> categoryCollection;
	private HashMap<String, String> appCats;
	List<AppInfo> appList;
	private List<AppInfo> gamesPackages, booksAndRefPackages, businessPackages, comicsPackages, commPackages, educationPackages,
	entertainmentPackages, financePackages, healthAndFitnessPackages, libAndDemoPackages, lifestylePackages, liveWallPackages, mediaAndVideoPackages,
	medicalPackages, musicAndAudioPackages, newsAndMagsPackages, personalizationPackages, photoPackages, prodPackages, shoppingPackages, socialPackages,
	sportsPackages, toolsPackages, transportationPackages, travelAndLocalPackages, weatherPackages, widgetsPackages, unknownPackages;
	private List<String> categoryKeys;
	private PermissionCategories permGroups;
	private ExpandableListView expList;
	private ExpandableListViewAdapter viewAdapter;
	private CollectionSerialiser serializer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        serializer = new CollectionSerialiser(this);
        packageManager = getPackageManager();
        permGroups = new PermissionCategories();
        categoryKeys = new ArrayList<String>();
        appCats = new HashMap<String, String>();
		categoryCollection = new HashMap<String, List<AppInfo>>();
		
		new BackgroundTask(this, false).execute();
    }
    
    public void setView()
    {
    	expList = (ExpandableListView) findViewById(R.id.exp_list);
        viewAdapter = new ExpandableListViewAdapter(this, categoryKeys, categoryCollection);
        expList.setAdapter(viewAdapter);
        
        expList.setOnChildClickListener(new OnChildClickListener()
        {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
			{
				AppInfo app = (AppInfo) parent.getExpandableListAdapter().getChild(groupPosition, childPosition);
			    AppDataWrapper appData = new AppDataWrapper();			    
			    
			    appData = (AppDataWrapper) getApplicationContext();
			    appData.setAppInfo(app);
			    appData.setCategory(appCats.get(app.getAppName()));
			
			    Intent appInfo = new Intent(appData, AppView.class);
			    startActivity(appInfo);
				return true;
			}
        });
    }
    
    public void updateCollection() {new BackgroundTask(this, true).execute();}
    
    private void createCategoryKeys()
    {
    	categoryKeys.add("Games");
    	categoryKeys.add("Books & Reference");
    	categoryKeys.add("Business");
    	categoryKeys.add("Comics");
    	categoryKeys.add("Communication");
    	categoryKeys.add("Education");
    	categoryKeys.add("Entertainment");
    	categoryKeys.add("Finance");
    	categoryKeys.add("Health & Fitness");
    	categoryKeys.add("Libraries & Demo");
    	categoryKeys.add("Lifestyle");
    	categoryKeys.add("Live Wallpaper");
    	categoryKeys.add("Media & Video");
    	categoryKeys.add("Medical");
    	categoryKeys.add("Music & Audio");
    	categoryKeys.add("News & Magazines");
    	categoryKeys.add("Personalization");
    	categoryKeys.add("Photography");
    	categoryKeys.add("Productivity");
    	categoryKeys.add("Shopping");
    	categoryKeys.add("Social");
    	categoryKeys.add("Sports");
    	categoryKeys.add("Tools");
    	categoryKeys.add("Transportation");
    	categoryKeys.add("Travel & Local");
    	categoryKeys.add("Weather");
    	categoryKeys.add("Widgets");
    	categoryKeys.add("Unknown");
    }
    
    private void getPackages()
    {
    	PackageInfo packInfo;
    	AppInfo app;
    	String[] appPermissionGroups, appFeatures;
        appList = new ArrayList<AppInfo>();
        List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS | PackageManager.GET_PROVIDERS);
        
        for(int i=0; i<packageList.size(); i++)
        {
        	packInfo = packageList.get(i);
            boolean b = isSystemPackage(packInfo);
            if(!b)
            {
            	try
            	{
            		appFeatures = new String[packInfo.reqFeatures.length];
            		appPermissionGroups = new String[packInfo.permissions.length];
            		
            		for(int j=0; j<packInfo.reqFeatures.length; j++)
                		appFeatures[j] = packInfo.reqFeatures[j].name;
            		
            		for(int k=0; k<packInfo.permissions.length; k++)
                		appPermissionGroups[k] = packInfo.permissions[k].group;
            	}
            	catch(NullPointerException e)
            	{
            		appFeatures = null;
            		appPermissionGroups = null;
            	}
            	
            	app = new AppInfo(packInfo.applicationInfo.loadLabel(packageManager).toString(), packInfo.applicationInfo.packageName, 
            			packInfo.versionName, setDateFormat(packInfo.firstInstallTime), setDateFormat(packInfo.lastUpdateTime), 
            			packInfo.applicationInfo.loadIcon(packageManager), packInfo.requestedPermissions, appFeatures, appPermissionGroups);
            	appList.add(app);
            }
        }
    }
    
    public void sortCategories()
    {
    	HashMap<String, String[]> catPerm;
    	String category = "";
    	gamesPackages = new ArrayList<AppInfo>();
		booksAndRefPackages = new ArrayList<AppInfo>();
		businessPackages = new ArrayList<AppInfo>();
		comicsPackages = new ArrayList<AppInfo>();
		commPackages = new ArrayList<AppInfo>();
		educationPackages = new ArrayList<AppInfo>();
		entertainmentPackages = new ArrayList<AppInfo>();
		financePackages = new ArrayList<AppInfo>();
		healthAndFitnessPackages = new ArrayList<AppInfo>();
		libAndDemoPackages = new ArrayList<AppInfo>();
		lifestylePackages = new ArrayList<AppInfo>();
		liveWallPackages = new ArrayList<AppInfo>();
		mediaAndVideoPackages = new ArrayList<AppInfo>();
		medicalPackages = new ArrayList<AppInfo>();
		musicAndAudioPackages = new ArrayList<AppInfo>();
		newsAndMagsPackages = new ArrayList<AppInfo>();
		personalizationPackages = new ArrayList<AppInfo>();
		photoPackages = new ArrayList<AppInfo>();
		prodPackages = new ArrayList<AppInfo>();
		shoppingPackages = new ArrayList<AppInfo>();
		socialPackages = new ArrayList<AppInfo>();
		sportsPackages = new ArrayList<AppInfo>();
		toolsPackages = new ArrayList<AppInfo>();
		transportationPackages = new ArrayList<AppInfo>();
		travelAndLocalPackages = new ArrayList<AppInfo>();
		weatherPackages = new ArrayList<AppInfo>();
		widgetsPackages = new ArrayList<AppInfo>();
		unknownPackages = new ArrayList<AppInfo>();
    	
    	for(int i=0; i<appList.size(); i++)
        {
    		catPerm = permGroups.getPermissionList(appList.get(i));
    		
    		for (String key : catPerm.keySet())
    		{
    			category = key;
    			break;
    		}
    		
    		// The collection here maps applications to the decided category
    		if(category.equals("Games_Sports"))
    			appCats.put(appList.get(i).getAppName(), "Games");
    		else
    			appCats.put(appList.get(i).getAppName(), category);
    		
    		switch (category)
        	{
        		case "Action":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Adventure":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Board":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Card":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Casino":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Casual":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Educational":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Family":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Music":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Puzzle":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Racing":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Role Playing":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Simulation":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Games_Sports":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Strategy":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Trivia":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Word":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Games":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			gamesPackages.add(appList.get(i));
        			break;
        		case "Books & Reference":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			booksAndRefPackages.add(appList.get(i));
        			break;
        		case "Business":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			businessPackages.add(appList.get(i));
        			break;
        		case "Comics":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			comicsPackages.add(appList.get(i));
        			break;
        		case "Communication":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			commPackages.add(appList.get(i));
        			break;
        		case "Education":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			educationPackages.add(appList.get(i));
        			break;
        		case "Entertainment":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			entertainmentPackages.add(appList.get(i));
        			break;
        		case "Finance":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			financePackages.add(appList.get(i));
        			break;
        		case "Health & Fitness":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			healthAndFitnessPackages.add(appList.get(i));
        			break;
        		case "Libraries & Demo":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			libAndDemoPackages.add(appList.get(i));
        			break;
        		case "Lifestyle":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			lifestylePackages.add(appList.get(i));
        			break;
        		case "Live Wallpaper":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			liveWallPackages.add(appList.get(i));
        			break;
        		case "Media & Video":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			mediaAndVideoPackages.add(appList.get(i));
        			break;
        		case "Medical":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			medicalPackages.add(appList.get(i));
        			break;
        		case "Music & Audio":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			musicAndAudioPackages.add(appList.get(i));
        			break;
        		case "News & Magazines":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			newsAndMagsPackages.add(appList.get(i));
        			break;
        		case "Personalization":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			personalizationPackages.add(appList.get(i));
        			break;
        		case "Photography":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			photoPackages.add(appList.get(i));
        			break;
        		case "Productivity":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			prodPackages.add(appList.get(i));
        			break;
        		case "Shopping":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			shoppingPackages.add(appList.get(i));
        			break;
        		case "Social":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			socialPackages.add(appList.get(i));
        			break;
        		case "Sports":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			sportsPackages.add(appList.get(i));
        			break;
        		case "Tools":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			toolsPackages.add(appList.get(i));
        			break;
        		case "Transportation":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			transportationPackages.add(appList.get(i));
        			break;
        		case "Travel & Local":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			travelAndLocalPackages.add(appList.get(i));
        			break;
        		case "Weather":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			weatherPackages.add(appList.get(i));
        			break;
        		case "Widgets":
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			widgetsPackages.add(appList.get(i));
        			break;
        		default:
        			appList.get(i).setCatPermissions(catPerm.get(category));
        			unknownPackages.add(appList.get(i));
        			break;
			}
        }
    	categoryCollection.put(categoryKeys.get(0), gamesPackages);
		categoryCollection.put(categoryKeys.get(1), booksAndRefPackages);
		categoryCollection.put(categoryKeys.get(2), businessPackages);
		categoryCollection.put(categoryKeys.get(3), comicsPackages);
		categoryCollection.put(categoryKeys.get(4), commPackages);
		categoryCollection.put(categoryKeys.get(5), educationPackages);
		categoryCollection.put(categoryKeys.get(6), entertainmentPackages);
		categoryCollection.put(categoryKeys.get(7), financePackages);
		categoryCollection.put(categoryKeys.get(8), healthAndFitnessPackages);
		categoryCollection.put(categoryKeys.get(9), libAndDemoPackages);
		categoryCollection.put(categoryKeys.get(10), lifestylePackages);
		categoryCollection.put(categoryKeys.get(11), liveWallPackages);
		categoryCollection.put(categoryKeys.get(12), mediaAndVideoPackages);
		categoryCollection.put(categoryKeys.get(13), medicalPackages);
		categoryCollection.put(categoryKeys.get(14), musicAndAudioPackages);
		categoryCollection.put(categoryKeys.get(15), newsAndMagsPackages);
		categoryCollection.put(categoryKeys.get(16), personalizationPackages);
		categoryCollection.put(categoryKeys.get(17), photoPackages);
		categoryCollection.put(categoryKeys.get(18), prodPackages);
		categoryCollection.put(categoryKeys.get(19), shoppingPackages);
		categoryCollection.put(categoryKeys.get(20), socialPackages);
		categoryCollection.put(categoryKeys.get(21), sportsPackages);
		categoryCollection.put(categoryKeys.get(22), toolsPackages);
		categoryCollection.put(categoryKeys.get(23), transportationPackages);
		categoryCollection.put(categoryKeys.get(24), travelAndLocalPackages);
		categoryCollection.put(categoryKeys.get(25), weatherPackages);
		categoryCollection.put(categoryKeys.get(26), widgetsPackages);
		categoryCollection.put(categoryKeys.get(27), unknownPackages);
    }
    
    @SuppressLint("SimpleDateFormat")
    private String setDateFormat(long time)
    {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDate = formatter.format(date);
        return strDate;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo)
    {
    	boolean systemApp = false;
    	
    	if((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0)
    	{
    		if(!(pkgInfo.applicationInfo.sourceDir.startsWith("data/app")))
    			systemApp = true;
    	}
		return systemApp;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.update) 
        {
        	updateCollection();
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private class BackgroundTask extends AsyncTask<Void, Void, Void>
    {
		private Context context;
		private ProgressDialog progress;
		private boolean update;
		
		public BackgroundTask(Context context, boolean update)
		{
			this.context = context;
			this.update = update;
		}
		
        @Override
		protected Void doInBackground(Void... params) 
        {
        	if(!update)
        	{
	        	try
	    		{
	    			if((categoryKeys = serializer.loadList(context)).isEmpty())
	    				createCategoryKeys();
	    		}
	    		catch(NullPointerException e) {createCategoryKeys();}
	    		
	    		try
	    		{
	    			if((categoryCollection = serializer.loadMap(context)).isEmpty() || (appCats = serializer.loadPairs(context)).isEmpty())
	    			{
	    				getPackages();
		    	        sortCategories();
		    	        serializer.savePairs(context, appCats);
		    	        serializer.saveList(context, categoryKeys);
		    	        serializer.saveMap(context, categoryCollection);
	    			}
	    		}
	    		catch(NullPointerException e)
	    		{
	    			getPackages();
	    	        sortCategories();
	    	        serializer.savePairs(context, appCats);
	    	        serializer.saveList(context, categoryKeys);
	    	        serializer.saveMap(context, categoryCollection);
	    		}
        	}
	    	else
	    	{
	    		getPackages();
		        sortCategories();
		        serializer.savePairs(context, appCats);
		        serializer.saveList(context, categoryKeys);
		        serializer.saveMap(context, categoryCollection);
	    	}
            return null;
        }

        @Override
		protected void onPostExecute(Void result)
        {
        	super.onPostExecute(result);
        	setView();
        	progress.dismiss();
        }

        @Override
		protected void onPreExecute()
        {
            super.onPreExecute();
        	progress = new ProgressDialog(context);
        	progress.setMessage("Loading, please wait...");
        	progress.setCancelable(false);
        	progress.setCanceledOnTouchOutside(false);
        	progress.show();
        }
    }
}