package br.com.kontulari.kontschedule;

import org.springframework.stereotype.Component;

@Component
public class PostConstruct {

	
	
	public void runAfterObjectCreated() {
		System.out.println("PostContruct method called");
	}
}
