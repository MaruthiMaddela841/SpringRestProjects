package in.ineuron.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
@SequenceGenerator(name="student_seq", initialValue=1, allocationSize=1)
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
	private Integer sid;
	private String name;
	private String address;
	private String mail;
}
