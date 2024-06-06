package in.ineuron;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.config.model.customer.Customer;
import in.ineuron.config.model.product.Product;
import in.ineuron.repo.customer.ICustomerRepo;
import in.ineuron.repo.product.IProductRepo;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private IProductRepo productRepo;
	@Autowired
	private ICustomerRepo customerRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		
		productRepo.saveAll(Arrays.asList(
				new Product(10,"001","Fossil"),
				new Product(11,"002","Tissot"),
				new Product(12,"003","Titan")
				));
		customerRepo.saveAll(Arrays.asList(
				new Customer(10,"sachin","s@gmail.com"),
				new Customer(11,"kohli","k@gmail.com"),
				new Customer(12,"dhoni","d@gmail.com")
				));
	}

}
