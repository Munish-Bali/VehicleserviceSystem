package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Cart;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Customer;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Jewellery;
import com.coforge.JASproject.dao.CartDao;
import com.coforge.JASproject.database.DbConnect;


public class CartDaoImpl implements CartDao{

	Customer c;
	Jewellery j;
	Cart cart;
	Scanner sc;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;
	public CartDaoImpl(Customer c, Jewellery j) {
		this.c = c;
		this.j = j;
		cart=new Cart();
		sc=new Scanner(System.in);
	}
	
	public boolean checking(int custId,int jewId) {
		boolean flag=false;
		try {
			System.out.println("Please wait Id under verification");
			pst=con.prepareStatement("select * from Customer where CustId=?");
			pst.setInt(1, custId);
			ResultSet rs1=pst.executeQuery();
			pst=con.prepareStatement("select * from Jewellery where jewId=?");
			pst.setInt(1, jewId);
			ResultSet rs2=pst.executeQuery();
			boolean size=(rs1.next() && rs2.next());
			if(size) {
				System.out.println("verified");
				flag=true;
			}
			else {
				flag=false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(flag) {
			return flag;
		}
		else {
		System.out.println("Incorrect or Data doest exist in Database"
				+ "What want to "
				+ "1.exit "
				+ "2.Re-Enter ");
		int j=sc.nextInt();
		if(j==1) {
			System.exit(0);
			return flag;
		}
		else {
			return flag;
		}
	}
		
	}
	public void add() {
		System.out.println("---------Enter Cart Details------");
		int flag=0,i=0;
		
		do {
			System.out.println("Customer id ");
			int custId=sc.nextInt();
			System.out.println("Jewelley id ");
			int jewId=sc.nextInt();
			if(! checking(custId,jewId)) {
				flag=1;
				/*System.out.println("Incorrect or Data doest exist in Database"
						+ "What want to "
						+ "1.exit "
						+ "2.Re-Enter ");
				int j=sc.nextInt();
				if(j==1) {
					System.exit(0);
				}*/
				
			}
			else {
				flag=0;
				try {
					
				pst=con.prepareStatement("insert into Cart values(?,?)");
				pst.setInt(1, custId);
				pst.setInt(2, jewId);
				pst.executeUpdate();
				System.out.println("---");
				System.out.println("do you want to insert more 1 for yes 0 fo no");
				 i=sc.nextInt();
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Data Already Exist");
				}
			}
				}while(i==1||flag==1);
		
		
	}
	
	public void delete() {
		String query="delete from cart where custid=? and jewId=?";
		System.out.println("Enter Customer Id for which you want to delete data");
		int cid=sc.nextInt();
		System.out.println("Enter Jewellery Id for which you want to delete data");
		int jid=sc.nextInt();
		try {
			pst=con.prepareStatement(query);
			pst.setInt(1, cid);
			pst.setInt(2, jid);
			if(	pst.executeUpdate()>0) {
				System.out.println("SUCESSFULLY Deleted");
		    }
		    else {
		    	System.out.println("id  not exist");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void retrieve() {
		ResultSet rs=null;
		String query="select * from cart";
		try {
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("CustId")+":"+rs.getInt("jewId"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
//	public void set() {
//		cart.setCustId(c);
//		cart.setJewId(j);
//		
//	}
//	public void get() {
//		System.out.println("-----------Cart Item----------");
//		System.out.println("Customer id="+cart.getCustId());
//		System.out.println("Jewellery id"+cart.getJewId());
//		
//	}
	public Cart getCart() {
		return cart;
	}

	
}
