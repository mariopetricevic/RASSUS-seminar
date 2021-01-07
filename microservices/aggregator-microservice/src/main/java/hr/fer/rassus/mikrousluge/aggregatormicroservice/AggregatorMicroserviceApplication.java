package hr.fer.rassus.mikrousluge.aggregatormicroservice;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;





@SpringBootApplication
public class AggregatorMicroserviceApplication{
	

	public static void main(String[] args) {
		System.setProperty("spring.cloud.bootstrap.enabled","true");
		SpringApplication.run(AggregatorMicroserviceApplication.class, args);
	}
	
	
}
