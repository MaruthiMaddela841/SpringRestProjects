package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.CurrencyService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		
		CurrencyService service = context.getBean("service",CurrencyService.class);
		service.invokeRestApiSync("USD", "INR");
		System.out.println("********************************");
		service.invokeRestApiASync("USD", "INR");
		((ConfigurableApplicationContext) context).close();
	}

}
