package com.example.mvvm.mvvmexample.common.di.module.providers;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnimRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.animation.Animation;

/**
 * @author KangSungWoo
 * @since 2017-03-06
 */
public interface ResourceProvider {

	@NonNull
	Resources getResources();

	@NonNull
	String getString(@StringRes int strResId);

	@NonNull
	String getString(@StringRes int strResId, Object... args);

	int getColor(@ColorRes int colorResId);

	ColorStateList getColorStateList(@ColorRes int colorResId);

	float getDimenSizeDP(@DimenRes int dimenSizeResId);

	float getDimenSizePX(@DimenRes int dimenSizeResId);

	@NonNull
	Drawable getDrawable(@DrawableRes int drawableResId);

	@NonNull
	Animation getAnimation(@AnimRes int animResId);

}
