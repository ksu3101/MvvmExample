package com.example.mvvm.mvvmexample.domain.auth;

import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.common.network.NetApiGenerator;
import com.example.mvvm.mvvmexample.common.utils.RxUtils;
import com.example.mvvm.mvvmexample.domain.auth.vo.UserInfoVO;

import rx.Observable;

import javax.inject.Inject;

/**
 * @author KangSungWoo
 * @since 2017-03-06
 */
public final class AuthService {

	@NonNull
	private AuthApi authApi;

	@Inject
	public AuthService() {
		this.authApi = NetApiGenerator.generateApi(AuthApi.class);
	}

	@NonNull
	public Observable<UserInfoVO> login(@NonNull String userEmail, @NonNull String pw) {
		return authApi.login(userEmail, pw)
			.compose(RxUtils.applyBlockedCallSchedulers());
	}

	@NonNull
	public Observable<Boolean> logout(@NonNull String userEmail) {
		return authApi.logout(userEmail)
			.compose(RxUtils.applyDefaultSchedulers());
	}

	@NonNull
	public Observable<UserInfoVO> retrieveUserInfo(@NonNull String userEmail) {
		return authApi.retrieveUserInfo(userEmail)
			.compose(RxUtils.applyDefaultSchedulers());
	}

	@NonNull
	public Observable<Boolean> checkUserEmail(@NonNull String userEmail) {
		return authApi.checkUserEmail(userEmail)
			.compose(RxUtils.applyDefaultSchedulers());
	}

	@NonNull
	public Observable<Boolean> signUp(@NonNull String userEmail, @NonNull String password) {
		return authApi.signUp(userEmail, password)
			.compose(RxUtils.applyBlockedCallSchedulers());
	}

}
