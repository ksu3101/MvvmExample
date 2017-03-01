package com.example.mvvm.mvvmexample.common.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * @author KangSungWoo
 * @since 2017-02-27
 */
public class BaseActivity extends AppCompatActivity {

	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
	}

	@Override
	public void onBackPressed() {
		if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
			getSupportFragmentManager().popBackStack();
			return;
		}
		super.onBackPressed();
	}
}
