package com.example.mvvm.mvvmexample.common.utils;

import android.support.annotation.Nullable;

/**
 * @author KangSungWoo
 */
public class StringUtils {

	public static boolean isEmpty(@Nullable String str) {
		return (str == null || str.isEmpty());
	}

	public static boolean isNotEmpty(@Nullable String str) {
		return !isEmpty(str);
	}

}
