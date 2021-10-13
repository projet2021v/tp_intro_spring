package myapp.imp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import myapp.services.ILogger;

public class FileLogger implements ILogger {
	
	private final PrintWriter writer;
	
	public FileLogger(String fileName) {
		try {
			this.writer = new PrintWriter(new FileOutputStream(fileName, true));
		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Bad fileName");
		}
	}
	
	public void start() {
		System.err.println("Start " + this);
	}
	
	public void stop() {
		System.err.println("Stop " + this);
	}
	
	public void log(String message) {
		writer.printf("%tF %1$tR | %s\n", new Date(), message);
	}

}
