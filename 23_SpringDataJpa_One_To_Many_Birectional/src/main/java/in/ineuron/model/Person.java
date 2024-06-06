package in.ineuron.model;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="OTM_PERSON")
public class Person {
	
	public Person(String pname, String paddress) {
		this.pname=pname;
		this.paddress=paddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NonNull
	private String pname;
	@NonNull
	private String paddress;
	
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL)
	@JoinColumn(name="PERSON_ID",referencedColumnName = "pid")
	private Set<PhoneNumber> contactDetails;

}
