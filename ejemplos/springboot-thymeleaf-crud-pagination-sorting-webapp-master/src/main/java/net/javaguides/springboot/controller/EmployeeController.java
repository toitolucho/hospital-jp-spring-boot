package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Doctor;
import net.javaguides.springboot.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService DoctorService;
	
	// display list of Doctors
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	
	@GetMapping("/showNewDoctorForm")
	public String showNewDoctorForm(Model model) {
		// create model attribute to bind form data
		Doctor Doctor = new Doctor();
		model.addAttribute("Doctor", Doctor);
		return "new_Doctor";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("Doctor") Doctor Doctor) {
		// save Doctor to database
		DoctorService.saveDoctor(Doctor);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get Doctor from the service
		Doctor Doctor = DoctorService.getDoctorById(id);
		
		// set Doctor as a model attribute to pre-populate the form
		model.addAttribute("Doctor", Doctor);
		return "update_Doctor";
	}
	
	@GetMapping("/deleteDoctor/{id}")
	public String deleteDoctor(@PathVariable (value = "id") long id) {
		
		// call delete Doctor method 
		this.DoctorService.deleteDoctorById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Doctor> page = DoctorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Doctor> listDoctors = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listDoctors", listDoctors);
		return "index";
	}
}
