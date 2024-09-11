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
	
//	@Test
//	public void 데이터등록2() {
//		Book board = Book
//				.builder()
//				.price(35000)
//				.publisher("이지스퍼블리싱")
//				.title("알고리즘코딩테스트")
//				.build();
//		
//		bookRepository.save(board);
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
	
	
	
	
	
	
	
	

}
