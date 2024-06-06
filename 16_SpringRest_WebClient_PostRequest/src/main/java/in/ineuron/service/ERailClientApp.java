package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@Service("service")
public class ERailClientApp {
	
	public void invokeRestApi() {
		WebClient webClient = WebClient.create();
		PassengerInfo passenger = new PassengerInfo();
		passenger.setFirstName("Maruthi");
		passenger.setLastName("Maddela");
		passenger.setFrom("Mancherial");
		passenger.setTo("Hyderabad");
		passenger.setJourneyDate("30/04/2024");
		passenger.setTrainNumber("12758");
		Ticket response = webClient.post().uri("http://localhost:8080/15_SpringRest_WebClient_TicketBookingApp/api/ticket/register")
		.accept(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(passenger))
		.retrieve().bodyToMono(Ticket.class).block();
		System.out.println(response);
	}

}
