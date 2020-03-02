package lisr.hello.resp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RespController {

	@RequestMapping("/hello")
	public String Hello() {
		return "hello me";
	}
}
