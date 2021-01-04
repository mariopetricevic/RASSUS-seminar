package hr.fer.rassus.mikrousluge.aggregatormicroservice;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@SpringBootApplication
public class AggregatorMicroserviceApplication{
	

	public static void main(String[] args) {
		SpringApplication.run(AggregatorMicroserviceApplication.class, args);
	}
	
	
}
