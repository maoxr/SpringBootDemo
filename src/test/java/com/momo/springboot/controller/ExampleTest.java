package com.momo.springboot.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.momo.springboot.common.PropertiesBean;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleTest {
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	PropertiesBean properties;
	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		System.out.println("-------->>> " + properties.getName());
		System.out.println("----body---->>> " + body);
		System.out.println("----properties---->>> " + properties);
	}
}
