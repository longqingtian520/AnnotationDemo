package com.criss.wang.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.criss.wang.annonation.Init;
import com.criss.wang.annonation.Validate;
import com.criss.wang.entity.User;

public class UserCheck {

	public static boolean check(User user) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		if(user == null) {
			System.out.println("校验对象不能为空");
			return false;
		}

		Field[] fields = User.class.getDeclaredFields();

		System.out.println(fields.length);

		for(Field field : fields) {
			if(field.isAnnotationPresent(Init.class) && field.getName().equals("name")) {
				field.setAccessible(true);
				Init init = field.getAnnotation(Init.class);
				field.set(user, init.value());
			}

			if(field.getName().equals("name")) {
				field.setAccessible(true);
				System.out.println(user.getName());
			}

			if(field.isAnnotationPresent(Validate.class)) {
				Validate validate = field.getAnnotation(Validate.class);
				if (field.getName().equals("nickName"))
                {
                    if (user.getNickName() == null)
                    {
                        if (validate.isNotNull())
                        {
                            System.out.println("！！昵称可空校验不通过：不可为空！！");
                            return false;
                        }
                        else
                        {
                            System.out.println("昵称可空校验通过：可以为空");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("昵称可空校验通过");
                    }

                    if (user.getNickName().length() < validate.min())
                    {
                        System.out.println("！！昵称最小长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("昵称最小长度校验通过");
                    }

                    if (user.getNickName().length() > validate.max())
                    {
                        System.out.println("！！昵称最大长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("昵称最大长度校验通过");
                    }
                }
			}
		}

		return true;
	}
}
