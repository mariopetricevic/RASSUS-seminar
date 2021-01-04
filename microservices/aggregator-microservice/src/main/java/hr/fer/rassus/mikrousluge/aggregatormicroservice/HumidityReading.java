package hr.fer.rassus.mikrousluge.aggregatormicroservice;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class HumidityReading {

	@Id
	private Long Id;
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	private String humidity;

	public HumidityReading() {
	}


	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	//@Override
	//public String toString() {
	//	return "HumidityReading [Id=" + Id +  ", humidity=" + humidity + "]";
	//}
}

