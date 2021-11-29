package CS5721.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class ZirconWelcomePageController {

	@GetMapping(path = "/")
	public String welcomePage(Model model) {

		return "clock.html";
	}

}
