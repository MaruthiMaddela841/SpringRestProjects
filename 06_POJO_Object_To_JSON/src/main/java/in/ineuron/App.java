package in.ineuron;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	try {
    		ObjectMapper mapper=new ObjectMapper();
    		Product product = new Product();
    		product= getObjectData(product);
    		System.out.println("JAVA::"+product);
    		String jsonData = mapper.writeValueAsString(product);
    		System.out.println("JSON::"+jsonData);
    		
    		mapper.writeValue(new File("data/product-list.json"), jsonData);
    		System.out.println("Wrote the data to JSON file...");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    }
    
    public static Product getObjectData(Product product) {
    	product.setPid(11);
    	product.setPname("Fan");
    	product.setPrice(3000.5);
    	product.setTypes(new String[]{"ceiling","wall"});
    	return product;
    }
}
