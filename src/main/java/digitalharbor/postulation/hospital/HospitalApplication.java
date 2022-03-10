package digitalharbor.postulation.hospital;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import digitalharbor.postulation.hospital.student.Student;





@SpringBootApplication
public class HospitalApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

}
