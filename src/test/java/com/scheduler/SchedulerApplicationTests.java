package com.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class SchedulerApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context);
	}

	@Test
	void testFeignClientIsEnabled() {
		boolean isFeignClientPresent = context.containsBean("sendEmail");
		assertTrue(isFeignClientPresent, "Feign client 'sendEmail' should be present in the context");
	}
}
