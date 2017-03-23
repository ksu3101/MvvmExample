package com.example.mvvm.mvvmexample.domain.books;

import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.domain.books.vo.BookDetailVO;
import com.example.mvvm.mvvmexample.domain.books.vo.BookVO;

import rx.Observable;

import java.util.List;

/**
 * @author KangSungWoo
 * @since 2017-03-23
 */
public class BookRepositoryImpl implements BookRepository {

	@NonNull
	@Override
	public Observable<List<BookVO>> getBooks() {
		// 1. check memory
		// 2. check local database. (like sqlite or realm)
		// 3. retrive from remote.
		return null;
	}

	@NonNull
	@Override
	public Observable<BookDetailVO> getBookDetails(long bookId) {
		return null;
	}
}
