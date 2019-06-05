package com.momo.springboot.app;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		  log.info(".加载.....ApplicationFailedEvent......");
		
	}

}
