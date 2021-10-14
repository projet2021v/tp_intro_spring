package myapp.imp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import myapp.services.ILogger;

@Service
@Qualifier("pt8logger2")
public class Pt8Logger2 implements ILogger {
	
	@PostConstruct
	public void start() {
		System.err.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		System.err.println("Stop " + this);
	}
	
	public void log(String message) {
		System.err.printf("-----LOGGER_2 (sans date)----- | %s\n", message);
	}
}
