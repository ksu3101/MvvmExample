package com.example.mvvm.mvvmexample.common.utils;

import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public final class ActivityUtils {

	/**
	 * Fragment 를 add 한다
	 *
	 * @param fm FragmentManager instance
	 * @param addFragment 추가할 Fragment 의 instance
	 * @param addFragmentId 추가 될 Fragment 의 container layout id
	 */
	public static void addFragmentToActivity(
		@NonNull FragmentManager fm, @NonNull Fragment addFragment, @IdRes int addFragmentId) {
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.add(addFragmentId, addFragment);
		transaction.commit();
	}

	/**
	 * Fragment 를 add 한다
	 *
	 * @param fm FragmentManager instance
	 * @param addFragment 추가할 Fragment 의 instance
	 * @param addFragmentId 추가 될 Fragment 의 container layout id
	 * @param enterAnimResId Fragment 의 등장 transition animation
	 * @param exitAnimResId Fragment 의 종료 transition animation
	 */
	public static void addFragmentToActivity(
		@NonNull FragmentManager fm,
		@NonNull Fragment addFragment,
		@IdRes int addFragmentId,
		@AnimRes int enterAnimResId,
		@AnimRes int exitAnimResId) {
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.setCustomAnimations(enterAnimResId, exitAnimResId);
		transaction.add(addFragmentId, addFragment);
		transaction.commit();
	}

	/**
	 * Fragment 를 replace 한다.
	 *
	 * @param fm FragmentManager instance
	 * @param replaceFragment 교체 할 Fragment 의 instance
	 * @param replaceFragmentId 교체 할 Fragment 의 container layout id
	 */
	public static void replaceFragmentFromActivity(
		@NonNull FragmentManager fm, @NonNull Fragment replaceFragment, @IdRes int replaceFragmentId) {
		replaceFragmentFromActivity(fm, replaceFragment, replaceFragmentId, true);
	}

	/**
	 * Fragment 를 replace 한다.
	 *
	 * @param fm FragmentManager instance
	 * @param replaceFragment 교체 할 Fragment 의 instance
	 * @param replaceFragmentId 교체 할 Fragment 의 container layout id
	 * @param isAddToBackStack replace 전 fragment 를 back stack 에 저장할 지에 대한 여부
	 */
	public static void replaceFragmentFromActivity(
		@NonNull FragmentManager fm, @NonNull Fragment replaceFragment, @IdRes int replaceFragmentId, boolean isAddToBackStack) {
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(replaceFragmentId, replaceFragment);
		if (isAddToBackStack) {
			transaction.addToBackStack(null);
		}
		transaction.commit();
	}

	/**
	 * Fragment 를 replace 한다.
	 *
	 * @param fm FragmentManager instance
	 * @param replaceFragment 교체 할 Fragment 의 instance
	 * @param replaceFragmentId 교체 할 Fragment 의 container layout id
	 * @param isAddToBackStack replace 전 fragment 를 back stack 에 저장할 지에 대한 여부
	 * @param enterAnimResId Fragment 의 등장 transition animation
	 * @param exitAnimResId Fragment 의 종료 transition animation
	 */
	public static void replaceFragmentFromActivity(
		@NonNull FragmentManager fm,
		@NonNull Fragment replaceFragment,
		@IdRes int replaceFragmentId,
		boolean isAddToBackStack,
		@AnimRes int enterAnimResId,
		@AnimRes int exitAnimResId,
		@AnimRes int popEnterAnimResId,
		@AnimRes int popExitAnimResId) {
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.setCustomAnimations(enterAnimResId, exitAnimResId, popEnterAnimResId, popExitAnimResId);
		transaction.replace(replaceFragmentId, replaceFragment);
		if (isAddToBackStack) {
			transaction.addToBackStack(null);
		}
		transaction.commit();
	}

	/**
	 * DialogFragment 를 show 한다
	 *
	 * @param fm FragmentManager Instance
	 * @param dialogFragment Dialog Fragment
	 * @param fragmentTag Fragment tag string
	 * @param isAddToBackStack fragment 를 back stack 에 저장할 지에 대한 여부
	 */
	public static void showDialogFragment(
		@NonNull FragmentManager fm,
		@NonNull DialogFragment dialogFragment,
		@NonNull String fragmentTag,
		boolean isAddToBackStack) {
		FragmentTransaction ft = fm.beginTransaction();

		// DialogFragment 의 show() 는 FragmentTransaction 에 Fragment를 추가 한다.
		// 하지만 기존에 보여지고 있거나 존재 하는 Fragment가 있을 경우 그 Fragment를 제거remove()
		// 하고 새로운 Fragment를 보여 준다.
		Fragment prev = fm.findFragmentByTag(fragmentTag);
		if (prev != null) {
			ft.remove(prev);
		}
		if (isAddToBackStack) {
			ft.addToBackStack(null);
		}

		// Create and show the dialog.
		dialogFragment.show(fm, fragmentTag);

		ft.commit();
	}

	/**
	 * DialogFragment를 dismiss한다
	 *
	 * @param fm FragmentManager instance
	 * @param fragmentTag DialogFragment string tag
	 */
	public static void dismissDialogFragment(
		@NonNull FragmentManager fm,
		@NonNull String fragmentTag
	) {
		Fragment prev = fm.findFragmentByTag(fragmentTag);
		if (prev instanceof DialogFragment) {
			DialogFragment dialogFragment = (DialogFragment) prev;
			dialogFragment.getDialog().dismiss();
		}
	}
}
