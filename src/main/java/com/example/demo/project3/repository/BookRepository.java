package com.example.demo.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.project3.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
