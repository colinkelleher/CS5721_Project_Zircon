package CS5721.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class WelcomeController {

	@GetMapping
	public String welcomePage() {

		return "welcome.html";
	}

}
