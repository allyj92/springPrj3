package com.example.demo.project3.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.project3.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest3 {

	
		@Autowired
		MemoRepository2 memoRepository;
	
		
		@Test
		public void 번호가3보다작은_메모검색() {
			List<Memo> list = memoRepository.get1(7);
			for(Memo memo : list) {
				System.out.println(memo);
			}
		}
		
		@Test
		public void 텍스트가null이아닌_메모검색() {
			List<Memo> list = memoRepository.get2();
			for(Memo memo : list) {
				System.out.println(memo);
			}
		}
		
		@Test
		public void 텍스트가null인_메모검색1() {
			List<Memo> list = memoRepository.get7();
			for(Memo memo : list) {
				System.out.println(memo);
			}
		}
		
		
		@Test
		public void 번호가2와3사이인_메모검색() {
			List<Memo> list = memoRepository.get3(2, 3);
			for(Memo memo : list) {
				System.out.println(memo);
			}
		}
		
		@Test
		public void 텍스트가null인_메모검색() {
			List<Memo> list = memoRepository.get4();
			for(Memo memo : list) {
				System.out.println(memo);
		}
}
		
		
//		순수한 SQL 단위테스트
		@Test
		public void 번호를기준으로역정렬한_메모검색() {
			List<Memo> list = memoRepository.get5();
			for(Memo memo : list) {
				System.out.println(memo);
			}
		}
		
		
		@Test
		public void 데이터삭제() {
			memoRepository.delete1(18);
		}
		
		@Test
		public void 데이터수정() {
		Memo memo = new Memo(25,"변경했습니다");
		memoRepository.update1(memo);
	}
	
		
		
		
		}
