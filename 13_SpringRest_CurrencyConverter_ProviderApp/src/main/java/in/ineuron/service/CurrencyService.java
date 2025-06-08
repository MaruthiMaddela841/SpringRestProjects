package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.response.CurrencyResponseApp;

@Service("service")
public class CurrencyService {
private static final String REST_END_POINT = "http://localhost:8080/13_SpringRest_CurrencyConverterApp/api/currency/getCurrencyExchangeCost/from/USD/to/INR";

	public CurrencyResponseApp invokeRestApiSync(String from, String to) {
		System.out.println("CurrencyService.invokeRestApiSync()");
// Sending Synchronous request
		WebClient webClient = WebClient.create();
		System.out.println("***Synchronous: Rescall started ******");
		CurrencyResponseApp response = webClient.get().uri(REST_END_POINT, from, to).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(CurrencyResponseApp.class).block();
		System.out.println(response);
		System.out.println("****Synchronous: Restcall ended ******");
		return response;
	}

	public void invokeRestApiASync(String from, String to) {
// Sending Synchronous request
		WebClient webClient = WebClient.create();
		System.out.println("***ASynchronous: Restcall started ******");
		webClient.get().uri(REST_END_POINT, from, to).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(CurrencyResponseApp.class).subscribe(CurrencyService::myResponse);
		System.out.println("****ASynchronous: Restcall ended ******");
	}

	public static void myResponse(CurrencyResponseApp response) {
		System.out.println("CurrencyService.myResponse()");
		System.out.println(response);
		//use repsonse object as per the needs[push to Apache-kafka]
	}
}
