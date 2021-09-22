package local.systemv.springcloudexam.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebClientApplication.class, args);
	}

}
