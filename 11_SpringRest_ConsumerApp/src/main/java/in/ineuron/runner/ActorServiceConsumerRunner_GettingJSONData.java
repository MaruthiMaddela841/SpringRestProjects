package in.ineuron.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Actor;

@Component
public class ActorServiceConsumerRunner_GettingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumerRunner_GettingJSONData.run()");
		RestTemplate template = new RestTemplate();
		String serviceURL="http://localhost:8080/10_SpringRest_ProviderApp/api/actor/find/{id}";
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",7);
		
		ResponseEntity<Actor> responseEntity = template.getForEntity(serviceURL,Actor.class,map);
		System.out.println("Response Body::"+responseEntity.getBody());
		System.out.println("Response Status Code Name::"+responseEntity.getStatusCode().toString());
		System.out.println("Response Status Code Value"+responseEntity.getStatusCodeValue());
		
		System.out.println("************************************************************");
		
		
	}

}
