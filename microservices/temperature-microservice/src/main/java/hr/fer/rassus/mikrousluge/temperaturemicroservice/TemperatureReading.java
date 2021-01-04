package hr.fer.rassus.mikrousluge.temperaturemicroservice;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class TemperatureReading {

	//svi atributi iz baze iako treba samo temperatura ovdje
	@Id
	private Long Id;
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	private String temperature;

	public TemperatureReading() {
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}



	@Override
	public String toString() {
		return "TemperatureReading [Id=" + Id + ", temperature=" + temperature + "]";
	}
}

