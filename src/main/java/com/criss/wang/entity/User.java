package com.criss.wang.entity;

import com.criss.wang.annonation.Init;
import com.criss.wang.annonation.Validate;

public class User {

	@Init
	private String name;

	private String age;

	private String sex;

	@Validate(min = 2, max = 10)
	private String nickName;

	@Validate(isNotNull = false)
	private String mobile;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public String getAge() {
		return this.age;
	}

	public String getSex() {
		return this.sex;
	}

	@Init
	public void setName(String name) {
		this.name = name;
	}

	@Init(value = "28")
	public void setAge(String age) {
		this.age = age;
	}

	@Init(value = "男")
	public void setSex(String sex) {
		this.sex = sex;
	}

}
