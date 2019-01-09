package com.criss.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criss.wang.entity.Employee;

@RestController
public class PropertyController {

	@Autowired
	private Employee employee;

	@GetMapping(value = "/name")
	public String getName() {

		return employee.getName();
	}

	@RequestMapping("/address")
    public List<String> getAddress() {
		System.out.println("kdfjdkj");
        return employee.getAddress();
    }

	@RequestMapping("/age")
	public int getAge() {
		return employee.getAge();
	}

    @RequestMapping("/phone")
    public String getNumber() {

        return employee.getPhone().getNumber();
    }
}
