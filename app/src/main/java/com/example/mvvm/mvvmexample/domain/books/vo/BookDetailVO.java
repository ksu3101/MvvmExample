package com.example.mvvm.mvvmexample.domain.books.vo;

import com.example.mvvm.mvvmexample.domain.books.datas.BookCategory;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author KangSungWoo
 * @since 2017-03-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookDetailVO extends BookVO {

	private String detailDescript;
	private int userScore;
	private BookCategory category;

}
