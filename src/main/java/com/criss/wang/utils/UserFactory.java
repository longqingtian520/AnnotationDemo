package com.criss.wang.utils;

import java.lang.reflect.Method;

import com.criss.wang.annonation.Init;
import com.criss.wang.entity.User;

public class UserFactory {

	public static User create() {
		User user = new User();
		Method[] methods = User.class.getMethods();
		try {
			for(Method method : methods) {
				// 如果此方法有注解，就把注解里面的数据赋值到User对象
				if(method.isAnnotationPresent(Init.class)) {
					Init init = method.getAnnotation(Init.class);
					method.invoke(user, init.value());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}


}
