package hr.fer.rassus.mikrousluge.aggregatormicroservice;



public interface RestInterface {
	
	TemperatureReading getTemperature();
	HumidityReading getHumidity();

}
