package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.response.CurrencyResponseApp;

@Service("service")
public class CurrencyService {
	private static final String REST_END_POINT = "http://localhost:8080/13_SpringRest_CurrencyConverterApp/api/currency/getCurrencyExchangeCost/from/USD/to/IND";

	public void invokeRestApiSync(String from,String to) {
		//Sending Synchronous Request
				WebClient webClient = WebClient.create();
				System.out.println("****Synchronous Call Started*******");
				CurrencyResponseApp response = webClient.get().uri(REST_END_POINT,from,to)
						.accept(MediaType.APPLICATION_JSON)
						.retrieve()
						.bodyToMono(CurrencyResponseApp.class).block();
				System.out.println(response);
				System.out.println("****Synchronous Call Ended*******");
	}
	
	public void invokeRestApiASync(String from,String to) {
		//Sending Synchronous Request
				WebClient webClient = WebClient.create();
				System.out.println("****Asynchronous Call Started*******");
				webClient.get().uri(REST_END_POINT,from,to)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
						.bodyToMono(CurrencyResponseApp.class).subscribe(CurrencyService::myResponse);
				System.out.println("****Asynchronous Call Ended*******");
	}
	
	public static void myResponse(CurrencyResponseApp response) {
			System.out.println(response);
	}
}
