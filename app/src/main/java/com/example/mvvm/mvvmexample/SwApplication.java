package com.example.mvvm.mvvmexample;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.mvvm.mvvmexample.common.di.component.ApplicationComponent;
import com.example.mvvm.mvvmexample.common.di.component.DaggerApplicationComponent;
import com.example.mvvm.mvvmexample.common.di.module.ApplicationModule;

/**
 * @author KangSungWoo
 * @since 2017-02-27
 */
public class SwApplication extends MultiDexApplication {

	private static ApplicationComponent applicationComponent;
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();

		context = getApplicationContext();
		applicationComponent = DaggerApplicationComponent.builder()
			.applicationModule(new ApplicationModule(this)).build();
	}

	public static Context getAppContext() {
		return context;
	}

}
