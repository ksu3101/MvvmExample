package com.example.mvvm.mvvmexample.common.di.module.providers;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public class NavigationProviderImpl implements NavigationProvider {

	private Context context;

	public NavigationProviderImpl(@NonNull Context context) {
		this.context = context;
	}

	@Override
	public void finish() {
		if (context instanceof Activity) {
			((Activity) context).finish();
		}
	}

	@Override
	public void startMainActivity() {

	}
}
