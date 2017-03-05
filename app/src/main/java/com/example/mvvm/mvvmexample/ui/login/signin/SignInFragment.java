package com.example.mvvm.mvvmexample.ui.login.signin;

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
public class SignInFragment extends VmFragment {

	@Inject SignInFragmentVM signInFragmentVM;

	public static SignInFragment newInstance() {
		return new SignInFragment();
	}

	@NonNull
	@Override
	protected ViewModel createViewModel() {
		return signInFragmentVM;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.login_signin_fragment;
	}

	@Override
	protected void onInject(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}
}
