package in.ineuron.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.ineuron.methodref.SampleTest;

@Configuration
public class AppConfig {
	
	@Bean
	public CommandLineRunner runA() {
//		return new CommandLineRunner() {
//			
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("Hello::"+Arrays.asList(args));
//			}
//		};
		
//		return (args)->System.out.println("FROM RUNNER::"+Arrays.asList(args));
		
		return SampleTest::test;
	}

}
