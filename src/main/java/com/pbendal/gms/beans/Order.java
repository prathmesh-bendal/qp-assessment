package com.pbendal.gms.beans;

import java.util.List;

public class Order {
	
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [items=" + items + "]";
	}
	
	

}
