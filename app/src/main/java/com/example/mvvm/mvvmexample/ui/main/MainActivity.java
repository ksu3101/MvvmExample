package com.example.mvvm.mvvmexample.ui.main;

import android.support.annotation.Nullable;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.mvvm.ViewModel;
import com.example.mvvm.mvvmexample.common.base.mvvm.VmActivity;
import com.example.mvvm.mvvmexample.common.di.component.ActivityComponent;
import com.example.mvvm.mvvmexample.ui.MainActivityVM;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public class MainActivity extends VmActivity {

	@Inject MainActivityVM mainActivityVM;

	@Nullable
	@Override
	public ViewModel getViewModel() {
		return mainActivityVM;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.main_activity;
	}

	@Override
	protected void onInject(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}
}
