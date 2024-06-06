package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.exception.StudentRecordNotFoundException;
import in.ineuron.model.Student;

@Service("service")
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDao dao;

	@Override
	public String saveStudent(Student student) {
		Student dbstudent=dao.save(student);
		return "Student record is saved with ID::"+dbstudent.getSid();
	}

	@Override
	public List<Student> findAllStudents() {
		
		return dao.findAll();
	}

	@Override
	public Student findById(Integer id) {
		Student student = dao.findById(id).orElseThrow(()->new StudentRecordNotFoundException("Record not found"));
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		Student dbstudent=dao.save(student);
		return "Student record is updated with ID::"+dbstudent.getSid();
	}

	@Override
	public String deleteStudentById(Integer id) {
		dao.deleteById(id);
		return "Student record deleted with ID::"+id;
	}

}
