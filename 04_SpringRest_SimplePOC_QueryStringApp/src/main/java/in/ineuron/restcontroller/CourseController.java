package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@PostMapping("/info/{id}/{name}")
	public ResponseEntity<String> getCourseInfo(@PathVariable Integer id,@PathVariable String name){
		String body="Course with ID::"+id+" and with Name::"+name;
		ResponseEntity<String> entity=new ResponseEntity<String>(body,HttpStatus.OK);
		return entity;
	}

}
