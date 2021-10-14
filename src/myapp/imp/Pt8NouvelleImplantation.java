package myapp.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import myapp.services.ICalculator;
import myapp.services.ILogger;

public class Pt8NouvelleImplantation {
	
	@Autowired
	private ICalculator calc;
	
	@Autowired
	@Qualifier("pt8logger1")
	private ILogger logger1;
	
	@Autowired
	@Qualifier("pt8logger2")
	private ILogger logger2;
	
	public Pt8NouvelleImplantation() {}

	public ICalculator getCalc() {
		return calc;
	}

	public void setCalc(ICalculator calc) {
		this.calc = calc;
	}

	public ILogger getLogger1() {
		return logger1;
	}

	public void setLogger1(ILogger logger1) {
		this.logger1 = logger1;
	}

	public ILogger getLogger2() {
		return logger2;
	}

	public void setLogger2(ILogger logger2) {
		this.logger2 = logger2;
	}
	
	

}
