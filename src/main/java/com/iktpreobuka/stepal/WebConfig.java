package com.iktpreobuka.stepal;

	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.CorsRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	@Configuration
	public class WebConfig implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:3000") // Dozvolite zahteve samo sa ovog origina
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Dozvolite određene metode
	                .allowedHeaders("*") // Dozvolite sve zaglavlja
	                .allowCredentials(true); // Dozvolite kolačiće
	    }
	}
