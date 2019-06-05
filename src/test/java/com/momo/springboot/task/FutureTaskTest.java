/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot.task 
 * @author: ibadboy   
 * @date: 2018年7月3日 上午9:30:29 
 */
package com.momo.springboot.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: com.momo.springboot.task.FutureTaskTest
 * @Description: TODO
 * @author ibadboy
 * @date: 2018年7月3日 上午9:30:29
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FutureTaskTest {
	@Autowired
	private FutreTask task;

	@Test
	public void test() {
		Future<String> futureResult = null;
		try {
			futureResult = task.run();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = null;
		try {
			result = futureResult.get(2, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("开始取消任务" );
			futureResult.cancel(true);
			log.info("任务是否取消成功-》 " + futureResult.isDone() + "  -  " + futureResult.isCancelled());
		}
		log.info("----> " + result);
	}
}
