package in.ineuron.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("in.ineuron.restcontroller"))
				.paths(PathSelectors.regex("/api/tourist.*"))
				.build()
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
	    Contact contact = new Contact("Nitin", "www.ineuron.com", "nitin@ineuron.com");
	    return new ApiInfo("TouristInfo", "Gives Info about tourist activities", "3.4 RELEASE",
	            "Terms of service", contact, "GNU PUBLIC", "http://apache.org/license/guru", Collections.emptyList());
	}

}
