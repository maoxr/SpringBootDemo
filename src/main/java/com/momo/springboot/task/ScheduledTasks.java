/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot 
 * @author: ibadboy   
 * @date: 2018年7月2日 下午5:11:34 
 */
package com.momo.springboot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: com.momo.springboot.ScheduledTasks
 * @Description: 定时任务
 * @author ibadboy
 * @date: 2018年7月2日 下午5:11:34
 */
@Component
public class ScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

	
	/**
	 * Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
	 * Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * Scheduled(cron="*5 *****") ：通过cron表达式定义规则
	 * Author:ibadboy
	 * Date: 2018年7月2日下午5:13:31
	 */
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("定时任务：" + dateFormat.format(new Date()));
	}
}
