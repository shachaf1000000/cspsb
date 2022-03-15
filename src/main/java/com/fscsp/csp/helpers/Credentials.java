package com.fscsp.csp.helpers;

import com.fscsp.csp.maneger.ClientType;

public class Credentials {

	private String email;
	private String password;
	private String role;
	public Credentials(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public ClientType getRole() {
		switch (role) {
		case "ADMIN":
			return ClientType.ADMIN;
		case "COMPANY":
			return ClientType.COMPANY;
		case "CUSTOMER":
			return ClientType.CUSTOMER;
		default:
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Credentials other = (Credentials) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Credentials [email=" + email + ", pwd=" + password + ", role=" + role + "]";
	}
	
	
}
