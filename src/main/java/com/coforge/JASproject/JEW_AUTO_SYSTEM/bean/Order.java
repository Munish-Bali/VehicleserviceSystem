package com.coforge.JASproject.JEW_AUTO_SYSTEM.bean;

public class Order {

	Customer c;
	Jewellery j;
	int orderId,custId,jewId;
	String Order_Date;

	public Order(Customer c,Jewellery j) {
		this.c=c;
		this.j=j;
		
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public Jewellery getJ() {
		return j;
	}
	public void setJ(Jewellery j) {
		this.j = j;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId() {
		custId = c.getCustId();
	}
	public int getJewId() {
		return jewId;
	}
	public void setJewId() {
		jewId = j.getJewId();
	}
	public String getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}
	
}
