package com.darkedges.spring.drools.webservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.darkedges.spring.drools.webservice.facts.AdultBusPass;
import com.darkedges.spring.drools.webservice.facts.BusPass;
import com.darkedges.spring.drools.webservice.facts.ChildBusPass;
import com.darkedges.spring.drools.webservice.facts.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class BusPassWebServiceTest {
	@Autowired
	private BusPassService busPassService;

	@Test
	public void shouldIssueAdultBusPass() {
		Person person = new Person("Steve", 16);
		BusPass busPass = busPassService.getBusPass(person);

		System.out.println("Bus pass: " + busPass);

		assertEquals(AdultBusPass.class, busPass.getClass());
	}

	@Test
	public void shouldIssueChildBusPass() {
		Person person = new Person("Steve", 15);
		BusPass busPass = busPassService.getBusPass(person);

		System.out.println("Bus pass: " + busPass);

		assertEquals(ChildBusPass.class, busPass.getClass());
	}
}
