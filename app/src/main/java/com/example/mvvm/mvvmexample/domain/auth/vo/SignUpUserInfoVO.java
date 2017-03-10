package com.example.mvvm.mvvmexample.domain.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
@Data
@AllArgsConstructor
public class SignUpUserInfoVO extends UserInfoVO {
	private String userEmail;
	private String password;
}
