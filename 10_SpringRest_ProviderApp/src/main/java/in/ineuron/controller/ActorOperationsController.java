package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Actor;

@RestController
@RequestMapping("/api/actor")
public class ActorOperationsController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage(){
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		String body=null;
		if(hour<12)
			body="Good Morning";
		else if(hour<16)
			body="Good Afternoon";
		else if(hour<20)
			body="Good Evening";
		else
			body="Good Night";
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id,@PathVariable String name){
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		String body=null;
		if(hour<12)
			body="Good Morning "+name+"(ID::"+id+")";
		else if(hour<16)
			body="Good Afternoon "+name+"(ID::"+id+")";
		else if(hour<20)
			body="Good Evening "+name+"(ID::"+id+")";
		else
			body="Good Night "+name+"(ID::"+id+")";
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registeractor(@RequestBody Actor actor){
		System.out.println("ActorOperationsController.registeractor()");
		return new ResponseEntity<String>("Actor data is ::"+actor.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Actor> registeractor(@PathVariable Integer id){
		return new ResponseEntity<Actor>(new Actor(id,"Maruthi",30.0f,"SE"),HttpStatus.OK);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Actor> registeractorById(@RequestParam Integer id){
		return new ResponseEntity<Actor>(new Actor(id,"Maruthi",30.0f,"SE"),HttpStatus.OK);
	}

}
