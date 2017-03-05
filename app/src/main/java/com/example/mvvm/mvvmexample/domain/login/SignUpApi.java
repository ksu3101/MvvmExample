package com.example.mvvm.mvvmexample.domain.login;

import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.domain.login.vo.SignUpUserInfoVO;
import com.example.mvvm.mvvmexample.domain.login.vo.UserInfoVO;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public interface SignUpApi {

	@FormUrlEncoded
	@POST("/checkUserEmail")
	Observable<Boolean> checkUserEmail(@Field("userEmail") @NonNull String userEmail);

	@FormUrlEncoded
	@POST("/signUp")
	Observable<UserInfoVO> signUp(@Body SignUpUserInfoVO signUpUserInfoVO);

}
