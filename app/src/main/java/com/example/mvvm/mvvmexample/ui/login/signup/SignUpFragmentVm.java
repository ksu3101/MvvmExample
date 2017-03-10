package com.example.mvvm.mvvmexample.ui.login.signup;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.text.TextUtilsCompat;
import android.text.TextUtils;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnClickedListener;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnReceived;
import com.example.mvvm.mvvmexample.common.di.module.providers.MessageProvider;
import com.example.mvvm.mvvmexample.domain.auth.AuthService;
import com.example.mvvm.mvvmexample.domain.auth.vo.SignUpUserInfoVO;
import com.example.mvvm.mvvmexample.domain.auth.vo.UserInfoVO;
import com.example.mvvm.mvvmexample.ui.login.LoginNavigationProvider;

import rx.Subscriber;

import java.util.Observable;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-04
 */
public class SignUpFragmentVm extends RxViewModel {

	public ObservableField<String> userEmail = new ObservableField<>();
	public ObservableField<String> userPassword = new ObservableField<>();
	public ObservableField<String> userRePassword = new ObservableField<>();

	@NonNull private final LoginNavigationProvider navigationProvider;
	@NonNull private final AuthService authService;
	@NonNull private final MessageProvider messageProvider;

	@Inject
	public SignUpFragmentVm(
		@NonNull LoginNavigationProvider navigationProvider,
		@NonNull AuthService authService,
		@NonNull MessageProvider messageProvider) {
		this.navigationProvider = navigationProvider;
		this.authService = authService;
		this.messageProvider = messageProvider;
	}

	public OnClickedListener onClickSignUpButton = () -> signUp();

	public OnClickedListener onClickedCancle = new OnClickedListener() {
		@Override
		public void onClickedView() {
			navigationProvider.popBackStack();
		}
	};

	public OnReceived<String> onUserEmailTextChanged = receivedObj -> userEmail.set(receivedObj);

	public OnReceived<String> onPasswordTextChanged = receivedObj -> userPassword.set(receivedObj);

	public OnReceived<String> onRePasswordTextChanged = receivedObj -> userRePassword.set(receivedObj);

	private void signUp() {
		if (TextUtils.isEmpty(userEmail.get())) {
			messageProvider.showToast(R.string.signup_warn_empty_email);
			return;
		} else if (TextUtils.isEmpty(userPassword.get()) || TextUtils.isEmpty(userRePassword.get())) {
			messageProvider.showToast(R.string.signup_warn_empty_pw_re);
			return;
		}

		addSubscriber(
			authService.signUp(new SignUpUserInfoVO(userEmail.get(), userPassword.get()))
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
