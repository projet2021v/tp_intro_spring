package myapp.impPt8;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import myapp.services.ICalculator;

@Service
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
