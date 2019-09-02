package me.app.flight;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlightNotFound extends RuntimeException {
	//my code
	public FlightNotFound(String message) {
		super(message);
	}
	
}
