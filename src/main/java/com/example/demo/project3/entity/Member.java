package com.example.demo.project3.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tblMember")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {

	@Id
	@Column(length = 255,nullable = false)
	String userId;
	
	@Column(length = 255, nullable = false)
	String grade;
	
	@Column(length = 255 , nullable = false)
	String password;
	
    // 시스템이 현재시간을 자동으로 저장	
	@CreatedDate
//	@LastModifiedBy : 수정이 될때마다 변경되는 부분, 최종으로 변경된 날짜가 저장이 됨
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable=false)
	LocalDate registerDate; 
	
}
