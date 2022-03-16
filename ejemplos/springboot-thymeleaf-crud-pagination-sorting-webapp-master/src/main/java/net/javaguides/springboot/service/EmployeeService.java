package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Doctor;

public interface DoctorService {
	List<Doctor> getAllDoctors();
	void saveDoctor(Doctor Doctor);
	Doctor getDoctorById(long id);
	void deleteDoctorById(long id);
	Page<Doctor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
