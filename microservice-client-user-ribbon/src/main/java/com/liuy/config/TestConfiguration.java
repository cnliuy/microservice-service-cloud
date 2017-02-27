package com.liuy.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
public class TestConfiguration {
	  //@Autowired
	  //IClientConfig config;

	  @Bean
	  public IRule ribbonRule() {
	    return new RandomRule();
	  }
}
