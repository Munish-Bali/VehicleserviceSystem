package com.coforge.JASproject.JEW_AUTO_SYSTEM.bean;

public class Customer {

	 private int CustId;
	   private String CustName,CustMail,CustAdd;
	  private  long CustPhoneNo;
	  
		public int getCustId() {
			return CustId;
		}
		public void setCustId(int custId) {
			CustId = custId;
		}
		public String getCustName() {
			return CustName;
		}
		public void setCustName(String custName) {
			CustName = custName;
		}
		public String getCustMail() {
			return CustMail;
		}
		public void setCustMail(String custMail) {
			CustMail = custMail;
		}
		public String getCustAdd() {
			return CustAdd;
		}
		public void setCustAdd(String custAdd) {
			CustAdd = custAdd;
		}
		public long getCustPhoneNo() {
			return CustPhoneNo;
		}
		public void setCustPhoneNo(long custPhoneNo) {
			CustPhoneNo = custPhoneNo;
		}

}
