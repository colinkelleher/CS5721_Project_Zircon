package CS5721.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ZirconWelcomeController {

	@GetMapping
	public String welcomePage() {

		return "index.html";
	}

}
