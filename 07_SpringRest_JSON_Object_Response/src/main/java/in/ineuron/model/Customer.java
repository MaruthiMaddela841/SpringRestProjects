package in.ineuron.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Customer {
	
	 private Integer cno;
	 private String cname;
	 private Float billAmount;
	 private String[] teamnames;
	 private List<String> cityNames;
	 private Map<String,Long> phoneNo;
	 private Company company;
}
