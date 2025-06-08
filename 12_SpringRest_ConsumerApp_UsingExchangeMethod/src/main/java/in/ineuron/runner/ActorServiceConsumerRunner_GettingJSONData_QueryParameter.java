package in.ineuron.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Actor;

@Component
public class ActorServiceConsumerRunner_GettingJSONData_QueryParameter implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumerRunner_GettingJSONData_QueryParameter.run()-->exchange()");
		RestTemplate template = new RestTemplate();
		String serviceURL="http://localhost:8080/10_SpringRest_ProviderApp/api/actor/findById?id={id}";
//		
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("id",7);
		ResponseEntity<Actor> responseEntity = template.exchange(serviceURL,HttpMethod.GET,null,Actor.class,7);
		System.out.println("Response Body::"+responseEntity.getBody());
		System.out.println("Response Status Code Name::"+responseEntity.getStatusCode().toString());
		System.out.println("Response Status Code Value"+responseEntity.getStatusCodeValue());
		
		System.out.println("************************************************************");
		
		
	}

}
