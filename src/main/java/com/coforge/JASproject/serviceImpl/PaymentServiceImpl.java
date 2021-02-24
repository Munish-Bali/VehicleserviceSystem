package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.PaymentDaoImpl;
import com.coforge.JASproject.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{

PaymentDaoImpl pd=null;
	
	public PaymentServiceImpl(OrderServiceImpl o) {
		pd=new PaymentDaoImpl(o.getOd().getO());
	}

	public void add() {
		pd.add();
		
	}

	public void update() {
		pd.update();
		
	}
	public void delete() {
		pd.delete();
		
	}

	public void retrieve() {
		pd.retrieve();
		
	}

	public PaymentDaoImpl getPd() {
		return pd;
	}

	
}
