package com.example.mvvm.mvvmexample.domain.books.datas;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * @author KangSungWoo
 * @since 2017-03-23
 */
public enum BookCategory {
	@SerializedName("100")
	NOVEL(100),
	@SerializedName("101")
	POEM(101),
	@SerializedName("102")
	ECONOMY(102),
	@SerializedName("103")
	SOCIAL(103),
	@SerializedName("104")
	CULTURE(104),
	@SerializedName("105")
	HOME(105),
	@SerializedName("106")
	COOK(106),
	@SerializedName("107")
	CHILD(107),
	@SerializedName("108")
	HEALTH(108),
	@SerializedName("109")
	HOBBY(109),
	@SerializedName("110")
	LANGUAGE(110),
	@SerializedName("111")
	IT(111),
	@SerializedName("999")
	UNKNOWN(999);

	@Getter
	private int categoryCode;

	BookCategory(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	@NonNull
	public static BookCategory from(int value) {
		switch (value) {
			case 100:
				return NOVEL;
			case 101:
				return POEM;
			case 102:
				return ECONOMY;
			case 103:
				return SOCIAL;
			case 104:
				return CULTURE;
			case 105:
				return HOME;
			case 106:
				return COOK;
			case 107:
				return CHILD;
			case 108:
				return HEALTH;
			case 109:
				return HOBBY;
			case 110:
				return LANGUAGE;
			case 111:
				return IT;
			default:
				return UNKNOWN;
		}
	}

}
