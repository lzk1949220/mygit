package smcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
@PropertySource(value = "classpath:application-center1.properties",encoding = "UTF-8")
public class SmCenterApplicationByEureka1 {

	public static void main(String[] args) {
		SpringApplication.run(SmCenterApplicationByEureka1.class, args);
	}

}
