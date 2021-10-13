package myapp.imp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import myapp.services.ICalculator;
import myapp.services.ILogger;

public class SimpleCalculator implements ICalculator {
	
	private ILogger logger;
	
	@PostConstruct
	public void start() {
		if(logger == null) {
			throw new IllegalStateException("null logger");
		}
		System.err.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		System.err.println("Stop " + this);
	}

	@Override
	public double add(double a, double b) {
		logger.log(String.format("add(%f,%f)", a, b));
		return (a + b);
	}

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

}
