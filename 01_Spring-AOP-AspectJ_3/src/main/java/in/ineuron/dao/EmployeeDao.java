package in.ineuron.dao;

import java.util.Random;

import org.springframework.stereotype.Component;

import in.ineuron.annotation.MyTransaction;

@Component
public class EmployeeDao {
	
	@MyTransaction
	public void saveEmployee() {
		System.out.println("Employee Object is saved.");
	}

}
