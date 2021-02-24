package com.coforge.JASproject.JEW_AUTO_SYSTEM.bean;

public class Payment {

	 Order o;
		private int PaymentId ,OrderId;
		private String PaymentMode ;
		 private double Amount;
		public int getPaymentId() {
			return PaymentId;
		}
		public Order getO() {
			return o;
		}
		public void setO(Order o) {
			this.o = o;
		}
		public void setPaymentId(int paymentId) {
			PaymentId = paymentId;
		}
		public int getOrderId() {
			return OrderId;
		}
		public void setOrderId(int orderId) {
			OrderId = orderId;
		}
		public String getPaymentMode() {
			return PaymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			PaymentMode = paymentMode;
		}
		public double getAmount() {
			return Amount;
		}
		public void setAmount(double amount) {
			Amount = amount;
		}
		 
}
