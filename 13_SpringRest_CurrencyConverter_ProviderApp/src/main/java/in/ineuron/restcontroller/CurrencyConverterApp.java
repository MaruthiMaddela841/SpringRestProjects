package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.response.CurrencyResponseApp;
import in.ineuron.service.CurrencyService;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterApp {
	
	@Autowired
	private CurrencyService service;
	
	@GetMapping("/getCurrencyExchangeCost/from/{from}/to/{to}")
	public ResponseEntity<CurrencyResponseApp> getCurrencyValue(@PathVariable String from,@PathVariable String to) {
		CurrencyResponseApp response = new CurrencyResponseApp();
		response.setCurrencyId(1);
		response.setCurrencyFrom(from);
		response.setCurrencyTo(to);
		response.setCurrencyValue(82);
		//CurrencyResponseApp invokeRestApiSync = service.invokeRestApiSync(from, to);
		//service.invokeRestApiASync(from, to);
		return new ResponseEntity<CurrencyResponseApp>(response,HttpStatus.OK);
	}

}
