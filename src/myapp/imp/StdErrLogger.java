package myapp.imp;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import myapp.services.ILogger;

@Service("stdErrLogger")
@Primary
@Qualifier("test")
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
