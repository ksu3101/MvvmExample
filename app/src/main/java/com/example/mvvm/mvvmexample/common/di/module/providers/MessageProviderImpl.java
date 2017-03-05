package com.example.mvvm.mvvmexample.common.di.module.providers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-06
 */
public class MessageProviderImpl implements MessageProvider {

	private Context context;

	@Inject
	public MessageProviderImpl(@NonNull Context context) {
		this.context = context;
	}

	@Override
	public void showToast(@NonNull String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showToast(@StringRes int messageResId) {
		Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show();
	}
}
