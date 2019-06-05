package com.momo.springboot.domain;

/**
 * @ClassName: com.momo.springboot.domain.User
 * @Description: TODO 
 * @author ibadboy
 * @date: 2018年6月27日 上午11:07:41
 */
public class User {
	private Long id;
	private String name;
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
