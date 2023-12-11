package com.pbendal.gms.beans;

import java.util.ArrayList;
import java.util.List;

import com.pbendal.gms.model.Product;

public class Receipt {
	
	private double bill;
	private List<Product> purchased;
	private List<Product> insufficient_stock;
	private List<Item> unavailable_items;
	
	public Receipt() {
		this.setInsufficient_stock(new ArrayList<>());
		this.setPurchased(new ArrayList<>());
		this.setUnavailable_items(new ArrayList<>());
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public List<Product> getPurchased() {
		return purchased;
	}
	public void setPurchased(List<Product> purchased) {
		this.purchased = purchased;
	}
	public List<Product> getInsufficient_stock() {
		return insufficient_stock;
	}
	public void setInsufficient_stock(List<Product> insufficient_stock) {
		this.insufficient_stock = insufficient_stock;
	}
	
	public List<Item> getUnavailable_items() {
		return unavailable_items;
	}
	public void setUnavailable_items(List<Item> unavailable_items) {
		this.unavailable_items = unavailable_items;
	}
	@Override
	public String toString() {
		return "Receipt [bill=" + bill + ", purchased=" + purchased + ", insufficient_stock=" + insufficient_stock
				+ ", unavailable_items=" + unavailable_items + "]";
	}
	
	
	
	
	
	

}
