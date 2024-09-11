package com.example.demo.project3.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.project3.entity.Member;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 객체가존재하는지확인() {
	
	System.out.println("MemberRepository = " + memberRepository);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void 데이터삽입() {
		Member member = Member
				.builder()
				.userId("yoyt22")
				.grade("관리자")
				.password("1234")
				.build();
		
		memberRepository.save(member);
	}
	
	
	
	@Test
	public void 데이터단건조회() {
		Optional<Member> result = memberRepository.findById("admin");
		Member member = result.get();
		System.out.println(member);
	}
	
	@Test
	public void 데이터전체조회() {
		List<Member> members =memberRepository.findAll();
		for(Member member : members) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Member> result = memberRepository.findById("admin");
		Member member = result.get();
		member.setGrade("사용자");
	}
	
	@Test
	public void 데이터삭제() {
		memberRepository.deleteById("user1");
	}
	
	@Test
	public void 데이터전체삭제() {
		memberRepository.deleteAll();
	}





}

