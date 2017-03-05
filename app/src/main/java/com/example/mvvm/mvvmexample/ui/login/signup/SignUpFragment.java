package com.example.mvvm.mvvmexample.ui.login.signup;

import android.os.Bundle;
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
public class SignUpFragment extends VmFragment {

	@Inject SignUpFragmentVm signUpFragmentVm;

	public static SignUpFragment newInstance() {
		return new SignUpFragment();
	}

	@NonNull
	@Override
	protected ViewModel createViewModel() {
		return signUpFragmentVm;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.login_signup_fragment;
	}

	@Override
	protected void onInject(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}
}
