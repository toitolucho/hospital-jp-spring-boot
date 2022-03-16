package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Doctor;
import net.javaguides.springboot.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository DoctorRepository;

	@Override
	public List<Doctor> getAllDoctors() {
		return DoctorRepository.findAll();
	}

	@Override
	public void saveDoctor(Doctor Doctor) {
		this.DoctorRepository.save(Doctor);
	}

	@Override
	public Doctor getDoctorById(long id) {
		Optional<Doctor> optional = DoctorRepository.findById(id);
		Doctor Doctor = null;
		if (optional.isPresent()) {
			Doctor = optional.get();
		} else {
			throw new RuntimeException(" Doctor not found for id :: " + id);
		}
		return Doctor;
	}

	@Override
	public void deleteDoctorById(long id) {
		this.DoctorRepository.deleteById(id);
	}

	@Override
	public Page<Doctor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.DoctorRepository.findAll(pageable);
	}
}
