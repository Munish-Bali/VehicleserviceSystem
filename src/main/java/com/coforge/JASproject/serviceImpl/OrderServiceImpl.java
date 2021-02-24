package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.OrderDaoImpl;
import com.coforge.JASproject.service.OrderService;

public class OrderServiceImpl implements OrderService{

OrderDaoImpl od=null;
	
	public OrderServiceImpl(CustomerServiceImpl cs,JewelleryServiceImpl js) {
		od=new OrderDaoImpl(cs.getCd().getC(),js.getJd().getJ());
	}

	

	public OrderDaoImpl getOd() {
		return od;
	}



	public void add() {
		od.add();
		
	}



	public void update() {
	od.update();
		
	}



	public void retrieve() {
		od.retrieve();
	}



	public void delete() {
		od.delete();
		
	}

}
