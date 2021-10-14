package myapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.impPt8.Pt8NouvelleImplantation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/configPt8.xml")
public class Pt8Test {
	
	@Before
	public void beforeEachTest() {
		System.err.println("=========================================================");
	}
	
	@Autowired
	Pt8NouvelleImplantation impl;
	
	@Test
	public void testPt8NouvelleVersion_LOGGER_1() {
		double a = 12;
		double b = 30.5;
		double resultat = impl.getCalc().add(a, b);
		impl.getLogger1().log(String.format("add(%f, %f) => %f", a, b, resultat));
	}
	
	@Test
	public void testPt8NouvelleVersion_LOGGER_2() {
		double a = 20;
		double b = 3.5;
		double resultat = impl.getCalc().add(a, b);
		impl.getLogger2().log(String.format("add(%f, %f) => %f", a, b, resultat));
	}

}
