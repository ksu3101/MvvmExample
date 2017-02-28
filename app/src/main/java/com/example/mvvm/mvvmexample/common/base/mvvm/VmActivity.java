package com.example.mvvm.mvvmexample.common.base.mvvm;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.example.mvvm.mvvmexample.common.base.BaseActivity;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;

/**
 * @author KangSungWoo
 * @since 2017-02-28
 */
public abstract class VmActivity extends BaseActivity {
	private ViewDataBinding viewDataBinding;
	protected ViewModel viewModel;

	@Override
	protected void onDestroy() {
		if (viewModel instanceof RxViewModel) {
			((RxViewModel) viewModel).unSubscribe();
		}
		super.onDestroy();
	}

	@Nullable
	protected abstract ViewModel createViewModel();

	@LayoutRes
	protected abstract int getLayoutId();

}
