package com.bharat.policy;

import java.time.LocalDate;

public class Policy {

	private int policyId;
	private String name;
	private int age;
	private LocalDate expiresOn;

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(LocalDate expiresOn) {
		this.expiresOn = expiresOn;
	}
}
