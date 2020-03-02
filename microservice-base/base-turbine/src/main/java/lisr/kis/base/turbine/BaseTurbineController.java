package lisr.kis.base.turbine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseTurbineController {

	@GetMapping("/")
	public String index() {
		return "forward:/hystrix";
	}
}
