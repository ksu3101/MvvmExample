package com.example.mvvm.mvvmexample.common.databinding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
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
		if (view.getContext() instanceof VmActivity) {
			if (((VmActivity) view.getContext()).getViewModel() instanceof RxViewModel) {
				RxViewModel rxViewModel = (RxViewModel) ((VmActivity) view.getContext()).getViewModel();
				if (rxViewModel == null) {
					Log.e(TAG, "// RxViewModel is Null.. check `setOnClickEventHandler()` methods. ");
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
		}
	}

}
