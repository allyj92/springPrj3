package com.example.demo.project3.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.project3.entity.Git;

@SpringBootTest
public class GitRepositoryTest {
	
	@Autowired
	GitRepository gitRepository;
	
	@Test
	public void 객체가가져와지는지확인() {
		System.out.println("GitRepository = " + gitRepository);	
	}
	
//	@Test
//	public void 데이터등록4() {
//		Git git = Git
//				.builder()
//				.name("벽걸이TV")
//				.price(70000)
//				.type("가전제품")
//				.build();
//		gitRepository.save(git);
//	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Git> git = gitRepository.findById(1);
		System.out.println(git);
	}
	
	@Test
	public void 데이터전체조회() {
		List<Git> results = gitRepository.findAll();
		for(Git git : results) {
			System.out.println(git);
		}
			
	}
	
	@Test
	public void 데이터수정() {
		Optional<Git> git = gitRepository.findById(2);
		Git git2 = git.get();
		git2.setName("스팸세트");
		
		gitRepository.save(git2);
	}
	
	@Test
	public void 데이터단건삭제() {
		gitRepository.deleteById(2);
	}
	
	@Test
	public void 데이터전체삭제() {
		gitRepository.deleteAll();
	}
	
	

}
