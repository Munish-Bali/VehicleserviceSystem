package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Bill;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Payment;
import com.coforge.JASproject.dao.BillDao;
import com.coforge.JASproject.database.DbConnect;


public class BillDaoImpl implements BillDao{

	Payment p;
	Bill b;
	Scanner sc;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;

	public BillDaoImpl(Payment p) {
		this.p = p;
		b=new Bill(p);
		b.setPaymentId(p.getPaymentId());
		sc=new Scanner(System.in);
	}
	
	public void add() {
		try{
			con=DbConnect.dbConnect();
			con.setAutoCommit(false);
			String str="insert into bill values(?,?)";
			Scanner sc=new Scanner(System.in);
			System.out.println("Insert InvoiceNo");
			int inid=sc.nextInt();
			System.out.println("Insert PaymentId");
            int pid=sc.nextInt();
			pst=con.prepareStatement(str);
			pst.setInt(1, inid);
            pst.setInt(2, pid);
           
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
			
				pst.close();
			    con.close();
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
				System.out.println(rst.getInt(1)+" : "+ rst.getInt(2));
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
//		System.out.println("----Invoice Detail-----");
//		System.out.println("Invoice no:");
//		b.setInvoiceNo(sc.nextInt());
//		b.setPaymentId(p.getPaymentId());
//		
//		
//	}
//	public void get() {
//		System.out.println("Invoice No :"+b.getInvoiceNo());
//		System.out.println(b.getPaymentId());
//		
//	}
	public Bill getB() {
		return b;
	}
	public void setB(Bill b) {
		this.b = b;
	}
	
	
}
