package com.example.mvvm.mvvmexample.ui.login.Login;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnClickedListener;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnReceived;
import com.example.mvvm.mvvmexample.common.di.module.providers.MessageProvider;
import com.example.mvvm.mvvmexample.domain.auth.AuthService;
import com.example.mvvm.mvvmexample.domain.auth.vo.UserInfoVO;
import com.example.mvvm.mvvmexample.ui.login.LoginNavigationProvider;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

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

	/**
	 * 로그인 버튼
	 */
	public OnClickedListener onClickLoginButton = () -> login();

	/**
	 * 회원 가입 버튼
	 */
	public OnClickedListener onClickSignUpButton = new OnClickedListener() {
		@Override
		public void onClickedView() {
			loginNavigationProvider.showSignUpFragment();
		}
	};

	public OnReceived<String> onUserEmonUserEmailTextChanged = new OnReceived<String>() {
		@Override
		public void onReceived(String s) {
			userEmail.set(s);
		}
	};

	public OnReceived<String> onPasswordTextChanged = new OnReceived<String>() {
		@Override
		public void onReceived(String s) {
			userPassWord.set(s);
		}
	};

	private void login() {
		if (TextUtils.isEmpty(userEmail.get())) {
			messageProvider.showToast(R.string.login_warn_empty_email);
			return;
		} else if (TextUtils.isEmpty(userPassWord.get())) {
			messageProvider.showToast(R.string.login_warn_empty_pw);
			return;
		}

		addSubscriber(authService.login(userEmail.get(), userPassWord.get())
			.subscribe(
				new Subscriber<UserInfoVO>() {
					@Override
					public void onCompleted() {
					}

					@Override
					public void onError(Throwable e) {
						messageProvider.showToast(R.string.login_error_wrong_infos);
					}

					@Override
					public void onNext(UserInfoVO userInfoVO) {

					}
				}
			)
		);
	}

}
