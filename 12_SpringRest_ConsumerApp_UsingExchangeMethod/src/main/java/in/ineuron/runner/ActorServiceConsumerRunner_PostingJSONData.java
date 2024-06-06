package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumerRunner_PostingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumerRunner_PostingJSONData.run()--->echange()");
		RestTemplate template = new RestTemplate();
		String serviceURL="http://localhost:8080/10_SpringRest_ProviderApp/api/actor/register";
		
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String json_body="{\r\n"
				+ "    \"aid\":18,\r\n"
				+ "    \"name\":\"kohli\",\r\n"
				+ "    \"age\":38,\r\n"
				+ "    \"type\":\"cricketer\"\r\n"
				+ "}";
		HttpEntity<Object> entity = new HttpEntity<>(json_body,headers);
		
		ResponseEntity<String> responseEntity = template.exchange(serviceURL,HttpMethod.POST, entity,String.class);
		System.out.println("Response Body::"+responseEntity.getBody());
		System.out.println("Response Status Code Name::"+responseEntity.getStatusCode().toString());
		System.out.println("Response Status Code Value"+responseEntity.getStatusCodeValue());
		
		System.out.println("************************************************************");
		
		
	}

}
