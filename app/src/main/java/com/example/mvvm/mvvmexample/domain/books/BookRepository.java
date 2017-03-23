package com.example.mvvm.mvvmexample.domain.books;

import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.example.mvvm.mvvmexample.common.base.repository.Repository;
import com.example.mvvm.mvvmexample.domain.books.vo.BookDetailVO;
import com.example.mvvm.mvvmexample.domain.books.vo.BookVO;

import retrofit2.http.Field;
import rx.Observable;

import java.util.List;

/**
 * @author KangSungWoo
 * @since 2017-03-23
 */
public interface BookRepository extends Repository {

	@NonNull
	Observable<List<BookVO>> getBooks();

	@NonNull
	Observable<BookDetailVO> getBookDetails(long bookId);

}
