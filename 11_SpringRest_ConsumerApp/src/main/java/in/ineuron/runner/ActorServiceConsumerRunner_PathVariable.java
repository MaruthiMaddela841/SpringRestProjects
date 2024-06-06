package in.ineuron.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumerRunner_PathVariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumerRunner.run()");
		RestTemplate template = new RestTemplate();
		String serviceURL="http://localhost:8080/10_SpringRest_ProviderApp/api/actor/wish/{id}/{name}";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",7);
		map.put("name", "Maruthi");
		ResponseEntity<String> responseEntity = template.getForEntity(serviceURL, String.class,map);
		System.out.println("Response Body::"+responseEntity.getBody());
		System.out.println("Response Status Code Name::"+responseEntity.getStatusCode().toString());
		System.out.println("Response Status Code Value"+responseEntity.getStatusCodeValue());
		
		System.out.println("************************************************************");
		
		
	}

}
