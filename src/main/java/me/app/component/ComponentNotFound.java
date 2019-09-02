package me.app.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ComponentNotFound extends RuntimeException {
	//my code
	public ComponentNotFound(String message) {
		super(message);
	}
	
}
