package com.coforge.JASproject.JEW_AUTO_SYSTEM;

import com.coforge.JASproject.serviceImpl.BillServiceImpl;
import com.coforge.JASproject.serviceImpl.CartServiceImpl;
import com.coforge.JASproject.serviceImpl.CustomerServiceImpl;
import com.coforge.JASproject.serviceImpl.JewelleryServiceImpl;
import com.coforge.JASproject.serviceImpl.OrderServiceImpl;
import com.coforge.JASproject.serviceImpl.PaymentServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	/*Customer c[]=new Customer[5];
        CustomerDao cd=new CustomerDao();
        cd.set();
        JewelleryDao jd=new JewelleryDao();
        jd.set();
        System.out.println("Order");
        OrderDao od=new OrderDao(cd.getC(),jd.getJ());
        od.set();
        System.out.println("------------OUTPUT-----------");
        od.get();
        System.out.println("------Cart-------");
        CartDao cart=new CartDao(cd.getC(),jd.getJ());
        cart.set();
        cart.get();
        System.out.println("----Payment-------");
        PaymentDao p=new PaymentDao(od.getO());
        p.set();
        p.get();
        System.out.println("--------Bill-------");
        BillDao bd=new BillDao(p.getP());
        bd.set();
        bd.get();
        
        
        */
    	CustomerServiceImpl cs=new CustomerServiceImpl();
    	cs.add();
    	cs.update();
    	cs.delete();
    	cs.retrieve();
        JewelleryServiceImpl js=new JewelleryServiceImpl();
        js.add();
        js.update();
        js.delete();
        js.retrieve();
        OrderServiceImpl os=new OrderServiceImpl(cs,js);
        os.add();
        os.update();
        os.delete();
        os.retrieve();
        CartServiceImpl cart=new CartServiceImpl(cs,js);
        cart.add();
        cart.delete();
        cart.retrieve();
	    PaymentServiceImpl ps=new PaymentServiceImpl(os);
	    ps.add();
        ps.update();
        ps.delete();
        ps.retrieve();
        BillServiceImpl bs=new BillServiceImpl(ps);
        bs.add();
        bs.delete();
        bs.retrieve();
        
    }
}
