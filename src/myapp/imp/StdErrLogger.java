package myapp.imp;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import myapp.services.ILogger;

public class StdErrLogger implements ILogger {
	
	@PostConstruct
	public void start() {
		System.err.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		System.err.println("Stop " + this);
	}
	
	public void log(String message) {
		System.err.printf("%tF %1$tR | %s\n", new Date(), message);
	}

}
