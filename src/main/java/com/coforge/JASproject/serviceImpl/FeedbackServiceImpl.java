package com.coforge.JASproject.serviceImpl;

import com.coforge.JASproject.daoImpl.FeedbackDaoImpl;
import com.coforge.JASproject.service.FeedbackService;

public class FeedbackServiceImpl implements FeedbackService{

FeedbackDaoImpl fd=null;
	
	public FeedbackServiceImpl(CustomerServiceImpl cs,JewelleryServiceImpl js) {
		fd=new FeedbackDaoImpl(cs.getCd().getC(),js.getJd().getJ());
		
	}

	public void add() {
		fd.add();
		
	}

	public void retrieve() {
		fd.retrieve();
		
	}

	public void update() {
		fd.update();
		
	}

	
}
