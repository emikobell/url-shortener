package com.emikobell.urlshortener;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class UrlshortenerApplicationTests {

	@Autowired
	private UrlShortenerController controller;

	@Test
	public void contextLoads() throws Exception {
		assertNotNull(controller);
	}
}