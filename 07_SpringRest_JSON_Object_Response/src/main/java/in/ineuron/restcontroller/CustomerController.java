package in.ineuron.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Company;
import in.ineuron.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> showAllCustomers(@PathVariable Integer id){
		System.out.println("Customer data for the ID::"+id);
		Customer customer = new Customer();
		customer.setCno(id);
		customer.setCname("Maruthi");
		customer.setBillAmount(3452.5f);
		customer.setTeamnames(new String[] {"Lotus Notes","Supervision"});
		List<String> cityNames=new ArrayList<String>();
		cityNames.add("Hyderabad");
		cityNames.add("Bengaluru");
		customer.setCityNames(cityNames);
		customer.setPhoneNo(Map.of("Maruthi",7893220868L,"Pruthwi",738604436L));
		Company company = new Company("MI","IPL","Mumbai",45);
		customer.setCompany(company);
		ResponseEntity<Customer> entity = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		return entity;
	}
	@PostMapping(value="/save",consumes="application/json")
	public ResponseEntity<String> saveCustomers(@RequestBody Customer customer){
		System.out.println(customer);
		Integer id=10;
		String body="Customer saved with ID::"+id;
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}

}
