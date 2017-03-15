package com.example.mvvm.mvvmexample.ui.common.navdrawer;

import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.mvvm.ViewModel;
import com.example.mvvm.mvvmexample.common.base.mvvm.VmFragment;
import com.example.mvvm.mvvmexample.common.di.component.ActivityComponent;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-15
 */
public class NavDrawerMainFragment extends VmFragment {

	@Inject NavDrawerMainFragmentVM navDrawerMainFragmentVM;

	@NonNull
	@Override
	protected ViewModel createViewModel() {
		return navDrawerMainFragmentVM;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.navdrawer_main_frag;
	}

	@Override
	protected void onInject(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}
}
