package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="address", uniqueConstraints={@UniqueConstraint(columnNames={"address_id"})})
public class Address {

	public Address() {
		
	}
	public Address(int id, String doorNumber, String street, String city) {
		super();
		this.id = id;
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
	}

	@Id
    @Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name="doornumber")
    private String doorNumber;
     
    @Column(name="street")
    private String street;
     
    @Column(name="city")
    private String city; 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
