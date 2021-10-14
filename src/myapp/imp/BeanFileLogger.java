package myapp.imp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import myapp.services.ILogger;

@Service("beanFileLogger")
@Qualifier("test")
public class BeanFileLogger implements ILogger {
	
	private String fileName = "resources/tmp/myappBEAN.log";
	
	private PrintWriter writer;
	
	public BeanFileLogger() {}
	
	@PostConstruct
	public void start() {
		if(fileName == null) {
			throw new IllegalStateException("no fileName");
		}
		
		try {
			OutputStream os = new FileOutputStream(fileName, true);
			this.writer = new PrintWriter(os);
		} catch(FileNotFoundException e) {
			throw new IllegalStateException("bad FileName");
		}
		
		System.err.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		System.err.println("Stop " + this);
	}
	
	public void log(String message) {
		writer.printf("%tF %1$tR | %s\n", new Date(), message);
		writer.close();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
