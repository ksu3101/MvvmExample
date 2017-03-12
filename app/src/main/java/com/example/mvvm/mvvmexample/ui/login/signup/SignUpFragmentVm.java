package com.example.mvvm.mvvmexample.ui.login.signup;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.R;
import com.example.mvvm.mvvmexample.common.base.RxViewModel;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnClickedListener;
import com.example.mvvm.mvvmexample.common.databinding.listeners.OnReceived;
import com.example.mvvm.mvvmexample.common.di.module.providers.MessageProvider;
import com.example.mvvm.mvvmexample.common.di.module.providers.NavigationProvider;
import com.example.mvvm.mvvmexample.common.utils.StringUtils;
import com.example.mvvm.mvvmexample.domain.auth.AuthService;
import com.example.mvvm.mvvmexample.domain.auth.vo.UserInfoVO;
import com.example.mvvm.mvvmexample.ui.login.LoginNavigationProvider;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-04
 */
public class SignUpFragmentVm extends RxViewModel {

	public ObservableField<String> userEmail = new ObservableField<>();
	public ObservableField<String> userPassword = new ObservableField<>();
	public ObservableField<String> userRePassword = new ObservableField<>();

	@NonNull private final LoginNavigationProvider loginNavigationProvider;
	@NonNull private final AuthService authService;
	@NonNull private final MessageProvider messageProvider;
	@NonNull private final NavigationProvider navigationProvider;

	@Inject
	public SignUpFragmentVm(
		@NonNull LoginNavigationProvider loginNavigationProvider,
		@NonNull AuthService authService,
		@NonNull MessageProvider messageProvider,
		@NonNull NavigationProvider navigationProvider) {
		this.loginNavigationProvider = loginNavigationProvider;
		this.authService = authService;
		this.messageProvider = messageProvider;
		this.navigationProvider = navigationProvider;
	}

	public OnClickedListener onClickSignUpButton = () -> signUp();

	public OnClickedListener onClickedCancle = new OnClickedListener() {
		@Override
		public void onClickedView() {
			loginNavigationProvider.popBackStack();
		}
	};

	public OnReceived<String> onUserEmailTextChanged = receivedObj -> userEmail.set(receivedObj);

	public OnReceived<String> onPasswordTextChanged = receivedObj -> userPassword.set(receivedObj);

	public OnReceived<String> onRePasswordTextChanged = receivedObj -> userRePassword.set(receivedObj);

	private void signUp() {
		if (StringUtils.isEmpty(userEmail.get())) {
			messageProvider.showToast(R.string.signup_warn_empty_email);
			return;
		} else if (StringUtils.isEmpty(userPassword.get()) || StringUtils.isEmpty(userRePassword.get())) {
			messageProvider.showToast(R.string.signup_warn_empty_pw_re);
			return;
		}

		addSubscriber(
			authService.signUp(userEmail.get(), userPassword.get())
				.concatMap(
					(Func1<Boolean, Observable<UserInfoVO>>) aBoolean ->
						(aBoolean ? authService.login(userEmail.get(), userPassword.get())
							: Observable.error(new NullPointerException("Result boolean object is Null.")))
				)
				.subscribe(
					new Subscriber<UserInfoVO>() {
						@Override
						public void onCompleted() {
						}

						@Override
						public void onError(Throwable e) {
							// 회원가입, 로그인 도중 오류 발생
							messageProvider.showToast(e.getMessage());
						}

						@Override
						public void onNext(UserInfoVO userInfoVO) {
							// 회원가입 후 로그인 성공 -> 메인 화면으로 이동
							navigationProvider.startMainActivity();
						}
					}
				)
		);
	}

}
