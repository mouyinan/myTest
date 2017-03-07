package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.food.model.Customer;
@Service @Transactional
public class CustomerDao {
	@Resource SessionFactory factory;
	public void AddCustomer(Customer customer)throws Exception{
		Session s = factory.getCurrentSession();
    	s.save(customer);
		
	}
	public void DeleteCustomer(int customerid)throws Exception{
		Session s = factory.getCurrentSession(); 
        Object customer = s.load(Customer.class, customerid);
        s.delete(customer);
		}
	 public void UpdateCustomer(Customer customer) throws Exception {
	        Session s = factory.getCurrentSession();
	        s.update(customer);
	    }
	 public Customer GetCustomerById(int customerid) {
	        Session s = factory.getCurrentSession();
	        Customer customer= (Customer)s.get(Customer.class, customerid);
	        return customer;
	        }
	 @Transactional(propagation=Propagation.NOT_SUPPORTED)
	    public ArrayList<Customer> QueryAllCustomers() {
	        Session s = factory.getCurrentSession();
	        String hql = "From Customer";//等同于select*from food;
	        Query q = s.createQuery(hql);
	        List customerList = q.list();//把查询的结果放入一个List中，List中的每个数据就是一个food对象。
	        return (ArrayList<Customer>) customerList;
	    }
	 @Transactional(propagation=Propagation.NOT_SUPPORTED)
	    public ArrayList<Customer> queryCustomerInfo(String name) { 
	    	Session s = factory.getCurrentSession();
	    	List customerList;
	    	String hql = "From Customer customer where 1=1";//防止输入的查询的条件为空时报错，如果不写查询条件，相当于是全表查询。
	    	if(!name.equals("")){
	    		hql = hql + " and customer.name = '"+ name +"'";//判断是否与传进来的用户名是否一致。
	    	
	    	Query q = s.createQuery(hql);
	         customerList = q.list();
	 } 
	    	else{
	    		
		 customerList=null;
	    }
	 return (ArrayList<Customer>) customerList;
}
}

