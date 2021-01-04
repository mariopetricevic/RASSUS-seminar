package hr.fer.rassus.mikrousluge.aggregatormicroservice;

import java.io.IOException;


import org.springframework.stereotype.Service;


import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class RetrofitImplementation implements RestInterface{
	
	private HumidityApi humidityApi;
	private TemperatureApi temperatureApi;
	private String temperatureURL, humidityURL;
	
	

	
	public RetrofitImplementation()
	{
		temperatureURL="http://localhost:8081";
		humidityURL="http://localhost:8082";
		
		Retrofit retrofit1 = new Retrofit.Builder().baseUrl(temperatureURL)
				.addConverterFactory(JacksonConverterFactory.create()).build();
		
		Retrofit retrofit2 = new Retrofit.Builder().baseUrl(humidityURL)
				.addConverterFactory(JacksonConverterFactory.create()).build();
		
		temperatureApi=retrofit1.create(TemperatureApi.class);
		humidityApi=retrofit2.create(HumidityApi.class);
	}

	@Override
	public TemperatureReading getTemperature() {
		try {
			return temperatureApi.getTemperature().execute().body();
			
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public HumidityReading getHumidity() {
		try {
			return humidityApi.getHumidity().execute().body();
			
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
