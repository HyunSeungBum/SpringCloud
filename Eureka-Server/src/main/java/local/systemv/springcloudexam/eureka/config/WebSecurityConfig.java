package local.systemv.springcloudexam.eureka.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//requestMatchers을 사용하면 일치하지 않는 요청이 나머지 다른 체인에 의해 확인됩니다.
        //Actuator 외의 요청은 기존 보안 규칙을 따라야 하기 떄문에 requestMatchers를 사용해서 Actuator 보안설정만 진행한다.
        http.requestMatcher(EndpointRequest.toAnyEndpoint())
                .authorizeRequests()
                .antMatchers("/actuator/health")
                .permitAll() // /actuator/health 만 인증없이 접근할 수 있도록 함
                .antMatchers("/actuator/refresh")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .httpBasic();
	}
}