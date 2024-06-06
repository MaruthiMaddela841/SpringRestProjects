package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveStudent(Student student){
		String body=service.saveStudent(student);
		return new ResponseEntity<String>(body,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayStudentsDetails(){
			List<Student> students = service.findAllStudents();
			return new ResponseEntity<List<Student>>(students ,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayStudentDetailsById(@PathVariable Integer id){
			Student student = service.findById(id);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyStudentDetails(@RequestBody Student student){
			String updateStudent = service.updateStudent(student);
			return new ResponseEntity<String>(updateStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentDetailsById(@PathVariable Integer id){
			String deleteStudentById = service.deleteStudentById(id);
			return new ResponseEntity<String>(deleteStudentById,HttpStatus.OK);
	}

}
