package com.example.mvvm.mvvmexample.common.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.mvvm.mvvmexample.common.di.module.helpers.NavigationHelper;
import com.example.mvvm.mvvmexample.common.di.module.helpers.NavigationHelperImpl;
import com.example.mvvm.mvvmexample.common.di.scope.PerActivity;
import com.example.mvvm.mvvmexample.ui.login.LoginNavigationHelper;

import dagger.Module;
import dagger.Provides;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@Module
public class ActivityModule {

	private final Activity activity;

	public ActivityModule(@NonNull Activity activity) {
		this.activity = activity;
	}

	@Provides
	@PerActivity
	@NonNull
	Context provideContext() {
		return activity;
	}

	@Provides
	@PerActivity
	@NonNull
	Activity provideActivity() {
		return activity;
	}

	@Provides
	@PerActivity
	@NonNull
	NavigationHelper provideNavigationHelper() {
		return new NavigationHelperImpl(activity);
	}

	@Provides
	@PerActivity
	@NonNull
	LoginNavigationHelper provideLoginNavigationHelper(@NonNull FragmentManager fm) {
		return new LoginNavigationHelper(fm);
	}

}
