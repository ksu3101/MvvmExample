package com.example.mvvm.mvvmexample.ui.login.Login;

import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.mvvm.ViewModel;
import com.example.mvvm.mvvmexample.common.base.mvvm.VmFragment;
import com.example.mvvm.mvvmexample.common.di.component.ActivityComponent;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-04
 */
public class LogInFragment extends VmFragment {

	@Inject LogInFragmentVM logInFragmentVM;

	public static LogInFragment newInstance() {
		return new LogInFragment();
	}

	@NonNull
	@Override
	protected ViewModel createViewModel() {
		return logInFragmentVM;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.login_login_fragment;
	}

	@Override
	protected void onInject(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}
}
