package com.example.demo.project3.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.project3.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 객체가있나확인() {
		System.out.println("orderRepository = " + orderRepository);
	}
	
//	@Test
//	public void 데이터등록() {
//		Order order = Order
//				.builder()
//				.customer_name("고길동")
//				.orderDate(LocalDate.of(2023, 7, 2))
//				.build();
//		orderRepository.save(order);
//	}
//	
	@Test
	public void 데이터단건조회() {
		Optional<Order> result = orderRepository.findById(1);
		
		if(result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Order> orders =orderRepository.findAll();
		
		for(Order order:orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터수정하기() {
		Optional<Order> result = orderRepository.findById(1);
		Order order = result.get();
		order.setOrderDate(LocalDate.of(2023, 7, 1));
		
		orderRepository.save(order);
	}
	
	@Test
	public void 데이터단건삭제하기() {
		orderRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제하기() {
		orderRepository.deleteAll();
	}
	
}