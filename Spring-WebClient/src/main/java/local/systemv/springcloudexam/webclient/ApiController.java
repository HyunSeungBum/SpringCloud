package local.systemv.springcloudexam.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
public class ApiController {
	
	// webclient. openfeign 은 Reactive 를 지원하지 않는다.
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/employee/{empId}")
	public Mono<String> getEmployee(@PathVariable final Long empId) {
		WebClient client = webClientBuilder.build();
		
		return client
				.get()
				.uri(uriBuilder -> uriBuilder.path("/employee/{empId}").build(empId))
				.accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(String.class);
	}
	
	@GetMapping("/employee")
	public Flux<String> getEmployee() {
		WebClient client = webClientBuilder.build();
		return client
				.get()
				.uri("/employee")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(String.class);
	}
	
}
