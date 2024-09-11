package com.example.demo.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.project3.entity.Memo;

// 리파지토리 : 엔티티를 사용하여 데이터를 처리(crud, 페이징, 정렬)

public interface MemoRepository extends JpaRepository<Memo, Integer> {
	
	

}
// JpaRepository를 생성할 때는 엔티티와 해당 엔티티의 PK타입을 지정해야 한다
