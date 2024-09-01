package in.ineuron;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;

public class App 
{
    public static void main( String[] args )
    {
        ObjectMapper mapper=new ObjectMapper();
        try {
			Customer customer=mapper.readValue(new File("data/sample-full.json"), Customer.class);
			System.out.println(customer);
			Customer customer2=mapper.readValue(new File("data/sample-lite.json"), Customer.class);
			System.out.println(customer2);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
