package com.coforge.JASproject.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.JASproject.JEW_AUTO_SYSTEM.bean.Jewellery;
import com.coforge.JASproject.dao.JewelleryDao;
import com.coforge.JASproject.database.DbConnect;

public class JewelleryDaoImpl implements JewelleryDao{

	Jewellery j;
	Scanner sc;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;
	
	public JewelleryDaoImpl(){
		j=new Jewellery();
		sc=new Scanner(System.in);
		
	}
	
	public void add() {
		System.out.println("---------Enter Jewellery Details------");
		
		try {
			con=DbConnect.dbConnect();
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int i=0;
		
		do {
			System.out.println("Enter Jewellery Id");
			int JewId=sc.nextInt();
			
				
				System.out.println("Jewellery Name");
				String JewName=sc.next();
				
				System.out.println("Jewellery Type");
				String JewType=sc.next();
				
				System.out.println("Jewellery weight");
				float JewWeight=sc.nextFloat();
				
				System.out.println("Jewelery Designer Name");
				String JewDesigner=sc.next();
				
				System.out.println("Jewellery Carat");
				int JewKarat=sc.nextInt();
				
				
				System.out.println("Jewellery Price");
				float JewPrice=sc.nextFloat();
			
				
				try {
					
				pst=con.prepareStatement("insert into Jewellery values(?,?,?,?,?,?,?)");
				pst.setInt(1, JewId);
				pst.setString(2, JewName);
				pst.setString(3,JewType);
				pst.setFloat(4,JewWeight);
				pst.setString(5,JewDesigner);
				pst.setInt(6,JewKarat);
				pst.setFloat(7,JewPrice);
				pst.executeUpdate();
				System.out.println("---");
				System.out.println("do you want to insert more 1 for yes 0 fo no");
				 i=sc.nextInt();
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Data Already Exist");
				}
			
				}while(i==1);
		
		
	}
	public void update() {
		System.out.println("What you want to update:"
				+ " 1.Name"
				+ " 2.Jewellery Type "
				+ "3.Jewellery Designer "
				+ "4 Jewellery Price "
				+ "5.Jewellery Weight");
		int ch=sc.nextInt();
		String query="";
		switch(ch) {
			case 1:	
		query="update jewellery set JewName=? where JewId=?";
		try {
		pst=con.prepareStatement(query);
		pst.setString(1, sc.next());
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
			 query="update jewellery set JewType=? where JewId=?";
			 try {
			pst=con.prepareStatement(query);
			pst.setString(1, sc.next());
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
		case 3:		
			 query="update jewellery set JewDesigner=? where JewId=?";
			 try {
			pst=con.prepareStatement(query);
			pst.setString(1, sc.next());
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
		case 4:		
			 query="update jewellery set Jewprice=? where JewId=?";
			 try {
			pst=con.prepareStatement(query);
			pst.setFloat(1, sc.nextFloat());
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
		case 5:		
			 query="update jewellery set JewWeight=? where JewId=?";
			 try {
			pst=con.prepareStatement(query);
			pst.setFloat(1, sc.nextFloat());
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
		String query="delete from jewellery where JewId=?";
		System.out.println("Enter Jewellery Id for which you want to delete data");
		int id=sc.nextInt();
		try {
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
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
		String query="select * from jewellery";
		try {
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("JewId")+":"+rs.getString("Jewname")+":"+rs.getString("JewType")+":"+rs.getFloat("JewWeight")+":"+rs.getString("JewDesigner")+":"+rs.getInt("Jewkarat")+":"+rs.getFloat("JewPrice"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

//	public void set() {
//		System.out.println("-------Enter Jewellery ------");
//		System.out.println("Enter Jewellery iD");
//		System.out.println("ID");
//		j.setJewId(sc.nextInt());
//		System.out.println("JewName");
//		j.setJewName(sc.next());
//		System.out.println("Jew Designer");
//		j.setJewDesigner(sc.next());
//		sc.next();
//		System.out.println("Carat");
//		j.setJewKarat(sc.nextInt());
//		System.out.println("Price");
//		j.setJewPrice(sc.nextFloat());
//		System.out.println("Weight");
//		j.setJewWeight(sc.nextFloat());
//		System.out.println("Jew Type");
//		j.setJewType(sc.next());
//		
//		
//	}
//	public void get() {
//		System.out.println("------Jewellery Details----------");
//		System.out.println(j.getJewId());
//		System.out.println(j.getJewName());
//		System.out.println(j.getJewKarat());
//		System.out.println(j.getJewPrice());
//		System.out.println(j.getJewWeight());
//		System.out.println(j.getJewType());
//		System.out.println(j.getJewDesigner());
//		
//	}
	public Jewellery getJ() {
		return j;
	}

}
