package in.ineuron.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="OTM_PHONE_NUMBER")
public class PhoneNumber {

	public PhoneNumber(long phoneNo, String provider, String type) {
		this.phoneNo=phoneNo;
		this.provider=provider;
		this.type=type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;
	
	@NonNull
	private Long phoneNo;
	@NonNull
	private String provider;
	
	@NonNull
	private String type;
	
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)//,fetch=FetchType.LAZY)
	private Person person;
	
	
}
