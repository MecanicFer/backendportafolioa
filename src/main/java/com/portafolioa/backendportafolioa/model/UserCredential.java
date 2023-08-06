package com.portafolioa.backendportafolioa.model;

public class UserCredential {

	private String username;
	private String Password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public UserCredential(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}

	public UserCredential() {

	}

	@Override
	public String toString() {
		return "UserCredential [username=" + username + ", Password=" + Password + "]";
	}

}
