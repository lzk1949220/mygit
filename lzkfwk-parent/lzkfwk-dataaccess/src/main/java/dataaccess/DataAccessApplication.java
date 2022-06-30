package dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import dataaccess.test.TestNettyServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DataAccessApplication  implements CommandLineRunner{

	@Autowired
	TestNettyServer nettyserver;
	
	public static void main(String[] args) {

		SpringApplication.run(DataAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Thread(nettyserver).start();
	}

}
