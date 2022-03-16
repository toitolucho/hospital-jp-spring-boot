package digitalharbor.postulation.hospital.doctor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "api/v1/doctors")
@RequestMapping("/doctor")
public class DoctorControllerAPI {
	private final DoctorService doctorService;

	@Autowired
	public DoctorControllerAPI(DoctorService doctorService) {

		this.doctorService = doctorService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctores = doctorService.getDcotors();
		return new ResponseEntity<>(doctores, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable("id") int id) {
		// Optional<Doctor> Doctor = DoctorService.findDoctorById(id);
		Optional<Doctor> doctor = doctorService.findDoctorById(id);
		 return new ResponseEntity<>(doctor, HttpStatus.OK);
		//return null;
	}

	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor Doctor) {
		Doctor newDoctor;

		newDoctor = doctorService.saveDoctor(Doctor);

		return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		Doctor updateDoctor = doctorService.updateDoctorById(doctor);
		return new ResponseEntity<>(updateDoctor, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id) {
		doctorService.deleteDoctorById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
