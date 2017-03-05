package com.example.mvvm.mvvmexample.common.di.module.providers;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * @author KangSungWoo
 * @since 2017-03-06
 */
public interface MessageProvider {

	void showToast(@NonNull String message);

	void showToast(@StringRes int messageResId);

}
