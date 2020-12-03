package com.bankapp.model.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "account_table")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	@NotEmpty(message = "name can't be left blank")
	private String name;
	private Double balance;
	@NotEmpty(message = "address can't be left blank")
	private String address;
	@NotEmpty(message = "phone can't be left blank")
	@Column(unique = true)
	private String phone;
	@NotEmpty(message = "email can't be left blank")
	@Column(unique = true)
	private String email;
	@NotEmpty(message = "aadharCard can't be left blank")
	@Column(unique = true)
	private String aadharCard;
	@Past
	@NotNull(message="birthDate can not be left blank")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@NotEmpty(message = "panNumber can't be left blank")
	@Column(unique = true)
	private String panNumber;
	@NotEmpty(message = "accountno can't be left blank")
	@Column(unique = true)
	private String accountno;
	@NotEmpty(message = "username can't be left blank")
	@Column(unique = true)
	private String username;
	@NotEmpty(message = "password can't be left blank")
	
	private String password;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Account() {

	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public Account(Integer accountId, String name, Double balance, String address, String phone, String email,
			String aadharCard, @Past @NotNull(message = "birthDate can not be left blank") Date birthDate,
			String panNumber, String accountno, String username, String password, AccountType accountType,
			AccountStatus accountStatus) {
		
		this.accountId = accountId;
		this.name = name;
		this.balance = balance;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.aadharCard = aadharCard;
		this.birthDate = birthDate;
		this.panNumber = panNumber;
		this.accountno = accountno;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}

	public Account(String name, Double balance, String address, String phone, String email, String aadharCard,
			@Past @NotNull(message = "birthDate can not be left blank") Date birthDate, String panNumber,
			String accountno, String username, String password, AccountType accountType, AccountStatus accountStatus) {
		
		this.name = name;
		this.balance = balance;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.aadharCard = aadharCard;
		this.birthDate = birthDate;
		this.panNumber = panNumber;
		this.accountno = accountno;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", aadharCard=");
		builder.append(aadharCard);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", panNumber=");
		builder.append(panNumber);
		builder.append(", accountno=");
		builder.append(accountno);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", accountStatus=");
		builder.append(accountStatus);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadharCard == null) ? 0 : aadharCard.hashCode());
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((accountno == null) ? 0 : accountno.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((panNumber == null) ? 0 : panNumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (aadharCard == null) {
			if (other.aadharCard != null)
				return false;
		} else if (!aadharCard.equals(other.aadharCard))
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (accountStatus != other.accountStatus)
			return false;
		if (accountType != other.accountType)
			return false;
		if (accountno == null) {
			if (other.accountno != null)
				return false;
		} else if (!accountno.equals(other.accountno))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (panNumber == null) {
			if (other.panNumber != null)
				return false;
		} else if (!panNumber.equals(other.panNumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

	
	
}
