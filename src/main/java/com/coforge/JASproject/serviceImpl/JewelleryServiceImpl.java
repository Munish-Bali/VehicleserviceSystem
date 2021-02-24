package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.JewelleryDaoImpl;
import com.coforge.JASproject.service.JewelleryService;

public class JewelleryServiceImpl implements JewelleryService{

JewelleryDaoImpl jd=null;
	
	public JewelleryServiceImpl() {
		jd=new JewelleryDaoImpl();
	}

	public void add() {
		jd.add();
		
	}
	
	public void update() {
		jd.update();
		
	}

	public void delete() {
		jd.delete();
		
	}
	public void retrieve() {
		jd.retrieve();
		
	}

	

	public JewelleryDaoImpl getJd() {
		return jd;
	}


}
