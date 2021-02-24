package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.CartDaoImpl;
import com.coforge.JASproject.service.CartService;

public class CartServiceImpl implements CartService{

CartDaoImpl cartDao=null;
	
	public CartServiceImpl(CustomerServiceImpl cd,JewelleryServiceImpl js) {

		cartDao=new CartDaoImpl(cd.getCd().getC(),js.getJd().getJ());
	}

	public void add() {
		cartDao.add();
		
	}

	public void delete() {
		cartDao.delete();
		
	}

	public void retrieve() {
    cartDao.retrieve();		
	}




}
