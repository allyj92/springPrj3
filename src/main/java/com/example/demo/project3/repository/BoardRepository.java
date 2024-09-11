package com.example.demo.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.project3.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
