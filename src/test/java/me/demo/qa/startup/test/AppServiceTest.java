package me.demo.qa.startup.test;

import me.demo.qa.startup.service.IAppService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * App Test
 * 
 * @author geosmart
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AppServiceTest {

	@Autowired
	IAppService appService;

	@Before
	public void startup() {
		System.out.println("---startup");
	}

	@Test
	public void sayHelloWord() {
		String result =appService.sayHelloWord("geosmart");
		System.out.println(result);
	}

	@After
	public void teardown() {
		System.out.println("---teardown");
	}
}
