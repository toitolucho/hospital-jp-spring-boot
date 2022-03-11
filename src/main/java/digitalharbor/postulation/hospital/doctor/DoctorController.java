package digitalharbor.postulation.hospital.doctor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/doctors")
public class DoctorController {
	private final DoctorService doctorService;
	
	
	@Autowired
	public DoctorController(DoctorService doctorService) {
		
		this.doctorService = doctorService;
	}



	@GetMapping
	public List<Doctor> getDoctors()
	{
		//return null;
		return  doctorService.getDcotors();
	}
}
