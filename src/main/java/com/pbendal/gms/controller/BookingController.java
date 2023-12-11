package com.pbendal.gms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbendal.gms.beans.Order;
import com.pbendal.gms.beans.Receipt;
import com.pbendal.gms.service.BookingService;

@RestController
@RequestMapping("/v1/order")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Receipt> placeOrder(@RequestBody Order order)
	{
		Receipt receipt=bookingService.placeOrder(order);
		return new ResponseEntity<>(receipt, HttpStatus.OK);
		
	}

}
