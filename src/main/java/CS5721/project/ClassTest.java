package CS5721.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/test")
public class ClassTest {

	@GetMapping
	public String welcomePage() {

		return "welcome.html";
	}

}
