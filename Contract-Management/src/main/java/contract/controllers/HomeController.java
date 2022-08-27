package contract.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	@GetMapping("/contactadmin")
	public String contractadmin() {
		return "contractadmin";
	}
	
	
	
}
