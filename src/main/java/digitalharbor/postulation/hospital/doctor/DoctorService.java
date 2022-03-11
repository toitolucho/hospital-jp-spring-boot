package digitalharbor.postulation.hospital.doctor;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class DoctorService {
	private final DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorService(DoctorRepository studentRepository) {		
		this.doctorRepository = studentRepository;
	}


	public List<Doctor> getDcotors()
	{
//		return  List.of(
//					new Student("Luis Antonio", "antoniomolina.yampa@gmail.com", LocalDate.of(1987, 10, 31), 34)
//				);
		return doctorRepository.findAll();
		//return null;
	}

}
