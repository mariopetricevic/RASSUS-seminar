package hr.fer.rassus.mikrousluge.humiditymicroservice;

import org.springframework.data.jpa.repository.JpaRepository;



public interface HumidityRepository extends JpaRepository<HumidityReading, Long>{
	// javno sucelje JPaRepository preko kojega dohvcam sva mjerenja iz baze preko ida
	

}
