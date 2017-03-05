package com.example.mvvm.mvvmexample.common.databinding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.base.mvvm.VmActivity;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public final class RxViewAdapters {
	private static final String TAG = RxViewAdapters.class.getSimpleName();

	@BindingAdapter("rxOnClick")
	public static void setOnClickEventHandler(@NonNull View view, @NonNull Action0 listener) {
		RxViewModel rxViewModel = getRxViewModel(view);
		if (rxViewModel == null) {
			Log.e(TAG, "// RxViewModel is Null.. check `getRxViewModel()` methods. ");
			return;
		}

		Observable<Void> observable = Observable.create(
			new Observable.OnSubscribe<Void>() {
				@Override
				public void call(Subscriber<? super Void> subscriber) {
					view.setOnClickListener(view1 -> subscriber.onNext(null));
				}
			}
		).throttleFirst(1500, TimeUnit.MILLISECONDS)
			.subscribeOn(Schedulers.newThread())
			.observeOn(AndroidSchedulers.mainThread());

		rxViewModel.addSubscriber(
			observable.subscribe(
				aVoid -> {
					listener.call();
				}
			)
		);
	}

	@Nullable
	private static RxViewModel getRxViewModel(@NonNull View view) {
		if (view.getContext() instanceof VmActivity) {
			if (((VmActivity) view.getContext()).getViewModel() instanceof RxViewModel) {
				return (RxViewModel) ((VmActivity) view.getContext()).getViewModel();
			}
		}
		return null;
	}

}
