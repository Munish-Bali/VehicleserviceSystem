package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Customer;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Feedback;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Jewellery;
import com.coforge.JASproject.dao.FeedbackDao;
import com.coforge.JASproject.database.DbConnect;

public class FeedbackDaoImpl implements FeedbackDao{

	Feedback f;
	Customer c;
	Jewellery j;
	Scanner sc;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;
	
	public FeedbackDaoImpl(Customer c,Jewellery j){
		f=new Feedback();
		sc=new Scanner(System.in);
		this.c=c;
		this.j=j;
		f.setC(c);
		f.setJ(j);
		try {
			con=DbConnect.dbConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void add() {
		try{
			con.setAutoCommit(false);
			String str="insert into feedback values(?,?,?,?)";
			Scanner sc=new Scanner(System.in);
			System.out.println("Insert custID");
			int cid=sc.nextInt();
			System.out.println("Insert jewId");
            int jid=sc.nextInt();
            System.out.println("Insert Rating");
			Float rat=sc.nextFloat();
			System.out.println("Insert Review");
            String rew=sc.next();
			pst=con.prepareStatement(str);
			pst.setInt(1, cid);
            pst.setInt(2, jid);
            pst.setFloat(1, rat);
            pst.setString(2, rew);
           
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
			String str="update Feedback set Review =? where CustId=?";
			pst=con.prepareStatement(str);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter custName");
			String Review=sc.next();
			System.out.println("Enter custId ");
			int CustId=sc.nextInt();
			pst.setString(1, Review);
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
	
	public void retrieve() {
		String query="Select Rating,Review from feedback where custId=?";
		try {
			pst=con.prepareStatement(query);
			rst=pst.executeQuery();
			System.out.println("Retrieved Data");
			while(rst.next()){
				System.out.println(rst.getFloat(1)+" : "+ rst.getString(2));
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
	
//	public void get() {
//		System.out.println("-----Feedback detail--------");
//		System.out.println(f.getCustId());
//		System.out.println(f.getJewId());
//		System.out.println(f.getRating());
//		System.out.println(f.getReview());
//	}
//	public void set() {
//		System.out.println("-----Enter Feedback Detail-----");
//		System.out.println("Id");
//		f.setJewId(sc.nextInt());
//		System.out.println("Rating");
//		f.setRating(sc.nextFloat());
//		System.out.println("Enter review");
//		f.setReview(sc.next());
//	}
	public Feedback getF() {
		return f;
	}
	public void setF(Feedback f) {
		this.f = f;
	}


	
}
