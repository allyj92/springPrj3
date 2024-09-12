package com.example.demo.project3.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.project3.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_2 {
	
	@Autowired
	MemoRepository repository;
	
	@Test
	void 메모리데이터100개등록() {
		// rangeClosed: 특정 범위의 숫자들로 스트림을 생성하는 함수
				// forEach: 특정 작업을 수행하는 함수
		// 1부터 100까지의 숫자를 포함하는 스트림을 생성하고, 1부터 100까지의 숫자를 하나씩 출력
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo
					.builder()
					.text("Sample.." + i)
					.build();
			repository.save(memo);
		});
		
		
	}
	

	@Test
	void 페이징처리() {
		// Pageable: 페이지 번호, 데이터 개수를 담아서 조건을 생성
		// of: Pageable 객체를 생성하는 함수
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Memo> page = repository.findAll(pageable);
		
		// 결과에서 실제 데이터 꺼내기 
		List<Memo> list = page.getContent();
		
		System.out.println(list);
		
		// 페이징 처리를 하면 sql에 limit이 추가된다.
		// 이때 SQL의 LIMIT절은 "LIMIT 0,10"이 된다.
		// 만약 두 번째 페이지를 조회한다면 LIMIT절은 "LIMIT 10, 10"이 된다
		//  시작번호,개수
			
	}
	@Test
	void 정렬조건추가하기() {
		// no 필드를 기준으로 역정렬하는 조건을 생성
		Sort sort = Sort
				.by("no") // 정렬 기준
				.descending(); // 정렬 방식 (ASC,DES)
		
		// 페이징 조건에 정렬 방식 추가
		Pageable pageable = PageRequest.of(0, 10, sort);
		
		// 페이지 조건을 전달하여 데이터 조회
		Page<Memo> page = repository.findAll(pageable);
		
		// 결과에서 실제데이터만 꺼내기
		List<Memo> list = page.getContent();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
		
		// 정렬 조건을 추가하여 sql에 order by절이 추가됨
	}
	
}
