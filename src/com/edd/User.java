package com.edd;

public class User {

	private String name;
	private String password;
	private String email;

	public User() {

	}

	public User(String nom, String pwd, String email) {
		this.name = nom;
		this.password = pwd;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}


	protected void setName(String name) {
		this.name = name;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
	protected void setEmail(String email) {
		this.email = email;
	}

}
