package com.tianmao.market.bean;
/**
 * �˿�
 * @author Administrator
 *
 */
public class Customer {

	private String id;
	private String name;
	private String number;
	private int costAccount;

	public Customer(){};
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCostAccount() {
		return costAccount;
	}

	public void setCostAccount(int costAccount) {
		this.costAccount = costAccount;
	}

}
