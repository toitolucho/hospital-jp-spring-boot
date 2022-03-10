package digitalharbor.postulation.hospital.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	protected Student() {
		
	}
	public Student(Long id, String name, String email, LocalDate dob, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public Student(String name, String email, LocalDate dob, Integer age) {
		
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	
	public Student(String name, String email, LocalDate dob) {
		
		this.name = name;
		this.email = email;
		this.dob = dob;
	
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	
	

}
