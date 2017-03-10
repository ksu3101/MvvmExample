package com.example.mvvm.mvvmexample.common.databinding;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.mvvm.mvvmexample.common.databinding.listeners.OnClickedListener;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnReceived;

import rx.functions.Action1;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
public final class BindingAdapters {

	@BindingConversion
	public static View.OnClickListener onClickToAction(@NonNull OnClickedListener listener) {
		return v -> listener.onClickedView();
	}

	@BindingAdapter("android:visibility")
	public static void setVisibility(@NonNull View view, boolean visibility) {
		view.setVisibility((visibility ? View.VISIBLE : View.GONE));
	}

	@BindingAdapter("onTextChanged")
	public static void setTextChanged(@NonNull EditText et, @NonNull OnReceived<String> onTextChangedListner) {
		et.addTextChangedListener(
			new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				}

				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
				}

				@Override
				public void afterTextChanged(Editable s) {
					onTextChangedListner.onReceived(s.toString());
				}
			}
		);
	}

}
