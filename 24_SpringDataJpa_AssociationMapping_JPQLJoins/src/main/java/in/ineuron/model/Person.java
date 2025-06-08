package in.ineuron.model;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,mappedBy = "person",
			fetch=FetchType.EAGER)
	private Set<PhoneNumber> contactDetails;

}
