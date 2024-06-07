package in.ineuron.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPersonMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {
	
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		//child->parent
//		Person person = new Person("Hyder","RCB");
//		PhoneNumber p1=new PhoneNumber(7893220868L,"Airtel","office");
//		PhoneNumber p2=new PhoneNumber(9398495492L,"Jio","Residence");
//		p1.setPerson(person);
//		p2.setPerson(person);
//		
//		Set<PhoneNumber> contactDetails=Set.of(p1,p2);
//		person.setContactDetails(contactDetails);
//		String status=service.savePerson(person);
//		System.out.println(status);
		
		//parent->child
//		Person person = new Person("Sachin","MI");
//		PhoneNumber p1=new PhoneNumber(7893220869L,"Idea","Room");
//		PhoneNumber p2=new PhoneNumber(9398495493L,"Uninor","Pub");
//		p1.setPerson(person);
//		p2.setPerson(person);
//		
//		Set<PhoneNumber> contactDetails=Set.of(p1,p2);
//		person.setContactDetails(contactDetails);
//		System.out.println(service.savePerson(person));
		
		//Load operation from Parent to Child[1 to Many]
//		service.fetchByPerson().forEach(person->{
//			System.out.println("Parent::"+person);
//			Set<PhoneNumber> childs = person.getContactDetails();
//			childs.forEach(contact->{
//				System.out.println("Child::"+contact);
//			});
//		});
//		System.out.println();
//		//Load operation from Child to Parent[Many to 1]
//		service.fetchByPhoneNumber().forEach(phone->{
//			System.out.println("Phone::"+phone);
//			Person person=phone.getPerson();
//			System.out.println(person);
//		});
		
//		System.out.println(service.deleteByPerson(2));
//		System.out.println(service.deleteAllPhoneNumbersOfAPerson(3));
		
	}

}
