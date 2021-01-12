package hr.fer.rassus.mikrousluge.aggregatormicroservice;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.Service;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;




@RestController
@RequestMapping("/")
public class AggregatorController {
	
	static RestInterface service;

	//@Autowired
	//private RetrofitImplementation service;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Value("${unit: default}")
	private String unit;
	
	@Value("${temperature-service.name: deftemp}")
	private String temperatureServiceName;
	
	@Value("${humidity-service.name: defhum}")
	private String humidityServiceName;
	
	

	@GetMapping("/readings")
	public String getReadings()
	{
		Application application1=eurekaClient.getApplication(temperatureServiceName);
		InstanceInfo info1=application1.getInstances().get(0);
		Application application2=eurekaClient.getApplication(humidityServiceName);
		InstanceInfo info2=application2.getInstances().get(0);
		
		String humidityUrl="http://"+info2.getHostName()+":"+info2.getPort();
		String temperatureUrl="http://"+info1.getHostName()+":"+info1.getPort();
		service=new RetrofitImplementation(temperatureUrl, humidityUrl);
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
