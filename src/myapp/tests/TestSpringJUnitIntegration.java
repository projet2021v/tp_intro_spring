package myapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.services.ICalculator;
import myapp.services.ILogger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/config.xml")
public class TestSpringJUnitIntegration {
	
	@Autowired
	ILogger logger;
	
	@Autowired
	ICalculator calc;
	
	@Before
	public void beforeEachTest() {
		System.err.println("=========================================================");
	}
	
	void use(ILogger logger) {
		logger.log("Voil� le r�sultat");
	}
	
	void use(ICalculator calc) {
		calc.add(100, 200);
	}
	
	@Test
	public void testStdErrLogger() {
		System.err.println("+++ StdErrLogger");
		use(logger);
	}
	
	@Test
	public void testCalculatorwIthLogger() {
		use(calc);
	}

}
