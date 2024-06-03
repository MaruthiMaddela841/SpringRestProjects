package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/read")
	public ResponseEntity<String> getEmployee(
			@RequestParam(defaultValue = "10",required=false) Integer id,
			@RequestParam(defaultValue = "sachin",required=false) String name){
		System.out.println("EmployeeController.getEmployee() with ID::"+id+" and name::"+name);
		return new ResponseEntity<String>("Customer found with ID::"+id+" and name::"+name,HttpStatus.OK);
	}
	
}
