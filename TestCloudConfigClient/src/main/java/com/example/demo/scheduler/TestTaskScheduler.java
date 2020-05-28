package com.example.demo.scheduler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.restclient.TestRestClient;

@Component
public class TestTaskScheduler {

	@Autowired
	TestRestClient testRestClient;

	//@Scheduled(cron = "0 0 1 * * ?")
	@Scheduled(fixedRate = 30000)
	public void scheduleDownloadingSignedEnvelopTask() throws IOException {
		System.out.println("Refreshing Config START");
		System.out.println(testRestClient.refreshConfig());
		System.out.println("Refreshing Config END");
	}

}
