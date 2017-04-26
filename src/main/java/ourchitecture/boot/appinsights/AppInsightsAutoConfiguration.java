package ourchitecture.boot.appinsights;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;

@Configuration
public class AppInsightsAutoConfiguration {

	@Bean
	public FilterRegistrationBean applicationInsightsFilterRegistration() {
	    
		FilterRegistrationBean registration = new FilterRegistrationBean();
	    
	    registration.setFilter(applicationInsightsWebFilter());
	    registration.addUrlPatterns("/*");
	    registration.setName("ApplicationInsightsWebFilter");
	    registration.setOrder(1);
	    
	    return registration;
	}

	@Bean(name = "applicationInsightsWebFilter")
	public Filter applicationInsightsWebFilter() {
		return new WebRequestTrackingFilter();
	}
}
