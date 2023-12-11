package com.pbendal.gms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbendal.gms.model.Product;
import com.pbendal.gms.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	 
	
	 
	
	public String addProduct(Product product)
	{
		Product existingProduct=getProduct(product.getId());
		if(existingProduct!=null)
		{
			return "product already present";
		}
		try {
			productRepository.save(product);
			return "Product Successfully added";
		}catch (Exception e)
		{
			System.out.println("add product exception:"+e.getMessage());
			return "Product addition failed";
		}
	}
	
	public List<Product> getAllProducts()
	{
		try {
			Iterable<Product> list=productRepository.findAll();
			List<Product> products=new ArrayList<>();
			list.forEach(products::add);
			return products;
			
		} catch(Exception e)
		{
			System.out.println("get all products exception:"+e.getMessage());
			return null;
		}
		
	}
	
	public Product getProduct(String id)
	{
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent())
			return product.get();
		
		return null;
	}
	
	public String updateProduct(Product product)
	{
		Product existingProduct=getProduct(product.getId());
		if(existingProduct==null)
		{
			return "product not present";
		}
		try {
			productRepository.save(product);
			return "product updated successfully";
		}catch (Exception e)
		{
			System.out.println("update product exception:"+e.getMessage());
			return "product updation failed";
		}
		
	}
	
	public String deleteProduct(String id)
	{
		try {
			productRepository.deleteById(id);
			return "product deleted successfully";
		}
		catch(Exception e)
		{
			System.out.println("delete product exception:"+e.getMessage());
			return "product deletion failed";
		}
		
	}

}
