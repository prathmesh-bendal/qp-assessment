package com.pbendal.gms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbendal.gms.model.Product;
import com.pbendal.gms.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		String result=productService.addProduct(product);
		
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products=productService.getAllProducts();
		if(products==null)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") String id)
	{
		Product product=productService.getProduct(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		String result=productService.updateProduct(product);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id)
	{
		String result=productService.deleteProduct(id);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
			
	}

}
