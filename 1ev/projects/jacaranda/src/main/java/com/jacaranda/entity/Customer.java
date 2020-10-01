package com.jacaranda.entity;

import java.io.Serializable;
import java.time.LocalDate;

//public class Customer implements Comparable<Customer> {
public class Customer implements Serializable {

	private String name;
	private String surname;
	private LocalDate birthdate;
	private String address;
	private String city;
	private String dni;
	private String country;
	private String mobileNumber;
	private String gender;
	
	/**
	 * Customer entity
	 * @author raul
	 * @param name
	 * @param surname
	 * @param city
	 * @param dni
	 */
	public Customer() {
	}
	
	public Customer(String name, String surname, String city, String dni) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.dni = dni;
	}
	
	
	public Customer(String name, String surname, LocalDate birthdate, String address, String city, String dni,
			String country, String mobileNumber, String gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.dni = dni;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", address=" + address
				+ ", city=" + city + ", dni=" + dni + ", country=" + country + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + "]";
	}


	
	
}
