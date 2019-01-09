package com.criss.wang.process;

import com.criss.wang.entity.User;
import com.criss.wang.utils.UserFactory;

public class Test1 {

	public static void main(String[] args) {
		User user = UserFactory.create();
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.getSex());



	}
}
