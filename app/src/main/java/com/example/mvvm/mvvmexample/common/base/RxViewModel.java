package com.example.mvvm.mvvmexample.common.base;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mvvm.mvvmexample.common.base.mvvm.ViewModel;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author KangSung-Woo
 * @since 2017-02-28
 */
public class RxViewModel implements ViewModel {
	private static final String TAG = RxViewModel.class.getSimpleName();

	private CompositeSubscription compositeSubscription;

	public RxViewModel() {
		this.compositeSubscription = new CompositeSubscription();
	}

	@NonNull
	public final Subscription addSubscriber(@NonNull final Subscription subscriber) {
		if (compositeSubscription != null) {
			compositeSubscription.add(subscriber);
		}
		return subscriber;
	}

	@CallSuper
	public void unSubscribe() {
		if (compositeSubscription != null) {
			compositeSubscription.unsubscribe();
			Log.d(TAG, "// unSubscribe()");
		}
	}

}
