package myapp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myapp.imp.BeanFileLogger;
import myapp.imp.FileLogger;
import myapp.imp.SimpleCalculator;
import myapp.imp.StdErrLogger;
import myapp.services.ICalculator;
import myapp.services.ILogger;

public class TestLoggerServices {
	
	@Before
	public void beforeEachTest() {
		System.err.println("=========================================================");
	}
	
	@After
	public void afterEachTest() {}
	
	void use(ILogger logger) {
		logger.log("Voilà le résultat = hello");
	}
	
	void use(ICalculator calc) {
		calc.add(100, 200);
	}
	
	@Test
	public void testStdErrLogger() {
		StdErrLogger logger = new StdErrLogger();
		logger.start();
		use(logger);
		logger.stop();
	}
	
	@Test
	public void testFileLogger() {
		FileLogger logger = new FileLogger("resources/tmp/myapp.log");
		logger.start();
		use(logger);
		logger.stop();
	}
	
	@Test
	public void testBeanFileLogger() {
		BeanFileLogger logger = new BeanFileLogger();
//		logger.setFileName("resources/tmp/myappBEAN.log");
		logger.start();
		use(logger);
		logger.stop();	
	}
	
	@Test
	public void testCalculatorAndStdErrLogger() {
		StdErrLogger logger = new StdErrLogger();
		logger.start();
		
		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setLogger(logger);
		calculator.start();
		
		use(calculator);
		calculator.stop();
		logger.stop();
	}
	
	@Test
	public void testCalculatorAndFileLogger() {
		BeanFileLogger logger = new BeanFileLogger();
		logger.setFileName("resources/tmp/myappBEAN_calculator.log");
		logger.start();
		
		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setLogger(logger);
		calculator.start();
		
		use(calculator);
		calculator.stop();
		logger.stop();
	}
	
}
