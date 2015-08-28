package com.classy.project.dario.model;

import android.app.Application;

public class AppDataWrapper extends Application {

	private AppInfo appInfo;
	private String category;

	public AppDataWrapper() {super();}

	public AppInfo getAppInfo() {return appInfo;}

	public void setAppInfo(AppInfo appInfo) {this.appInfo = appInfo;}
	
	public String getCategory() {return category;}
	
	public void setCategory(String category) {this.category = category;}
}