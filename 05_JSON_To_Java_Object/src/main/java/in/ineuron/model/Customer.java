package in.ineuron.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean active;
	private Address address;
	private String[] languages;
}
