package com.cs.myapps.lenaDenaRozana.beans;


import org.ektorp.support.CouchDbDocument;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class Partner extends CouchDbDocument{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@NotEmpty(message="Cannot be emtpy")
	@Size(min=4,max=20,message="Size4-20")
	private String id;	
	@NotEmpty(message="Cannot be emtpy")
	@Size(min=4,max=20,message="Size4-20")
	private String fname;	
	@NotEmpty(message="Cannot be emtpy")
	@Size(min=4,max=20,message="Size4-20")
	private String lname;
	@NotEmpty(message="Cannot be emtpy")
	@Size(min=4,max=20,message="Size4-20")
	private String address;
	private String email;
	
	@NotEmpty(message="Cannot be emtpy")
	@Size(min=10,max=10,message="Size4-20")
	@Pattern(regexp = "^[0-9]*$", message="Valid number")
	private String mobileNo;
	
	
	private String altMobileNo;	
	
	

    public String getId() {
            return id;
    }

    public void setId(String s) {
            id = s;
    }

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAltMobileNo() {
		return altMobileNo;
	}
	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}


}
