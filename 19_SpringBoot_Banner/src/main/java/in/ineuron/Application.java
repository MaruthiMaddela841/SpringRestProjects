package in.ineuron;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication application= new SpringApplication();
		application.setBannerMode(Banner.Mode.CONSOLE);
		ConfigurableApplicationContext cat= SpringApplication.run(Application.class, args);
		cat.close();
	}

}
