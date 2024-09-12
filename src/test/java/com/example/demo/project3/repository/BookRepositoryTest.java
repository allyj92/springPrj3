package com.example.demo.project3.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.project3.entity.Book;

@SpringBootTest
public class BookRepositoryTest {
	
	
	
	
	@Autowired
	BookRepository bookRepository;
	
	
	@Test
	public void 객체가져와지는지확인() {
		System.out.println("bookRepository= " + bookRepository);
	} 
	
//@Test
//   public void 데이터등록2() {
//		Book board1 = Book
//				.builder()
//				.price(20000)
//				.publisher("한빛출판사")
//				.title("자바프로그래밍입문")
//				.build();
//		
//		bookRepository.save(board1);
//		
//		Book board2 = Book
//				.builder()
//				.price(25000)
//				.publisher("남가람북스")
//				.title("스프링부트프로젝트")
//				.build();
//		
//		bookRepository.save(board2);
//		
//		Book board3 = Book
//				.builder()
//				.price(40000)
//				.publisher("남가람북스")
//				.title("실무로 끝내는 php")
//				.build();
//		
//		bookRepository.save(board3);
//		
//		Book board4 = Book
//				.builder()
//				.price(35000)
//				.publisher("이지스퍼블리싱")
//				.title("알고리즘코딩테스트")
//				.build();
//		
//		bookRepository.save(board4);
//	}
//	
	@Test
	public void 데이터단건조회() {
		Optional<Book> result = bookRepository.findById(1);
		if(result.isPresent()) {
			Book book2 = result.get();
			System.out.println(book2);
			
		}}
	
	@Test
	public void 데이터전체조회() {
		List<Book> books= bookRepository.findAll();
		
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터수정() {
		// 게시물을 조회하고, 내용을 일부 변경
		Optional<Book> result = bookRepository.findById(2);
		Book book = result.get();
		book.setPublisher("남가람북스");
		
		bookRepository.save(book);
		
	}
	
	@Test
	public void 데이터단건삭제() {
		bookRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		bookRepository.deleteAll();
	}
	
	// primitive query
	@Test
	public void 번호를기준으로역정렬한_책색() {
		List<Book> list = bookRepository.get1();
		for(Book book : list) {
			System.out.println(book);
		}}
	
	
	@Test
	public void 데이터삭제() {
		bookRepository.delete1(3);
	}
	
	
    // 문제 5-1	
	@Test
	public void 제목이_자바프로그래밍입문인_책을검색() {
		List<Book> book = bookRepository.get2();
		System.out.println(book);
	}
	
	// 문제 5-2
	@Test
	public void 가격이3만원이상이고_출판사가남가람북스인_책검색() {
		List<Book> lst = bookRepository.get3();
		for(Book book:lst) {
			System.out.println(book);
		}
		
	}
	
	// 문제 5-3
	@Test
	public void 출판사가_한빛출판사_또는_이지퍼블리싱_인책을검색() {
		List<Book> lst = bookRepository.get4();
		for(Book book:lst) {
			System.out.println(book);
		}
	}
	
	
	
	
	
	
	
	

}
