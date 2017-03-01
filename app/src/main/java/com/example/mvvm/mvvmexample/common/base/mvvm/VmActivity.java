package com.example.mvvm.mvvmexample.common.base.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.android.databinding.library.baseAdapters.BR;
import com.example.mvvm.mvvmexample.SwApplication;
import com.example.mvvm.mvvmexample.common.base.BaseActivity;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.di.component.ActivityComponent;
import com.example.mvvm.mvvmexample.common.di.component.DaggerActivityComponent;
import com.example.mvvm.mvvmexample.common.di.module.ActivityModule;

/**
 * @author KangSungWoo
 * @since 2017-02-28
 */
public abstract class VmActivity extends BaseActivity {
	private ViewDataBinding dataBinding;
	protected ViewModel viewModel;
	protected ActivityComponent activityComponent;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityComponent = DaggerActivityComponent.builder()
			.applicationComponent(SwApplication.getApplicationComponent())
			.activityModule(new ActivityModule(this))
			.build();

		onInject(activityComponent);

		viewModel = createViewModel();
		dataBinding = DataBindingUtil.setContentView(this, getLayoutId());

		if(viewModel != null) {
			dataBinding.setVariable(BR.vm, dataBinding);
		}
	}

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

	protected abstract void onInject(ActivityComponent activityComponent);

}
