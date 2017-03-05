package com.example.mvvm.mvvmexample.ui.login;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.utils.ActivityUtils;
import com.example.mvvm.mvvmexample.ui.login.Login.LogInFragment;
import com.example.mvvm.mvvmexample.ui.login.signup.SignUpFragment;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */

public class LoginNavigationHelper {

	private FragmentManager fm;

	public LoginNavigationHelper(@NonNull FragmentManager fm) {
		this.fm = fm;
	}

	public boolean hasBackStack() {
		if (fm != null) {
			return (fm.getBackStackEntryCount() > 0);
		}
		return false;
	}

	public void popBackStack() {
		if (hasBackStack()) {
			fm.popBackStack();
		}
	}

	public void showSignInFragment() {
		ActivityUtils.replaceFragmentFromActivity(
			fm,
			LogInFragment.newInstance(),
			R.id.login_fragment_container,
			true,
			R.anim.enter_from_right,
			R.anim.exit_to_left,
			R.anim.enter_from_left,
			R.anim.exit_to_right
		);
	}

	public void showSignUpFragment() {
		ActivityUtils.replaceFragmentFromActivity(
			fm,
			SignUpFragment.newInstance(),
			R.id.login_fragment_container,
			true,
			R.anim.enter_from_right,
			R.anim.exit_to_left,
			R.anim.enter_from_left,
			R.anim.exit_to_right
		);
	}

}
