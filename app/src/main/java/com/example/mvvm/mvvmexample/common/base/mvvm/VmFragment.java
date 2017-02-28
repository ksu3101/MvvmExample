package com.example.mvvm.mvvmexample.common.base.mvvm;

import android.databinding.ViewDataBinding;

import com.example.mvvm.mvvmexample.common.base.BaseFragment;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;

/**
 * @author KangSungWoo
 * @since 2017-02-28
 */
public abstract class VmFragment extends BaseFragment {
	protected ViewModel viewModel;
	private ViewDataBinding viewDataBinding;

	@Override
	public void onDestroy() {
		if (viewModel instanceof RxViewModel) {
			((RxViewModel) viewModel).unSubscribe();
		}
		super.onDestroy();
	}

	protected abstract ViewModel createViewModel();
}
