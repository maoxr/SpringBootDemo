package com.momo.springboot.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {
	@Value("${com.momo.springbootdemo.name}")
	private String name;

	@Value("${com.momo.springbootdemo.title}")
	private String title;
	@Value("${com.momo.springbootdemo.desc}")
	private String desc;
	@Value("${com.momo.springbootdemo.value}")
	private String value;
	@Value("${com.momo.springbootdemo.number}")
	private Integer number;
	@Value("${com.momo.springbootdemo.bignumber}")
	private Long bigNumber;
	@Value("${com.momo.springbootdemo.test1}")
	private Integer test1;
	@Value("${com.momo.springbootdemo.test2}")
	private Integer test2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getBigNumber() {
		return bigNumber;
	}

	public void setBigNumber(Long bigNumber) {
		this.bigNumber = bigNumber;
	}

	public Integer getTest1() {
		return test1;
	}

	public void setTest1(Integer test1) {
		this.test1 = test1;
	}

	public Integer getTest2() {
		return test2;
	}

	public void setTest2(Integer test2) {
		this.test2 = test2;
	}

	@Override
	public String toString() {
		return "PropertiesBean [name=" + name + ", title=" + title + ", desc=" + desc + ", value=" + value + ", number="
				+ number + ", bigNumber=" + bigNumber + ", test1=" + test1 + ", test2=" + test2 + "]";
	}
	
}
