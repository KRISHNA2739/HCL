package customerdetails.model;
import java.util.*;
public interface CustomerDao {
	public void addCustomer(Customer customer);
	public void delCustomer(int id);
	public void updateCustomerPurchaseCapacity(int id, int purchaseCapacity);
	public List<Customer> getAllCustomer();
	public Optional<Customer> getSelectedCustomerByid(int id);
	public Optional<Customer> getSelectedCustomerByname(String name);
}
