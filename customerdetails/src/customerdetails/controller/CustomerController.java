package customerdetails.controller;
import java.sql.Connection;
import java.util.*;
import java.util.function.Supplier;

import customerdetails.exception.CustomerNotFoundException;
import customerdetails.model.ConnectionFactory;
import customerdetails.model.Customer;
import customerdetails.model.CustomerDao;
import customerdetails.model.CustomerDaoImpl;

import java.util.*;
public class CustomerController {
	public static void main(String[] args) {
		
		Connection connection=ConnectionFactory.GetConnection();
		if(connection!=null)
			System.out.println("success");
		
		
	
		
		CustomerDao dao=new CustomerDaoImpl();
		
		
		List<Customer> customer=dao.getAllCustomer();
		customer.forEach(n-> System.out.println(n));
		
		
		
		dao.delCustomer(1);
		
		
		
		dao.updateCustomerPurchaseCapacity(2,500);
		System.out.println("updated.....");
		
	
	
		
		Customer customer1=dao.getSelectedCustomerByid(2).orElseThrow(()-> new CustomerNotFoundException("Customer not found"));
	System.out.println(customer1);
	
		
	Customer customer2=dao.getSelectedCustomerByname("raj").orElseThrow(()-> new CustomerNotFoundException("Customer not found"));
		
	System.out.println(customer2);
		
	
	Customer customer3=new Customer("kaj", "988523", "kaj@gmail.com", new Date(), 150);
	dao.addCustomer(customer3);

	}
	

	
}
