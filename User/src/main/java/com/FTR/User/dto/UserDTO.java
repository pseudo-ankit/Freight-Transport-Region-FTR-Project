package com.FTR.User.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;

import com.FTR.User.model.User;

public class UserDTO {
	
	private int userId;
	
	@NotNull(message = "{user.firstName.must")
	@Size(max = 20, message = "{user.firstName.invalid}")
	private String firstName;
	
	@NotNull(message = "{user.lastName.must}")
	@Size(max = 20, message = "{user.lastName.invalid}")
	private String lastName;
	
	@NotNull(message ="{user.email.must}")
	@Email(message = "{user.email.invalid}")
	private String email;
	
	@NotNull(message = "{user.phone.must}")
	@Min(value = 1000000000l, message = "{user.phone.invalid}")
	@Max(value = 9999999999l, message = "{user.phone.invalid}")
	private long mobileNumber;
	
	@NotNull(message = "{user.password.must}")
	@Size(max = 15, min = 7, message = "{user.password.invalidsize}")
	@Pattern(regexp = "^(?=.*[!@#$%^&+=]).{7,15}", message = "{user.password.invalid}")
	private String password;
	
	@NotNull(message = "{user.nationality.must}")
	@Size(max = 20, message = "{user.nationality.invalidsize}")
	private String nationality;
	
	@NotNull(message = "{user.passportNumber.must}")
	@Size(max = 12, min = 7, message = "{user.passportNumber.invalid}")
	private String passportNumber;
	
	@NotNull(message = "{user.permanentAddress.must}")
	@Size(max = 200, message = "{user.permanentAddress.invalid}")
	private String permanentAddress;
	
	@NotNull(message = "{user.officeAddress.must}")
	@Size(max = 200, message = "{user.officeAddress.invalid}")
	private String officeAddress;
	
	@NotNull(message = "{user.personalIdentificationNumber.must}")
	@Min(value = 100000000000l, message = "{user.personalIdentificationNumber.invalid}")
	@Max(value = 999999999999l, message = "{user.personalIdentificationNumber.invalid}")
	private String personalIdentificationNumber;

	public UserDTO() {
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

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", nationality=" + nationality + ", passportNumber="
				+ passportNumber + ", permanentAddress=" + permanentAddress + ", officeAddress=" + officeAddress
				+ ", personalIdentificationNumber=" + personalIdentificationNumber + "]";
	}
	
	public static User createEntity(UserDTO dto) {
		ModelMapper mapper = new ModelMapper();
		User user = mapper.map(dto, User.class);
		return user;
	}

}
