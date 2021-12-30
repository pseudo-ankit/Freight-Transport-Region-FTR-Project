package com.FTR.User.dto;

import javax.validation.constraints.NotNull;

public class LoginDTO {
	
	@NotNull(message="{user.login.fail}")
	private int userId;
	@NotNull(message="{user.login.fail}")
	private String password;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", password=" + password + "]";
	}
}
