package myapp.imp;

import myapp.services.ICalculator;
import myapp.services.ILogger;

public class Pt8NouvelleImplantation {
	
	private ICalculator calc;
	private ILogger logger;
	
	public Pt8NouvelleImplantation() {}

	public ICalculator getCalc() {
		return calc;
	}

	public void setCalc(ICalculator calc) {
		this.calc = calc;
	}

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}
	
	

}
