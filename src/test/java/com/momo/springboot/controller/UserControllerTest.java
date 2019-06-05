package com.momo.springboot.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@Slf4j
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	// 测试UserController
	RequestBuilder request = null;

	@Test
	public void userTest() throws Exception {
		// 1、get查一下user列表，应该为空
		request = get("/users/").accept(MediaType.APPLICATION_JSON_VALUE);

		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

		String responseString = mvc.perform(get("/users/") // 请求的url,请求的方法是get
				.contentType(MediaType.APPLICATION_JSON_VALUE) // 数据的格式
				//.param("pcode", "root") // 添加参数
		).andExpect(status().isOk()) // 返回的状态是200
				.andDo(print()) // 打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
		log.info("--------返回的json = " + responseString);
		
		// 2、post提交一个user
			request = post("/users/")
					.param("id", "1")
					.param("name", "测试大师")
					.param("age", "20");
			mvc.perform(request)
//						.andDo(MockMvcResultHandlers.print())
					.andExpect(content().string(equalTo("success")));

			// 3、get获取user列表，应该有刚才插入的数据
			request = get("/users/");
			mvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

			// 4、put修改id为1的user
			request = put("/users/1")
					.param("name", "测试终极大师")
					.param("age", "30");
			mvc.perform(request)
					.andExpect(content().string(equalTo("success")));

			// 5、get一个id为1的user
			request = get("/users/1");
			mvc.perform(request)
					.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

			// 6、del删除id为1的user
			request = delete("/users/1");
			mvc.perform(request)
					.andExpect(content().string(equalTo("success")));

			// 7、get查一下user列表，应该为空
			request = get("/users/");
			mvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().string(equalTo("[]")));
	}
}
