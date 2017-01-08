package com.cs.myapps.lenaDenaRozana.beans;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	
	@NotEmpty(message = "Please enter your Id.")
	private String id;
	
	@NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
  	private String password;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
