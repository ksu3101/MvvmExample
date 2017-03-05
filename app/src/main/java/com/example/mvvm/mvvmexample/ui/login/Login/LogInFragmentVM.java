package com.example.mvvm.mvvmexample.ui.login.Login;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.di.module.providers.MessageProvider;
import com.example.mvvm.mvvmexample.domain.auth.AuthService;
import com.example.mvvm.mvvmexample.domain.auth.vo.UserInfoVO;
import com.example.mvvm.mvvmexample.ui.login.LoginNavigationProvider;

import rx.Subscriber;
import rx.functions.Action0;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-04
 */
public class LogInFragmentVM extends RxViewModel {

	public ObservableField<String> userEmail;
	public ObservableField<String> userPassWord;

	@NonNull AuthService authService;
	@NonNull LoginNavigationProvider loginNavigationProvider;
	@NonNull MessageProvider messageProvider;

	@Inject
	public LogInFragmentVM(
		@NonNull AuthService authService,
		@NonNull LoginNavigationProvider loginNavigationProvider,
		@NonNull MessageProvider messageProvider
	) {
		this.loginNavigationProvider = loginNavigationProvider;
		this.authService = authService;
		this.messageProvider = messageProvider;
	}

	public Action0 onClickBackButton = new Action0() {
		@Override
		public void call() {
			loginNavigationProvider.popBackStack();
		}
	};

	public Action0 OnClickLoginButton = new Action0() {
		@Override
		public void call() {
			login();
		}
	};

	private void login() {
		if (TextUtils.isEmpty(userEmail.get())) {
			messageProvider.showToast("이메일을 입력해 주세요.");
			return;
		} else if (TextUtils.isEmpty(userPassWord.get())) {
			messageProvider.showToast("비밀번호를 입력해 주세요.");
			return;
		}

		addSubscriber(
			authService.login(userEmail.get(), userPassWord.get())
				.subscribe(
					new Subscriber<UserInfoVO>() {
						@Override
						public void onCompleted() {

						}

						@Override
						public void onError(Throwable e) {

						}

						@Override
						public void onNext(UserInfoVO userInfoVO) {

						}
					}
				)
		);
	}

}
