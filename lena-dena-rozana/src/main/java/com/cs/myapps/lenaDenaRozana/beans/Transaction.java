package com.cs.myapps.lenaDenaRozana.beans;

import javax.validation.constraints.Pattern;

import java.util.StringTokenizer;

import javax.validation.constraints.Min;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.ektorp.support.CouchDbDocument;
import org.hibernate.validator.constraints.NotEmpty;


public class Transaction extends CouchDbDocument{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String partnerId;
	
	//private enum Type {CREDIT,DEBIT};
	
	private String type;
	
	private String name;
	
	@Pattern(regexp = "^[0-9]*$", message="Valid number")
	private String mobileNo;
	
	@Min(1)
	private int amount;
	
	private boolean settled;
	
	@NotEmpty
	private int[] date;
	
	@JsonIgnore
	private String tempDateString;

	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return this.type;
	}

	
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isSettled() {
		return settled;
	}

	public void setSettled(boolean settled) {
		this.settled = settled;
	}

	public int[] getDate() {
		return date;
	}
	
	public void setDate(int[] date)
	{
		this.date = date;
	}

	public void setDate(String date, String df) {
		StringTokenizer stokens = new StringTokenizer(date,"-");
		int[] dt = new int[3];
		for(int ctr=0;stokens.hasMoreTokens();ctr++)
		{
			dt[ctr]=Integer.parseInt(stokens.nextToken());
		}
		this.date = dt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public String getTempDateString() {
		int year=1970;
		int month = 1;
		int day = 1;
		if(this.getDate() != null)
		{
		year = this.getDate()[0];
		month = this.getDate()[1];
		day = this.getDate()[2];
		
		}
		return year+"-"+month+"-"+day;
		
		//return tempDateString;
	}
	
	@JsonIgnore
	public void setTempDateString(String tempDateString) {
		
		StringTokenizer stokens = new StringTokenizer(tempDateString,"-");
		int[] dt = new int[3];
		for(int ctr=0;stokens.hasMoreTokens();ctr++)
		{
			dt[ctr]=Integer.parseInt(stokens.nextToken());
		}
		this.setDate(dt);
		
	}


}
