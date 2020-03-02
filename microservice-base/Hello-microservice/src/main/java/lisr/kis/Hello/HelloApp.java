package lisr.kis.Hello;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringCloudApplication
public class HelloApp 
{
	@Bean
	@LoadBalanced
	public RestTemplate restemplate() {
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(HelloApp.class, args);
    }
}
