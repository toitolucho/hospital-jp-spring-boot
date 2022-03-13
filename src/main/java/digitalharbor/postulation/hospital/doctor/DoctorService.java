package digitalharbor.postulation.hospital.doctor;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;



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


	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepository.save(doctor);
	}


	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.getById( id);
	}


	public void deleteDoctorById(int id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
	}


	public Page<Doctor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.doctorRepository.findAll(pageable);
		
	}

}
