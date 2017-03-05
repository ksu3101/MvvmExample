package com.example.mvvm.mvvmexample.domain.login.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
@EqualsAndHashCode(callSuper = true) @Data
public class SignUpUserInfoVO extends UserInfoVO {
	private String password;

}
