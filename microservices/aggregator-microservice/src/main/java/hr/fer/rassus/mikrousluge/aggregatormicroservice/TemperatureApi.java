package hr.fer.rassus.mikrousluge.aggregatormicroservice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TemperatureApi {
	
	@GET("/current-reading")
	Call<TemperatureReading> getTemperature();

}
