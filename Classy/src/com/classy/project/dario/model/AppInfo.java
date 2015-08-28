package com.classy.project.dario.model;

import android.graphics.drawable.Drawable;

public class AppInfo
{
	private final String appName, packageName, version, installed, lastModified;
	private final Drawable appIcon;
	private final String[] appPermissions, appFeatures, appPermissionGroups;
	private String[] catPermissions;
	
	public AppInfo(String appName, String packageName, String version, 
			String installed, String lastModified, Drawable drawable, String[] appPermissions, 
			String[] appFeatures, String[] appPermissionGroups)
	{
		this.appName = appName;
		this.packageName = packageName;
		this.version = version;
		this.installed = installed;
		this.lastModified = lastModified;
		this.appIcon = drawable;
		this.appPermissions = appPermissions;
		this.appFeatures = appFeatures;
		this.appPermissionGroups = appPermissionGroups;
	}

	public String getAppName() {return appName;}

	public String getPackageName() {return packageName;}
	
	public String getVersion() {return version;}

	public String getInstalled() {return installed;}

	public String getLastModified() {return lastModified;}

	public Drawable getAppIcon() {return appIcon;}

	public String[] getAppPermissions() {return appPermissions;}

	public String[] getAppFeatures() {return appFeatures;}

	public String[] getAppPermissionGroups() {return appPermissionGroups;}
	
	public String[] getCatPermissions() {return catPermissions;}
	
	public void setCatPermissions(String[] catPermissions) {this.catPermissions = catPermissions;}
}