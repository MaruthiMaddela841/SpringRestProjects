package in.ineuron.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumerRunner_PathVariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumerRunner.run()--->exchange()");
		RestTemplate template = new RestTemplate();
		String serviceURL="http://localhost:8080/10_SpringRest_ProviderApp/api/actor/wish/{id}/{name}";
		ResponseEntity<String> responseEntity = template.exchange(serviceURL, HttpMethod.GET,null,String.class,7,"Maruthi");
		System.out.println("Response Body::"+responseEntity.getBody());
		System.out.println("Response Status Code Name::"+responseEntity.getStatusCode().toString());
		System.out.println("Response Status Code Value"+responseEntity.getStatusCodeValue());
		
		System.out.println("************************************************************");
		
		
	}

}
