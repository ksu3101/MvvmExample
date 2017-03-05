package com.example.mvvm.mvvmexample.common.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * @author KangSungWoo
 * @since 2017-03-06
 */
public class RxUtils {

	public static <T> Observable.Transformer<T, T> applyDefaultSchedulers() {
		return tObservable -> tObservable.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread());
	}

	// TODO : attach full screen progress dialog (and replace lambda)
	public static <T> Observable.Transformer<T, T> applyBlockedCallSchedulers() {
		return tObservable -> tObservable.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.doOnSubscribe(
				new Action0() {
					@Override
					public void call() {
						// TODO : show progress dialog
					}
				}
			)
			.doOnUnsubscribe(
				new Action0() {
					@Override
					public void call() {
						// TODO : dismiss progress dialog
					}
				}
			);
	}

}
