package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorControllerAdvice {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException tnf){
		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), tnf.getMessage(),"404-Not Found");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		System.out.println("TouristErrorControllerAdvice.handleAllProblems()");
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(),"Problem in Execution");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
