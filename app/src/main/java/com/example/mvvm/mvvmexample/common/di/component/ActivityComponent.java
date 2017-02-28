package com.example.mvvm.mvvmexample.common.di.component;

import com.example.mvvm.mvvmexample.MainActivity;
import com.example.mvvm.mvvmexample.common.di.module.ActivityModule;
import com.example.mvvm.mvvmexample.common.di.scope.PerActivity;

import dagger.Component;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class })
public interface ActivityComponent {

	void inject(MainActivity activity);

}
