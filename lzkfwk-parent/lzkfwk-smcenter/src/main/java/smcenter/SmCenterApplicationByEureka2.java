package smcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
@PropertySource(value = "classpath:application-center2.properties",encoding = "UTF-8")
public class SmCenterApplicationByEureka2 {

	public static void main(String[] args) {
		SpringApplication.run(SmCenterApplicationByEureka2.class, args);
	}

}
