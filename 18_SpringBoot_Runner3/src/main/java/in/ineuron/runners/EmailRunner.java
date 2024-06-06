package in.ineuron.runners;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class EmailRunner implements ApplicationRunner{
	
	@Value("${spring.application.name}")
	private String name;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
	}

}
