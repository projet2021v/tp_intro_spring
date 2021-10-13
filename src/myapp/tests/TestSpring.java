package myapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myapp.services.ICalculator;
import myapp.services.ILogger;

public class TestSpring {
	
	@Before
	public void beforeEachTest() {
		System.err.println("=========================================================");
	}
	
	void use(ILogger logger) {
		logger.log("Voilà le résultat");
	}
	
	void use(ICalculator calc) {
		calc.add(100, 200);
	}
	
	@Test
	public void testStdErrLogger() {
		System.err.println("+++ StdErrLogger");
		String conf = "config.xml";
		
		try(AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(conf)) {
			ILogger logger = ctx.getBean("stdErrLogger", ILogger.class);
			use(logger);
		}
	}
	
	@Test
	public void testCalculatorWithStdErrLogger() {
		System.err.println("+++ CalculatorWithStdErrLogger");
		String conf = "config.xml";
		
		try(AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(conf)) {
			ICalculator calcStdErr = ctx.getBean("calcStdErr", ICalculator.class);
			use(calcStdErr);
		}
	}
	
	@Test
	public void testCalculatorWithBeanFileLogger() {
		System.err.println("+++ CalculatorWithBeanFileLogger");
		String conf = "config.xml";
		
		try(AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(conf)) {
			ICalculator calcBeanFile = ctx.getBean("calcBeanFile", ICalculator.class);
			use(calcBeanFile);
		}
	}
		
}
