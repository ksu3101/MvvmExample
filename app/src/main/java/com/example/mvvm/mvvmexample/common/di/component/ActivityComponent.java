package com.example.mvvm.mvvmexample.common.di.component;

import com.example.mvvm.mvvmexample.ui.MainActivity;
import com.example.mvvm.mvvmexample.common.di.module.ActivityModule;
import com.example.mvvm.mvvmexample.common.di.scope.PerActivity;
import com.example.mvvm.mvvmexample.ui.login.LoginActivity;
import com.example.mvvm.mvvmexample.ui.login.signin.SignInFragment;
import com.example.mvvm.mvvmexample.ui.login.signup.SignUpFragment;

import dagger.Component;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class })
public interface ActivityComponent {

	void inject(LoginActivity activity);
	void inject(SignInFragment fragment);
	void inject(SignUpFragment fragment);

}
