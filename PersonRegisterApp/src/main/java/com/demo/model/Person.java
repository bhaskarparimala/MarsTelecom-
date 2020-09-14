package com.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	@Column(name="person_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(name="first_name")
	private String firstName;
	public Person() {
		
	}
	public Person(Integer pid, String firstName, String lastName, String email, Address address) {
		super();
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	public String getEmail() {
		return email;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressid")
	private Address address;
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	
	public Integer getPid() {
		return pid;
	}





	public void setPid(Integer pid) {
		this.pid = pid;
	}





	@Override
	public String toString() {
		return "Person [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + "]"
				;
	}





	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
