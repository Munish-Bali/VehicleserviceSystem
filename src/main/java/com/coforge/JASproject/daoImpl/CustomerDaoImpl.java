package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Customer;
import com.coforge.JASproject.dao.CustomerDao;
import com.coforge.JASproject.database.DbConnect;




public class CustomerDaoImpl implements CustomerDao{

	Customer c;
	Scanner sc;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;
	public CustomerDaoImpl(){
		c=new Customer();
		 sc=new Scanner(System.in);
	}
	
	
	
	public void add() {
		try{
			con=DbConnect.dbConnect();
			con.setAutoCommit(false);
			String str="insert into customer values(?,?,?,?,?)";
			Scanner sc=new Scanner(System.in);
			System.out.println("Insert custId");
			int cid=sc.nextInt();
			System.out.println("Insert custName");
		    String cname=sc.next();
			System.out.println("Insert custEmail");
			String cemail=sc.next();
			System.out.println("Insert custAdd");
			String cadd=sc.next();
			System.out.println("Insert custPhoneNo");
			Long cph=sc.nextLong();
		
			pst=con.prepareStatement(str);
			pst.setInt(1, cid);
            pst.setString(2, cname);
            pst.setString(3, cemail);
            pst.setString(4, cadd);
            pst.setLong(5, cph);
           
            pst.executeUpdate();
            
            System.out.println("Data  Inserted");
			
          }catch(Exception e)
		  {
        	e.printStackTrace();
        	try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }finally{
			  try {
				con.commit();
				pst.close();
			   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
			
	}
	public void update() {
		try{
		
			con.setAutoCommit(false);
			String str="update customer set CustName =? where CustId=?";
			pst=con.prepareStatement(str);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter custName");
			String CustName=sc.next();
			System.out.println("Enter custId ");
			int CustId=sc.nextInt();
			pst.setString(1, CustName);
			pst.setInt(2, CustId);
			pst.executeUpdate();
			System.out.println("Row updated");
			
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				con.commit();
				pst.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public void delete() {
		
		try{
			
			con.setAutoCommit(false);
			String str="delete from customer where CustId=?";
			pst=con.prepareStatement(str);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter custId");
			int CustId=sc.nextInt();
			pst.setInt(1, CustId);
			
			pst.executeUpdate();
			System.out.println("Row Deleted");
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			finally{
				try {
					con.commit();
					pst.close();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	public void retrieve() {
		
		
		String query="Select * from customer";
		try {
			pst=con.prepareStatement(query);
			rst=pst.executeQuery();
			System.out.println("Retrieved Data");
			while(rst.next()){
				System.out.println(rst.getInt(1)+" : "+ rst.getString(2)+" : "+ rst.getString(3)+" : "+ rst.getString(4)+" : "+rst.getLong(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
				rst.close();
				pst.close();
				con.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}
		
	
//	public void set() {
//		System.out.println("-----Enter Customer details-------");
//		System.out.println("Enter ID");
//		c.setCustId(sc.nextInt());
//		System.out.println("Enter Name");
//		c.setCustName(sc.next());
//		sc.next();
//		System.out.println("Enter Mail");
//		c.setCustMail(sc.next());
//		System.out.println("Enter Phone");
//		c.setCustPhoneNo(sc.nextLong());
//		System.out.println("Enter Address");
//		c.setCustAdd(sc.next());
//	}
//	public void get() {
//		System.out.println("------Customer details-----");
//		c.getCustId();
//		c.getCustName();
//		c.getCustMail();
//		c.getCustAdd();
//		c.getCustPhoneNo();
//		
//		
//	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}

}
