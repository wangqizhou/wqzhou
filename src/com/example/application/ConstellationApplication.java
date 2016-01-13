package com.example.application;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class ConstellationApplication extends Application {
   
	private static ConstellationApplication instance;
	private List<Activity> mActivityList = new LinkedList<Activity>();
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}
	
	public static ConstellationApplication getInstance() {
		return instance;
	}
	
	 public void addActivity(Activity activity) {
	        mActivityList.add(activity);
	    }

	    public void exit() {
	        for (Activity activity : mActivityList) {
	            activity.finish();
	        }
	        System.exit(0);
	    }
	
	
	
}
