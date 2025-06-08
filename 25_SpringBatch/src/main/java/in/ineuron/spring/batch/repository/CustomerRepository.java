package in.ineuron.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.spring.batch.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
