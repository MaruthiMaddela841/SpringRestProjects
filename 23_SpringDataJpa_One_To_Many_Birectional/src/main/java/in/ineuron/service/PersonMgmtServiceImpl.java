package in.ineuron.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.repo.IPersonRepo;
import in.ineuron.repo.IPhoneNumberRepo;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IPhoneNumberRepo phoneNumberRepo;

	@Override
	public String savePerson(Person person) {
		Integer pid = personRepo.save(person).getPid();
		return "Person saved with ID::"+pid;
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> phoneNumbers) {
		for (PhoneNumber phoneNumber : phoneNumbers) {
			phoneNumberRepo.save(phoneNumber);
		}
		return ((Set<PhoneNumber>) phoneNumbers).size()+" no of Phone Numbers are saved";
	}

}
