package com.example.mvvm.mvvmexample.ui.login;

import android.support.annotation.Nullable;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.mvvm.ViewModel;
import com.example.mvvm.mvvmexample.common.base.mvvm.VmActivity;
import com.example.mvvm.mvvmexample.common.di.component.ActivityComponent;

/**
 * @author KangSungWoo
 * @since 2017-03-04
 */
public class LoginActivity extends VmActivity {
	@Nullable
	@Override
	public ViewModel getViewModel() {
		return null;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.login_activity;
	}

	@Override
	protected void onInject(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}

}
