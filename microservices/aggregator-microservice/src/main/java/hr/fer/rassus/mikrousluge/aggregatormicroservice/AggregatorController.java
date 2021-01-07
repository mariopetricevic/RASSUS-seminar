package hr.fer.rassus.mikrousluge.aggregatormicroservice;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {

	@Autowired
	private RetrofitImplementation service;
	
	@Value("${msg:}")
	private String msg;
	
	
	@GetMapping("/msg")
	public String getMsg()
	{
		return this.msg;
	}
	
	@GetMapping("/readings")
	public String getReadings()
	{
		//Map<String,String> map=new HashMap<>();
		String temperature="Temperature: "+ service.getTemperature().getTemperature().toString();
		String humidity="Humidity: "+ service.getHumidity().getHumidity().toString();
		String reading=temperature+ "<br>"+ humidity+"%" + msg;
		//map.put(service.getTemperature().getTemperature(), service.getHumidity().getHumidity());
		//map.put(temperature, humidity);
		//return map;
		return reading;
	}
	
}
