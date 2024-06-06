package in.ineuron;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import in.ineuron.service.ERailClientApp;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		
		ERailClientApp service = context.getBean("service",ERailClientApp.class);
		service.invokeRestApi();
		((ConfigurableApplicationContext) context).close();
	}

}
