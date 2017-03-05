package com.example.mvvm.mvvmexample.common.di.module.providers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnimRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * @author KangSungWoo
 * @since 2017-03-06
 */

public class ResourceProviderImpl implements ResourceProvider {

	@NonNull Context context;

	public ResourceProviderImpl(@NonNull Context context) {
		this.context = context;
	}

	@NonNull
	@Override
	public Resources getResources() {
		return context.getResources();
	}

	@NonNull
	@Override
	public String getString(@StringRes int strResId) {
		return context.getString(strResId);
	}

	@NonNull
	@Override
	public String getString(@StringRes int strResId, Object... args) {
		return context.getString(strResId, args);
	}

	@Override
	public int getColor(@ColorRes int colorResId) {
		return ContextCompat.getColor(context, colorResId);
	}

	@Override
	public ColorStateList getColorStateList(@ColorRes int colorResId) {
		return ContextCompat.getColorStateList(context, colorResId);
	}

	@Override
	public float getDimenSizeDP(@DimenRes int dimenSizeResId) {
		return getResources().getDimension(dimenSizeResId);
	}

	@Override
	public float getDimenSizePX(@DimenRes int dimenSizeResId) {
		return getResources().getDimensionPixelSize(dimenSizeResId);
	}

	@NonNull
	@Override
	public Drawable getDrawable(@DrawableRes int drawableResId) {
		return ContextCompat.getDrawable(context, drawableResId);
	}

	@NonNull
	@Override
	public Animation getAnimation(@AnimRes int animResId) {
		return AnimationUtils.loadAnimation(context, animResId);
	}
}
