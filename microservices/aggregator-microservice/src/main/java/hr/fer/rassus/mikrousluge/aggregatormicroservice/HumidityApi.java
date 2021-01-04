package hr.fer.rassus.mikrousluge.aggregatormicroservice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HumidityApi {

	@GET("/current-reading")
	Call<HumidityReading> getHumidity();

}

