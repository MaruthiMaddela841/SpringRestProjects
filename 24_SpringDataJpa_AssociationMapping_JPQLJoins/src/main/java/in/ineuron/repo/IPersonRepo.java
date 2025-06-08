 package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.model.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {
	@Query("select p.pid,p.pname,p.paddress,ph.regNo,ph.phoneNo,ph.provider,ph.type from Person p inner join p.contactDetails ph")
	public List<Object[]> fetchDataByJoinsUsingParent();
}
