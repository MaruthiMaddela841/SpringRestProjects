package in.ineuron.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wish")
public class WishController {
	
	@GetMapping("/msg")
	@ResponseBody
	public String generateWishMessage(){
		String msg="Welcome to RESTFul services from iNeuron...";
		return msg;
	}

}
