package local.systemv.springcloudexam.webclient;

//import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigurationProvider {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder().baseUrl("http://EMPLOYEE-PRODUCER");
    }
    
}
