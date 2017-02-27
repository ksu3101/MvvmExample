package com.example.mvvm.mvvmexample.common.base.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Since;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@Module
public class ApplicationModule {

	private final Application application;

	public ApplicationModule(@NonNull Application app) {
		this.application = app;
	}

	@Provides
	@Singleton
	public Context provideApplicationContext() {
		return this.application;
	}

}
