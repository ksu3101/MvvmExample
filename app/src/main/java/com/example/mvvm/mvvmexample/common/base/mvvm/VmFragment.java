package com.example.mvvm.mvvmexample.common.base.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.example.mvvm.mvvmexample.SwApplication;
import com.example.mvvm.mvvmexample.common.base.BaseFragment;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.di.component.ActivityComponent;
import com.example.mvvm.mvvmexample.common.di.component.DaggerActivityComponent;
import com.example.mvvm.mvvmexample.common.di.module.ActivityModule;

/**
 * @author KangSungWoo
 * @since 2017-02-28
 */
public abstract class VmFragment extends BaseFragment {
	private ViewDataBinding dataBinding;
	protected ViewModel viewModel;
	protected ActivityComponent activityComponent;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (getActivity() instanceof VmActivity) {
			activityComponent = ((VmActivity) getActivity()).getActivityComponent();
		} else {
			activityComponent = DaggerActivityComponent.builder()
				.applicationComponent(SwApplication.getApplicationComponent())
				.activityModule(new ActivityModule(getActivity()))
				.build();
		}
		onInject(activityComponent);

		viewModel = createViewModel();
		dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
		dataBinding.setVariable(BR.vm, viewModel);
		return dataBinding.getRoot();
	}

	@Override
	public void onDestroy() {
		if (viewModel instanceof RxViewModel) {
			((RxViewModel) viewModel).unSubscribe();
		}
		super.onDestroy();
	}

	@NonNull
	protected abstract ViewModel createViewModel();

	@LayoutRes
	protected abstract int getLayoutId();

	protected abstract void onInject(ActivityComponent activityComponent);
}
