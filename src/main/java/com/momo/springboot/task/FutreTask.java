/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot.task 
 * @author: ibadboy   
 * @date: 2018年7月3日 上午9:01:52 
 */
package com.momo.springboot.task;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: com.momo.springboot.task.FutreTask
 * @Description: TODO
 * @author ibadboy
 * @date: 2018年7月3日 上午9:01:52
 */
@Slf4j
@Component
public class FutreTask {
	public static Random random = new Random();

	@Async("taskExecutor")
	public Future<String> run() throws Exception {
		long sleep = random.nextInt(10000);
		log.info("开始任务，需耗时：" + sleep + "毫秒");
		Thread.sleep(sleep);
		log.info("完成任务");
		return new AsyncResult<>("test");
	}
}
