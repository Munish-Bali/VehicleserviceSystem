package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.BillDaoImpl;
import com.coforge.JASproject.service.BillService;

public class BillServiceImpl implements BillService{

BillDaoImpl bd=null;
	
	public BillServiceImpl(PaymentServiceImpl ps) {
		bd=new BillDaoImpl(ps.getPd().getP());
	}

	public void add() {
		bd.add();
		
	}


	public void delete() {
		bd.delete();
		
	}

	public void retrieve() {
		bd.retrieve();
		
	}


}
