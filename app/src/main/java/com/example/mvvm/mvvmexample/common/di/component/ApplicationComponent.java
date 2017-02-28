package com.example.mvvm.mvvmexample.common.di.component;

import com.example.mvvm.mvvmexample.common.di.module.ApplicationModule;

import dagger.Component;

import javax.inject.Singleton;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {
}
