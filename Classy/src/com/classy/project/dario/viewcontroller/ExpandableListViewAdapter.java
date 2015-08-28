package com.classy.project.dario.viewcontroller;

import java.util.HashMap;
import java.util.List;
import com.classy.project.dario.R;
import com.classy.project.dario.model.AppInfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

	private Activity context;
	private HashMap<String, List<AppInfo>> categoriesAndApps;
	private List<String> categoryKeys;
	
	public ExpandableListViewAdapter(Activity context, List<String> categoryKeys, 
			HashMap<String, List<AppInfo>> categoriesAndApps)
	{
		this.context = context;
		this.categoriesAndApps  = categoriesAndApps;
		this.categoryKeys = categoryKeys;
	}

	@Override
	public int getGroupCount() {return categoryKeys.size();}

	@Override
	public int getChildrenCount(int groupPosition)
	{return categoriesAndApps.get(categoryKeys.get(groupPosition)).size();}

	@Override
	public Object getGroup(int groupPosition) {return categoryKeys.get(groupPosition);}

	@Override
	public Object getChild(int groupPosition, int childPosition)
	{return categoriesAndApps.get(categoryKeys.get(groupPosition)).get(childPosition);}

	@Override
	public long getGroupId(int groupPosition) {return groupPosition;}

	@Override
	public long getChildId(int groupPosition, int childPosition) {return childPosition;}

	@Override
	public boolean hasStableIds() {return true;}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {String categoryName = (String) getGroup(groupPosition);
        
		if (convertView == null)
		{
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.parent, null);
        }
		
		if(groupPosition == 0)
			convertView.setBackgroundColor(Color.parseColor("#BDCFDC"));
		else if(groupPosition == 1)
			convertView.setBackgroundColor(Color.parseColor("#FFF1C0"));
		else if(groupPosition == 2)
			convertView.setBackgroundColor(Color.parseColor("#C18EC9"));
		else if(groupPosition == 3)
			convertView.setBackgroundColor(Color.parseColor("#A4A1DB"));
		else if(groupPosition == 4)
			convertView.setBackgroundColor(Color.parseColor("#A4E8A1"));
		else if(groupPosition == 5)
			convertView.setBackgroundColor(Color.parseColor("#EBFAAE"));
		else if(groupPosition == 6)
			convertView.setBackgroundColor(Color.parseColor("#FFF0B1"));
		else if(groupPosition == 7)
			convertView.setBackgroundColor(Color.parseColor("#FFDEB1"));
		else if(groupPosition == 8)
			convertView.setBackgroundColor(Color.parseColor("#FEDFC8"));
		else if(groupPosition == 9)
			convertView.setBackgroundColor(Color.parseColor("#B2A5F8"));
		else if(groupPosition == 10)
			convertView.setBackgroundColor(Color.parseColor("#BDCFDC"));
		else if(groupPosition == 11)
			convertView.setBackgroundColor(Color.parseColor("#FFF1C0"));
		else if(groupPosition == 12)
			convertView.setBackgroundColor(Color.parseColor("#C18EC9"));
		else if(groupPosition == 13)
			convertView.setBackgroundColor(Color.parseColor("#A4A1DB"));
		else if(groupPosition == 14)
			convertView.setBackgroundColor(Color.parseColor("#A4E8A1"));
		else if(groupPosition == 15)
			convertView.setBackgroundColor(Color.parseColor("#EBFAAE"));
		else if(groupPosition == 16)
			convertView.setBackgroundColor(Color.parseColor("#FFF0B1"));
		else if(groupPosition == 17)
			convertView.setBackgroundColor(Color.parseColor("#FFDEB1"));
		else if(groupPosition == 18)
			convertView.setBackgroundColor(Color.parseColor("#FEDFC8"));
		else if(groupPosition == 19)
			convertView.setBackgroundColor(Color.parseColor("#B2A5F8"));
		else if(groupPosition == 20)
			convertView.setBackgroundColor(Color.parseColor("#BDCFDC"));
		else if(groupPosition == 21)
			convertView.setBackgroundColor(Color.parseColor("#FFF1C0"));
		else if(groupPosition == 22)
			convertView.setBackgroundColor(Color.parseColor("#C18EC9"));
		else if(groupPosition == 23)
			convertView.setBackgroundColor(Color.parseColor("#A4A1DB"));
		else if(groupPosition == 24)
			convertView.setBackgroundColor(Color.parseColor("#A4E8A1"));
		else if(groupPosition == 25)
			convertView.setBackgroundColor(Color.parseColor("#EBFAAE"));
		else if(groupPosition == 26)
			convertView.setBackgroundColor(Color.parseColor("#FFF0B1"));
		else
			convertView.setBackgroundColor(Color.parseColor("#FEDFC8"));
		
        TextView catName = (TextView) convertView.findViewById(R.id.category_title);
        catName.setText(categoryName);
        return convertView;
	}

	@Override
	@SuppressLint("NewApi") public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		
		AppInfo appInfo = (AppInfo) getChild(groupPosition, childPosition);
		final String APPNAME = appInfo.getAppName();
        Drawable applicationIcon;

        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child, null);
        }
        
		TextView applicationName = (TextView) convertView.findViewById(R.id.application);
        ImageView appIcon = new ImageView(context);
        appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
        
    	applicationIcon =  appInfo.getAppIcon();
    	appIcon.setImageDrawable(applicationIcon);
        applicationName.setText(APPNAME);
        
        return convertView;
	}
	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {return true;}
}