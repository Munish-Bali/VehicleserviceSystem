package com.coforge.JASproject.JEW_AUTO_SYSTEM.bean;

public class Feedback {

	private int custId ,jewId;
	private float rating;
	private String Review;
	Customer c;
	Jewellery j;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getJewId() {
		return jewId;
	}
	public void setJewId(int jewId) {
		this.jewId = jewId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
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


}
