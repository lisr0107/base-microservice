package lisr.kis.base.hystrix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HystrixDashboardController {

	@GetMapping("/")
	public String index() {
		return "forward:/hystrix";
	}
}
