package com.example.mvvm.mvvmexample.common.di.component;

import com.example.mvvm.mvvmexample.common.di.module.ActivityModule;
import com.example.mvvm.mvvmexample.common.di.scope.PerActivity;
import com.example.mvvm.mvvmexample.ui.login.Login.LogInFragment;
import com.example.mvvm.mvvmexample.ui.login.LoginActivity;
import com.example.mvvm.mvvmexample.ui.login.signup.SignUpFragment;
import com.example.mvvm.mvvmexample.ui.main.MainActivity;

import dagger.Component;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class })
public interface ActivityComponent {

	void inject(LoginActivity activity);
	void inject(LogInFragment fragment);
	void inject(SignUpFragment fragment);

	void inject(MainActivity activity);

}
