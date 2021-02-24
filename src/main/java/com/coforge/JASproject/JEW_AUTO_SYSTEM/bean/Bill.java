package com.coforge.JASproject.JEW_AUTO_SYSTEM.bean;

public class Bill {

	 Payment p;
		
		private int InvoiceNo, PaymentId;
		public Bill(Payment p){
			this.p=p;
			
		}

		public Payment getP() {
			return p;
		}

		public void setP(Payment p) {
			this.p = p;
		}

		public int getInvoiceNo() {
			return InvoiceNo;
		}

		public void setInvoiceNo(int invoiceNo) {
			InvoiceNo = invoiceNo;
		}

		public int getPaymentId() {
			return PaymentId;
		}

		public void setPaymentId(int paymentId) {
			PaymentId = paymentId;
		}
		
}
