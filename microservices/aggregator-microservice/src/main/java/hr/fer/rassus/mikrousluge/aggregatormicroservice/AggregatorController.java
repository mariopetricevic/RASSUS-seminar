package hr.fer.rassus.mikrousluge.aggregatormicroservice;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;


@RestController
public class AggregatorController {

	@Autowired
	private RetrofitImplementation service;
	
	
	
	@Value("${unit: default}")
	private String unit;
	@Value("${temperature-service.name: deftemp}")
	private String temperatureServiceName;
	@Value("${humidity-service.name: defhum}")
	private String humidityServiceName;
	
	
	@GetMapping("/unit")
	public String getMsg()
	{
		return this.unit;
	}
	

	
	@GetMapping("/readings")
	public String getReadings()
	{
		int temp;
		String temperatureInKelvin;
		if (unit.equals("K"))
		{
			temp=Integer.parseInt(service.getTemperature().getTemperature());
			temp=temp+273;
			temperatureInKelvin=String.valueOf(temp);
			String temperature="Temperature: "+ temperatureInKelvin + " "+ unit;
			String humidity="Humidity: "+ service.getHumidity().getHumidity().toString();
			String reading=temperature+ "<br>"+ humidity+"%";
			
			return reading;
		}
		else
		{
			return "Temperature: "+ service.getTemperature().getTemperature().toString()+ "C, Humidity: "+service.getHumidity().getHumidity().toString()+"%";
		}
		
	}
	
}
