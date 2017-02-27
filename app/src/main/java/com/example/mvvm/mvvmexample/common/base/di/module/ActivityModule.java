package com.example.mvvm.mvvmexample.common.base.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.common.base.di.scope.PerActivity;

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

}
