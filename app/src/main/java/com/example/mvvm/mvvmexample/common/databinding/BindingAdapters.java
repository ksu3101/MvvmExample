package com.example.mvvm.mvvmexample.common.databinding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
public final class BindingAdapters {

	@BindingAdapter("android:visibility")
	public static void setVisibility(@NonNull View view, boolean visibility) {
		view.setVisibility((visibility ? View.VISIBLE : View.GONE));
	}

}
