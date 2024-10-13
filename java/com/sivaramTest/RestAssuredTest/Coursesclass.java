package com.sivaramTest.RestAssuredTest;

import java.util.List;

public class Coursesclass {

	
	private Mobile mobile;
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	public Webautomation getWebautomation() {
		return webautomation;
	}
	public void setWebautomation(Webautomation webautomation) {
		this.webautomation = webautomation;
	}
	public Api getApi() {
		return api;
	}
	public void setApi(Api api) {
		this.api = api;
	}
	private List<Webautomation> webautomation;
	private Api api; 
}
