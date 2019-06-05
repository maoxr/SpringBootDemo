/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot.task 
 * @author: ibadboy   
 * @date: 2018年7月3日 上午8:47:36 
 */
package com.momo.springboot.task;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @ClassName: com.momo.springboot.task.TaskPoolConfig
 * @Description: 线程池，
 * @author ibadboy
 * @date: 2018年7月3日 上午8:47:36
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {
	@Bean("taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 核心线程数10：线程池创建时候初始化的线程数
		executor.setCorePoolSize(10);
		// 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
		executor.setMaxPoolSize(20);
		// 缓冲队列200：用来缓冲执行任务的队列
		executor.setQueueCapacity(200);
		// 允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
		executor.setKeepAliveSeconds(60);
		// 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
		executor.setThreadNamePrefix("taskExecutor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 该方法就是这里的关键，用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
		executor.setWaitForTasksToCompleteOnShutdown(true);
		// 该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
		executor.setAwaitTerminationSeconds(60);
		return executor;
	}
}
