package myapp.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.services.ICalculator;
import myapp.services.ILogger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/configPt8.xml")
public class Pt8Test {
	
	@Autowired
	@Qualifier("pt8logger")
	ILogger logger;
	
	@Autowired
	@Qualifier("pt8calc")
	ICalculator calc;
	
	@Test
	public void testPt8NouvelleVersion() {
		double a = 12;
		double b = 30.5;
		double resultat = calc.add(a, b);
		logger.log(String.format("add(%f, %f) => %f", a, b, resultat));
	}

}
