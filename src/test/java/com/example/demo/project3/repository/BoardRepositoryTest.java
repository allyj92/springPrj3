package com.example.demo.project3.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.project3.entity.Board;

// 스프링 컨테이너 환경을 빌려옴
// 없으면 컨테이너 안에 있는 빈을 꺼낼 수 없음
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepository;
	
	
	@Test
	public void 리파지토리개체를가져왔는지확인() {
		System.out.println("boardRepository = " + boardRepository);
		
	}
	
	@Test
	public void 데이터등록() {
		Board board = Board
				.builder()
				.title("2번글")
				.content("내용입니다.")
				.build();
		
		boardRepository.save(board);
	}
	
	// 글번호 / 등록일 / 수정일 => 시스템이 입력해야 하는 값
	// 제목 / 내용 => 사용자가 직접 입력해야하는 값
	
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = boardRepository.findById(1);
		
		if (result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}}
	 @Test
	 public void 데이터전체조회() {
	    // findAll : 테이블에 있는 모든 데이터를 조회하는 함수
	    List<Board> boards = boardRepository.findAll();
	    
	    // 람다식 포문으로 하니씩 출력
	    	for(Board board:boards) {
	    		System.out.println(board);
	    	}
	    }
	 
	 @Test
	 public void 데이터수정() {
		 
		 // 게시물을 조회하고, 내용을 일부 변경
		 Optional<Board> result = boardRepository.findById(2);
		 Board board = result.get();
		 board.setContent("내용이수정되었습니다");
		 
		 // 변경한 내용을 저장
		 boardRepository.save(board);
		 
		 // save함수는 추가 또는 수정을 처리한다.
		 boardRepository.save(null);
	 }
	 
	 @Test
	 public void 데이터삭제() {
		 boardRepository.deleteById(1);
	 }
	 
	 @Test
	 public void 데이터전체삭제() {
		 boardRepository.deleteAll();
	 }

}
