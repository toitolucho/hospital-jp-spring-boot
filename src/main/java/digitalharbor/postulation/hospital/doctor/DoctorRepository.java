package digitalharbor.postulation.hospital.doctor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	//Optional<Doctor> findDoctorById(Integer id);
}
