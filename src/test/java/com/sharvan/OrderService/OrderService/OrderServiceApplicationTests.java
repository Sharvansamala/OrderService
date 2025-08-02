package com.sharvan.OrderService.OrderService;

import com.sharvan.OrderService.OrderService.controller.OrderController;
import com.sharvan.OrderService.OrderService.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class OrderServiceApplicationTests {


	@Test
	void contextLoads() {
	}

	@Test
	void testAddition(){
		int result = 2 + 3;
		assertEquals(5,result);

		assertNotEquals(6,result);
	}


	@Test
	void testStringLength(){

	}
}
