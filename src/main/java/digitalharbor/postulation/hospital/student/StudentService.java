package digitalharbor.postulation.hospital.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	public List<Student> getStudents()
	{
		return  List.of(
					new Student(1L,"Luis Antonio", "antoniomolina.yampa@gmail.com", LocalDate.of(1987, 10, 31), 34)
				);
	}

}
