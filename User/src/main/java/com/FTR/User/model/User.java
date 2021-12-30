package com.FTR.User.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.modelmapper.ModelMapper;

import com.FTR.User.dto.UserDTO;

@Entity
@Table(name = "ftr_user")
public class User {
	
	@Id
	@GenericGenerator(strategy = "com.FTR.User.utils.UserIdGenerator", 
					  name = "userGenerator")
	@GeneratedValue(generator = "userGenerator")
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "mobile_number")
	private long mobileNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "office_address")
	private String officeAddress;
	
	@Column(name = "personal_identification_number")
	private long personalIdentificationNumber;

	public User() {
		super();
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public long getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", nationality=" + nationality
				+ ", passportNumber=" + passportNumber + ", permanentAddress=" + permanentAddress + ", officeAddress="
				+ officeAddress + ", personalIdentificationNumber=" + personalIdentificationNumber + "]";
	}
	
	public static UserDTO createDTO(User user) {
		ModelMapper mapper = new ModelMapper();
		UserDTO dto = mapper.map(user, UserDTO.class);
		return dto;
	}
}
