package com.learn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_profiles")
public class UserProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="phone_number")
	@Size(max=15)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private Date dateOfBirth;
	
	@Size(max=100)
	private String address1;
	
	@Size(max=100)
	private String address2;
	
	@Size(max=100)
	private String street;
	
	@Size(max=100)
	private String city;
	
	@Size(max=100)
	private String state;
	
	@Size(max=100)
	private String country;
	
	@Column(name="zip_code")
	@Size(max=32)
	private String zipCode;
	
	// The Owner of the relationship contains the join column annotation
	@OneToOne(fetch=FetchType.LAZY,
			optional=false
			)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public UserProfile() {}

	public UserProfile(@Size(max = 15) String phoneNumber, Gender gender, Date dateOfBirth,
			@Size(max = 100) String address2, @Size(max = 100) String street, @Size(max = 100) String city,
			@Size(max = 100) String state, @Size(max = 100) String country, @Size(max = 32) String zipCode) {
		super();
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address2 = address2;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
