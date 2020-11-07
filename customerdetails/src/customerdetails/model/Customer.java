package customerdetails.model;

import java.util.Date;
//DTO
public class Customer {
	private int id;
	private String name;
	private String phoneno;
	private String email;
	private Date birthdate;
	private int purchaseCapacity;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public int getPurchaseCapacity() {
		return purchaseCapacity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setPurchaseCapacity(int purchaseCapacity) {
		this.purchaseCapacity = purchaseCapacity;
	}

	public Customer(int id, String name, String phoneno, String email, Date birthdate, int purchaseCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.birthdate = birthdate;
		this.purchaseCapacity = purchaseCapacity;
	}
	

	public Customer(String name, String phoneno, String email, Date birthdate, int purchaseCapacity) {
	
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.birthdate = birthdate;
		this.purchaseCapacity = purchaseCapacity;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phoneno=");
		builder.append(phoneno);
		builder.append(", email=");
		builder.append(email);
		builder.append(", birthdate=");
		builder.append(birthdate);
		builder.append(", purchaseCapacity=");
		builder.append(purchaseCapacity);
		builder.append("]");
		return builder.toString();
	}

	
	}


