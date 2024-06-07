package in.ineuron.service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;

public interface IPersonMgmtService {
	
	public String savePerson(Person person);
	public String savePhoneNumbers(Iterable<PhoneNumber> phoneNumber);
	public Iterable<Person> fetchByPerson();
	public Iterable<PhoneNumber> fetchByPhoneNumber();
	public String deleteByPerson(Integer personId);
	public String deleteAllPhoneNumbersOfAPerson(Integer personId);
}
