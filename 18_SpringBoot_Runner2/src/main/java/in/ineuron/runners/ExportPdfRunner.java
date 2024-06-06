package in.ineuron.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

public class ExportPdfRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("From Command Line Runner::"+Arrays.asList(args));
	}

}
