package com.criss.wang.process;

import com.criss.wang.entity.User;
import com.criss.wang.utils.UserCheck;

public class Test2 {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		User user = new User();

		user.setNickName("kdfdfdfdfd");
		user.setMobile("1234");

		System.out.println(UserCheck.check(user));
	}
}
