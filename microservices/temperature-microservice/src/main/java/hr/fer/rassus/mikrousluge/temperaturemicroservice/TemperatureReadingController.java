package hr.fer.rassus.mikrousluge.temperaturemicroservice;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureReadingController {
	private TemperatureRepository repo;
	
	public TemperatureReadingController(TemperatureRepository repo)
	{
		this.repo=repo;
	}
	
	@GetMapping("/current-reading")
	public TemperatureReading getCurrentReading()
	{
		TemperatureReading reading;
		LocalTime time=LocalTime.now();
		long id=time.getHour()*4 + time.getMinute()/15;
		
		reading=repo.findById(id).get();
		
		return reading;
		
	}
}
