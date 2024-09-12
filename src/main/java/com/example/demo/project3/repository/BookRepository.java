package com.example.demo.project3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.project3.entity.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

	
	
	    //메모의 번호를 기준으로 역정렬
		//select * from tbl_memo order by no desc
		@Query(value = "select * from tbl_book order by book_no desc", nativeQuery = true)
		List<Book> get1();
		
		// 삭제
		@Modifying
		@Query(value = "delete from tbl_book where book_no = :bno", nativeQuery = true)
		void delete1(@Param("bno") int bno);
	
		// 변경 - 객체 파라미터
        // @Modifying
        // @Query(value = "update tbl_book set text = :#{#param.text} where no = :#{#param.no}", nativeQuery = true)
        // int update1(@Param("param") Memo memo);
		
		// 문제 5-1	
        // 제목이 ‘자바프로그래밍입문’인 책을 검색
		@Query(value = "SELECT * FROM tbl_book WHERE title = '자바프로그래밍입문'", nativeQuery = true)
		List<Book> get2();
		
        // 문제 5-2
		// 가격이 ‘3만원’이상이고 출판사가 ‘남가람북스’인 책을 검색
		@Query(value = "SELECT * FROM tbl_book WHERE price>30000 AND publisher = '남가람북스'", nativeQuery = true)
		List<Book> get3();
		
		// 문제 5-3
		// 출판사가 ‘한빛출판사’ 또는 ‘이지스퍼블리싱’인 책을 검색
		@Query(value = "SELECT * FROM tbl_book WHERE publisher IN('한빛출판사','이지스퍼블리싱')", nativeQuery = true)
		List<Book> get4();
		
		
	
}
