package local.systemv.springcloudexam.employee.consumer.controller;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.Logger;

@RestController
@RefreshScope
@Profile("consumer")
public class ConsumerControllerClient {
	
	//@Autowired
	//private EurekaClient  discoveryClient;
	
	@Autowired  // used spring cloud loadbalancer
	private LoadBalancerClient loadBalancerClient;
	
	@Value("${employee.appconfig.producer-alias}")
	private String producerVirtualAlias;

	@GetMapping("/eureka/client")
	public void getEmployee() throws RestClientException, IOException {
		
		final Logger LOGGER = (Logger) LoggerFactory.getLogger(ConsumerControllerClient.class);
		
		/** 서버 주소를 직접 호출. Eureka 없이 호출하는 형태
		String baseUrl = "http://localhost:8080/employee";
		**/
		
		/** Eureka 
		final InstanceInfo instance = discoveryClient.getNextServerFromEureka(producerVirtualAlias, false);
		String baseUrl = instance.getHomePageUrl() + "/employee";
		**/
			
		/** Spring Cloud LoadBalancer **/
		ServiceInstance serviceInstance = loadBalancerClient.choose(producerVirtualAlias);
		System.out.println("#####service-instance-uri:"+serviceInstance.getUri());
		String baseUrl = serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/employee";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		
		try {
			response = restTemplate.exchange(baseUrl,
					HttpMethod.GET, getHeaders(), String.class);
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		System.out.println(response.getBody());
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}

