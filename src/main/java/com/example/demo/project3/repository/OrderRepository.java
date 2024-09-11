package com.example.demo.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.project3.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
