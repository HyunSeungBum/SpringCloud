package local.systemv.springcloudexam.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<Config> {
	public GlobalFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return (exchange, chain) -> {
			log.info("GlobalFilter baseMessage: {}", config.getBaseMessage());

			if (config.isPreLogger()) {
				log.info("GlobalFilter Start: {}", exchange.getRequest());
			}
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				if (config.isPostLogger()) {
					log.info("GlobalFilter End: {}", exchange.getResponse());
				}

			}));

		};
	}

}
