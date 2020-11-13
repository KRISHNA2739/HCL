package customerdetails.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import customerdetails.exception.CustomerNotFoundException;
import customerdetails.exception.DataAccessException;



public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public CustomerDaoImpl() {
		connection = ConnectionFactory.GetConnection();
	}

	@Override
	public void addCustomer(Customer customer) {
//	 id;name;
//		 phoneno;
//		email;
//		 birthdate;
//		purchaseCapacity;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement
					("insert into customer(name, phoneno, email, birthdate, purchaseCapacity) values (?,?,?,?,?)");
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPhoneno());
			pstmt.setString(3, customer.getEmail());
			pstmt.setDate(4, (java.sql.Date) new Date(customer.getBirthdate().getTime()));
			pstmt.setInt(5, customer.getPurchaseCapacity());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}

	}

	@Override
	public void delCustomer(int id) {
		Customer customer=getSelectedCustomerByid(id).orElseThrow
				(()-> new CustomerNotFoundException("customer with id:"+ id+" is not fund"));
	
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("delete from customer where id=?");
			pstmt.setInt(1,id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}

	}

	@Override
	public void updateCustomerPurchaseCapacity(int id, int purchaseCapacity) {
		Customer customer=getSelectedCustomerByid(id).orElseThrow
				(()-> new CustomerNotFoundException("customer with id:"+ id+" is not fund"));
	
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("update  set purchaseCapacity=? where id=?");
			pstmt.setInt(1, purchaseCapacity);
			pstmt.setInt(2,id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
	
		List<Customer> customers = new ArrayList<>();
		Customer customer = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");

			while (rs.next()) {
				
				
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phoneno"), rs.getString("email"),
						rs.getDate("birthdate"), rs.getInt("purchaseCapacity"));

				customers.add(customer);
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc issue", e);
		}

		return customers;
	}

	@Override
	public Optional<Customer> getSelectedCustomerByid(int id) {
	

		Customer customer = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from customer where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(id, rs.getString("name"), rs.getString("phoneno"), rs.getString("email"),
						rs.getDate("birthdate"), rs.getInt("purchaseCapacity"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
		return Optional.ofNullable(customer);
	}

	@Override
	public Optional<Customer> getSelectedCustomerByname(String name) {
		Customer customer = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from customer where name=?");
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phoneno"), rs.getString("email"),
						rs.getDate("birthdate"), rs.getInt("purchaseCapacity"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
		return Optional.ofNullable(customer);
	}

}
