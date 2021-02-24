package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Customer;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Jewellery;
import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Order;
import com.coforge.JASproject.dao.OrderDao;
import com.coforge.JASproject.database.DbConnect;

public class OrderDaoImpl implements OrderDao{

	 Order o;
	 Scanner sc;
	 Connection con;
	 PreparedStatement pst;
		public OrderDaoImpl(Customer c,Jewellery j){
			o=new Order(c, j);
			sc=new Scanner(System.in);
			try {
				con=DbConnect.dbConnect();
				System.out.println("DataBase Connected");
				}catch(Exception e) {
					e.printStackTrace();
				}
			
		}
		
		public boolean checking(int custId,int jewId) {
			boolean flag=false;
			try {
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
			System.out.println("---------Enter Order Details------");
			int flag=0,i=0;
			
			do {
				System.out.println("Customer id ");
				int custId=sc.nextInt();
				System.out.println("Jewelley id ");
				int jewId=sc.nextInt();
				if(! checking(custId,jewId)) {
					flag=1;
				}
				else {
					flag=0;
					try {
						System.out.println("Order id ");
						int oId=sc.nextInt();
						System.out.println("Date");
						String d=sc.next();
						Date date=Date.valueOf(d);
					pst=con.prepareStatement("insert into Order_Jew values(?,?,?,?)");
					pst.setInt(1, oId);
					pst.setInt(2, custId);
					pst.setInt(3, jewId);
					pst.setDate(4, date);
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
		public void update() {
			System.out.println("What you want to update 1.Customer id 2.Jewellery Id ");
			int ch=sc.nextInt();
			String query="";
			switch(ch) {
				case 1:	
			query="update Order_Jew set custId=? where orderId=?";
			try {
			pst=con.prepareStatement(query);
			System.out.println("ENter new Customer ID");
			pst.setInt(1, sc.nextInt());
			System.out.println("ENter new Order ID");
			pst.setInt(2, sc.nextInt());
			if(	pst.executeUpdate()>0) {
				System.out.println("SUCESSFULLY Updated");
		    }
		    else {
		    	System.out.println("id  not exist");
		    }
			}catch(Exception e) {
				System.out.println(e);
			}
			break;
			case 2:		
				 query="update Order_Jew set JewId=? where orderId=?";
				 try {
				pst=con.prepareStatement(query);
				pst.setInt(1, sc.nextInt());
				pst.setInt(2, sc.nextInt());
				if(	pst.executeUpdate()>0) {
					System.out.println("SUCESSFULLY Updated");
			    }
			    else {
			    	System.out.println("id  not exist");
			    }
				 }catch(Exception e) {
					 System.out.println(e);
				 }
				break;
			
			default:
				System.out.println("Invalid Choice");
					
			}
			
		}
		public void delete() {
			System.out.println("Delete Operation");
			String query="delete from Order_Jew where orderid=?";
			System.out.println("Enter Order Id for which you want to delete data");
			int oid=sc.nextInt();
			try {
				pst=con.prepareStatement(query);
				pst.setInt(1, oid);
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
			System.out.println("Retriving Operation");
			ResultSet rs=null;
			String query="select * from Order_Jew";
			try {
				pst=con.prepareStatement(query);
				rs=pst.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("OrderId")+":"+rs.getInt("custId")+":"+rs.getInt("jewId")+":"+rs.getDate("Order_Date"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public void set() {
			System.out.println("Please Enter Order Detail");
			Scanner sc=new Scanner(System.in);
		o.setCustId();	
		o.setJewId();
		System.out.println("Order id");
		o.setOrderId(sc.nextInt());
		System.out.println("order date");
		o.setOrder_Date(sc.next());
		}
		public void get() {
			System.out.println("----Order detail----");
			System.out.println("Customer Id:"+o.getCustId());
			
			System.out.println("Jewellery Id:"+o.getJewId());
			System.out.println("Order Date:"+o.getOrder_Date());
			System.out.println("Order Id:"+o.getOrderId());
			
		}
		public Order getO() {
			return o;
		}
		public void setO(Order o) {
			this.o = o;
		}
	
}
