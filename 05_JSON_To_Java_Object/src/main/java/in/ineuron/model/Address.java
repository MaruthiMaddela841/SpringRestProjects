package in.ineuron.model;

import lombok.Data;

@Data
public class Address {
	
	private String street;
	private String city;
	private String state;
	private Long zip;
	private String country;

}
