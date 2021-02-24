package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Order;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Payment;
import com.coforge.JASproject.dao.PaymentDao;
import com.coforge.JASproject.database.DbConnect;

public class PaymentDaoImpl implements PaymentDao{

	 Order o;
	 Payment p;
	Scanner sc;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;
	
	public PaymentDaoImpl(Order o) {
		this.o = o;
		p=new Payment();
		sc=new Scanner(System.in);
	}
	
	public void add() {
		
		try{
			con=DbConnect.dbConnect();
			con.setAutoCommit(false);
			String str="insert into payment values(?,?,?,?)";
			Scanner sc=new Scanner(System.in);
			System.out.println("Insert PaymentId");
			int pid=sc.nextInt();
			System.out.println("Insert PaymentMode");
		    String pmode=sc.next();
			System.out.println("Insert OrderId");
			int oid=sc.nextInt();
			System.out.println("Insert Amount");
			Double amnt=sc.nextDouble();
		
			pst=con.prepareStatement(str);
			pst.setInt(1, pid);
            pst.setString(2, pmode);
            pst.setInt(3, oid);
            pst.setDouble(4, amnt);
           
           
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
			String str="update payment set Amount =? where PaymentId=?";
			pst=con.prepareStatement(str);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Amount");
			Double Amount=sc.nextDouble();
			System.out.println("Enter PaymentId");
			int PaymentId=sc.nextInt();
			pst.setDouble(1, Amount);
			pst.setInt(2, PaymentId);
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
			String str="delete from Payment where PaymentId=?";
			pst=con.prepareStatement(str);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter PaymentId");
			int PaymentId=sc.nextInt();
			pst.setInt(1, PaymentId);
			
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
		String query="Select * from payment";
		try {
			pst=con.prepareStatement(query);
			rst=pst.executeQuery();
			System.out.println("Retrieved Data");
			while(rst.next()){
				System.out.println(rst.getInt(1)+" : "+ rst.getString(2)+" : "+ rst.getInt(3)+" : "+ rst.getDouble(4));
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
//		System.out.println("------Enter Payment Details-------");
//		p.setAmount(o.getJ().getJewPrice());
//		p.setOrderId(o.getOrderId());
//		System.out.println("Enter Payment ID");
//		p.setPaymentId(sc.nextInt());
//		System.out.println("Enter payment mode");
//		p.setPaymentMode(sc.next());
//		
//	}
//	public void get() {
//		System.out.println("Payment Detail:-");
//		System.out.println(p.getPaymentId());
//		System.out.println(p.getOrderId());
//		System.out.println(p.getAmount());
//		
//		
//	}
	public Payment getP() {
		return p;
	}
	public void setP(Payment p) {
		this.p = p;
	}
	
}
