package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IPurchaseOrder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		IPurchaseOrder order = context.getBean(IPurchaseOrder.class);
		try {
			String msg = order.purchase(new String[] { "Fastrack-FASTRACK", "50,000-Hairdryer", "13 max pro" },
					new double[] { 1200.0, 5000.0, 6000.0 },
					new String[] {"maruthimaddelap1@gmail.com","shishira36@gmail.com","maru.justin@gmail.com"});
			System.out.println(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}
}
