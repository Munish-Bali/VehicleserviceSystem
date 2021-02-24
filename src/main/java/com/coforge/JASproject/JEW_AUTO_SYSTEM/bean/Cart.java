package com.coforge.JASproject.JEW_AUTO_SYSTEM.bean;

public class Cart {

	private int CustId,JewId;

	Customer c;
	Jewellery j;
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

	public int getCustId() {
		return CustId;
	}

	public void setCustId(Customer c) {
		CustId = c.getCustId();
	}

	public int getJewId() {
		return JewId;
	}

	public void setJewId(Jewellery j) {
		JewId = j.getJewId();
	}

}
