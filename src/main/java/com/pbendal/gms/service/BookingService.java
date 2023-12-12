package com.pbendal.gms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbendal.gms.beans.Item;
import com.pbendal.gms.beans.Order;
import com.pbendal.gms.beans.Receipt;
import com.pbendal.gms.model.Product;




@Service
public class BookingService {
	
	@Autowired
	private ProductService productService;
	public Receipt placeOrder(Order order)
	{
		Receipt receipt=new Receipt();
		for(Item item:order.getItems())
		{
			Product product=productService.getProduct(item.getId());
			if(product!=null)
			{
				if(product.getStock()>=item.getQuantity())
				{
					receipt.setBill(receipt.getBill()+product.getPrice()*item.getQuantity());
					product.setStock(product.getStock()-item.getQuantity());
					productService.updateProduct(product);
					Product purchasedProduct=new Product(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getStock());
					purchasedProduct.setStock(item.getQuantity());
					List<Product> purchased=receipt.getPurchased();
					purchased.add(purchasedProduct);
					
				}
				else
				{
					Product unavailableProduct=new Product(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getStock());
					unavailableProduct.setStock(item.getQuantity());
					List<Product> insufficentStocks=receipt.getInsufficient_stock();
					insufficentStocks.add(unavailableProduct);
				}
			}
			else
			{
				List<Item> items=receipt.getUnavailable_items();
				items.add(item);
				receipt.setUnavailable_items(items);
			}
			
		}
		return receipt;
	}
	
	

}
