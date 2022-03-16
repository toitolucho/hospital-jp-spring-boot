package digitalharbor.postulation.hospital.doctor;

import java.time.LocalDate;
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

@Controller
//@RequestMapping(path = "api/v1/doctors")
public class DoctorController {
	private final DoctorService doctorService;
	
	
	@Autowired
	public DoctorController(DoctorService doctorService) {
		
		this.doctorService = doctorService;
	}



	@GetMapping("/doctores")
	public List<Doctor> getDoctors()
	{
		//return null;
		return  doctorService.getDcotors();
	}
	
	@GetMapping("/listar")
	public String listar(Model model)
	{
		
		System.out.println("listar doctores llamada");
		List<Doctor> doctores = doctorService.getDcotors();
		model.addAttribute("doctores",doctores);
		//return null;
		return "index";  
	}
	
	
	@GetMapping("/showNewDoctorForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "new_doctor";
	}
	
	@PostMapping("/saveDoctor")
	public String saveEmployee(@ModelAttribute("doctor") Doctor doctor) {
		// save employee to database
		System.out.println(doctor);
		 
		doctorService.saveDoctor(doctor);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		
		// get employee from the service
		Doctor doctor = doctorService.getDoctorById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("doctor", doctor);
		return "update_doctor";
	}
	
	@GetMapping("/deleteDoctor/{id}")
	public String deleteEmployee(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.doctorService.deleteDoctorById(id);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Doctor> page = doctorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Doctor> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listDoctors", listEmployees);
		return "index";
	}
}
