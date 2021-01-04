package hr.fer.rassus.mikrousluge.temperaturemicroservice;

import org.springframework.data.jpa.repository.JpaRepository;



public interface TemperatureRepository extends JpaRepository<TemperatureReading, Long>{
	// javno sucelje JPaRepository preko kojega dohvcam sva mjerenja iz baze preko ida
	

}
