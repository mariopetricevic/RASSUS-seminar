package hr.fer.rassus.mikrousluge.humiditymicroservice;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumidityReadingController {
	private HumidityRepository repo;
	
	public HumidityReadingController(HumidityRepository repo)
	{
		this.repo=repo;
	}
	@GetMapping("/current-reading")
	public HumidityReading getCurrentReading()
	{
		HumidityReading reading;
		LocalTime time=LocalTime.now();
		long id=time.getHour()*4 + time.getMinute()/15;
		
		reading=repo.findById(id).get();
		
		
		return reading;
		//return repo.findById(id).get();
	}
}
