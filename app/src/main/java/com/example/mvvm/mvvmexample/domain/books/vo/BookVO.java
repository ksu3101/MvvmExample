package com.example.mvvm.mvvmexample.domain.books.vo;

import lombok.Data;

/**
 * @author KangSungWoo
 * @since 2017-03-23
 */
@Data
public class BookVO {
	private long id;
	private String name;
	private int pages;
	private int price;
	private String author;
	private String publisher;
	private String coverImgUrl;
	private String shortDescript;
	private boolean hasEBook;
}
