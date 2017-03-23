package com.example.mvvm.mvvmexample.domain.books;

import com.example.mvvm.mvvmexample.domain.books.vo.BookDetailVO;
import com.example.mvvm.mvvmexample.domain.books.vo.BookVO;

import retrofit2.http.Field;
import retrofit2.http.GET;
import rx.Observable;

import java.util.List;

/**
 * @author KangSungWoo
 * @since 2017-03-23
 */
public interface BookApi {

	@GET("/books")
	Observable<List<BookVO>> getBooks();

	@GET("/books/detail/")
	Observable<BookDetailVO> getBookDetails(@Field("bookId") long bookId);

}
