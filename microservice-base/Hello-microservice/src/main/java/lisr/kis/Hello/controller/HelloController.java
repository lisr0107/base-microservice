package lisr.kis.Hello.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.instrument.util.StringUtils;

@RestController
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private GitConfigLisr lisr;
	
	@RequestMapping("/hello-me")
	public String hello() {
		return restTemplate.getForObject("http://hello-service-resp/hello", String.class);
	}
	
	@GetMapping("/")
	public String index(HttpServletRequest req) {
		String sa = req.getHeader("Authorization");
		String host = req.getHeader("Host");
		String ret= "hello";
		if (!StringUtils.isEmpty(sa)) {
			ret = ret + sa;
		}
		if (!StringUtils.isEmpty(host)) {
			ret = ret + " - " + host;
		}
		return ret;
	}
	
	@GetMapping("/lisr")
	public GitConfigLisr gitLisr() {
		GitConfigLisr gl = new GitConfigLisr();
		gl.setName(lisr.getName());
		gl.setAge(lisr.getAge());
		gl.setGender(lisr.getGender());
		gl.setPassword(lisr.getPassword());
		return gl;
	}

	public GitConfigLisr getLisr() {
		return lisr;
	}

	public void setLisr(GitConfigLisr lisr) {
		this.lisr = lisr;
	}
	
	
}
