package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.response.CurrencyResponseApp;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterApp {
	
	@GetMapping("/getCurrencyExchangeCost/from/{from}/to/{to}")
	public ResponseEntity<CurrencyResponseApp> getCurrencyValue(@PathVariable String from,@PathVariable String to) {
		CurrencyResponseApp response = new CurrencyResponseApp();
		response.setCurrencyId(1);
		response.setCurrencyFrom(from);
		response.setCurrencyTo(to);
		response.setCurrencyValue(82);
		return new ResponseEntity<CurrencyResponseApp>(response,HttpStatus.OK);
	}

}
