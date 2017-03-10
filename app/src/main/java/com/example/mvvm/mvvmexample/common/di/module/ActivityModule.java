package com.example.mvvm.mvvmexample.common.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.mvvm.mvvmexample.common.di.module.providers.MessageProvider;
import com.example.mvvm.mvvmexample.common.di.module.providers.MessageProviderImpl;
import com.example.mvvm.mvvmexample.common.di.module.providers.NavigationProvider;
import com.example.mvvm.mvvmexample.common.di.module.providers.NavigationProviderImpl;
import com.example.mvvm.mvvmexample.common.di.module.providers.ResourceProvider;
import com.example.mvvm.mvvmexample.common.di.module.providers.ResourceProviderImpl;
import com.example.mvvm.mvvmexample.common.di.scope.PerActivity;
import com.example.mvvm.mvvmexample.ui.login.LoginNavigationProvider;

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
	FragmentManager provideFragmentManager(@NonNull Activity activity) {
		return ((FragmentActivity) activity).getSupportFragmentManager();
	}

	@Provides
	@PerActivity
	@NonNull
	NavigationProvider provideNavigationHelper(@NonNull Activity activity) {
		return new NavigationProviderImpl(activity);
	}

	@Provides
	@PerActivity
	@NonNull
	ResourceProvider provideResourceHelper(@NonNull Activity activity) {
		return new ResourceProviderImpl(activity);
	}

	@Provides
	@PerActivity
	@NonNull
	MessageProvider provideMessageHelper(@NonNull Activity activity) {
		return new MessageProviderImpl(activity);
	}

	@Provides
	@PerActivity
	@NonNull
	LoginNavigationProvider provideLoginNavigationHelper(@NonNull FragmentManager fm) {
		return new LoginNavigationProvider(fm);
	}

}
