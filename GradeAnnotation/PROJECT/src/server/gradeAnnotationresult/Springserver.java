package server.gradeAnnotationresult;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Springserver {
	// Spring web framework uploading file
	@Bean
    MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }    
	@Bean
	public MultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}
	/** This is the running main method for the web application */
	 public static void Start() throws Exception {
	    	
	        System.setProperty("java.awt.headless", "false");
	        SpringApplication.run(Springserver.class, System.getProperty("user.home") + "/Grades");
	    }
}
