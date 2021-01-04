package hr.fer.rassus.mikrousluge.humiditymicroservice;

import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.bean.CsvToBeanBuilder;


@SpringBootApplication
public class HumidityMicroserviceApplication implements CommandLineRunner{

	@Autowired
	private HumidityRepository repo;
	

	public static void main(String[] args) {
		SpringApplication.run(HumidityMicroserviceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<HumidityReading> readings =new CsvToBeanBuilder<HumidityReading>
		(new FileReader("mjerenja.csv")).withType(HumidityReading.class).
		build().parse();
		
		long l=0;
		for(HumidityReading reading : readings)
		{
			reading.setId(l++);
		}
		//ovdje sva mjerenja iz csv datoteke spremim u h2 bazu koja se nalazi na localhost:8082/h2-console
		repo.saveAll(readings);
		
		//ovdje samo ispisem u konzolu sva mjerenja
		readings.stream().forEach(System.out::println);
	}

}
