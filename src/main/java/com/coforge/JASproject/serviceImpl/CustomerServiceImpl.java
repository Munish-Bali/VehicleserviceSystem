package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.CustomerDaoImpl;
import com.coforge.JASproject.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{


	CustomerDaoImpl cd=null;
	
	public CustomerServiceImpl() {
		cd=new CustomerDaoImpl();
	}

	

	public CustomerDaoImpl getCd() {
		return cd;
	}



	public void add() {
		cd.add();
	}



	public void update() {
		cd.update();
	}



	public void delete() {
		cd.delete();
	}



	public void retrieve() {
		cd.retrieve();
		
	}

	
}
