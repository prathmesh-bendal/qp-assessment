package com.pbendal.gms.repository;




import java.util.List;

import org.springframework.stereotype.Repository;

import com.pbendal.gms.model.Product;



@Repository
public interface ProductRepository  {
	
	 Product save(Product p);
	 
	 List<Product> findAll();
	 
	 Product findById(String id);
	 
	 boolean deleteById(String id);
	
	 
	

}
