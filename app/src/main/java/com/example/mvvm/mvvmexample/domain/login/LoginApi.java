package com.example.mvvm.mvvmexample.domain.login;

import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.domain.login.vo.UserInfoVO;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public interface LoginApi {

	@FormUrlEncoded
	@POST("/login")
	Observable<UserInfoVO> login(
		@Field("userEmail") @NonNull String userEmail,
		@Field("password") @NonNull String pw
	);

	@FormUrlEncoded
	@POST("/logout")
	Observable<Boolean> logout(@Field("userEmail") @NonNull String userEmail);

	@FormUrlEncoded
	@POST("/userInfo")
	Observable<UserInfoVO> retrieveUserInfo(@Field("userEmail") @NonNull String userEmail);

}
