package com.tmattila.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ChaCreation {

	@NotNull(message="You have to specify name for the character")
	private String name;

	@NotNull(message="Select sex for the character")
	private String sex;

	@NotNull(message="What type of adventurer are you?")
	private String type;

	@NotNull(message="Your starting wealth can't be zero")
	@Min(value=0, message="Minimum value is 0")
	@Max(value=5000, message="Maximum value is 5000")
	private int wealth;

	public ChaCreation() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(Object selection) {
		this.sex = (String) selection;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWealth() {
		return wealth;
	}

	public void setWealth(int wealth) {
		this.wealth = wealth;
	}

	@Override
	public String toString() {
		return "ChaCreation [name=" + name + ", sex=" + sex + ", type=" + type + ", wealth=" + wealth + "]";
	}
	
}
