package myapp.imp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import myapp.services.ICalculator;

@Service
@Qualifier("pt8calc")
public class Pt8Calculator implements ICalculator {
	
	@PostConstruct
	public void start() {
		System.err.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		System.err.println("Stop " + this);
	}
	

	@Override
	public double add(double a, double b) {
		return (a + b);
	}

}
