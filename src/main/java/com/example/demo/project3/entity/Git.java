package com.example.demo.project3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="tblGit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Git {
	
	@Id
	@Column(length = 11,nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;
	
	@Column(length = 20, nullable = false)
	String name;
	
	@Column(length=11,nullable = false)
	int price;
	
	@Column(length = 20, nullable = false)
	String type;
	
	
}
