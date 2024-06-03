package in.ineuron.dao;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	public int saveEmployee() {
//		if(new Random().nextInt(15)<10) {
//			throw new RuntimeException("Dummy Excpetion");
//		}
		System.out.println("Employee Object is saved with ID::5");
		//return "Employee Object is saved with ID::5";
		return 13;
	}

}
