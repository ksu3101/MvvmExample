package com.example.mvvm.mvvmexample.common.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author KangSung-Woo
 * @since 2017-02-27
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
