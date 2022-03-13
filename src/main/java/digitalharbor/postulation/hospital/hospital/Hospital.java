package digitalharbor.postulation.hospital.hospital;
// default package
// Generated Mar 11, 2022, 10:21:50 AM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import digitalharbor.postulation.hospital.doctor.Doctor;

/**
 * Hospital generated by hbm2java
 */
@Entity
@Table(name = "Hospitals")
public class Hospital {

	@Id
	@GeneratedValue
	@Column(name = "HospitalId")
	private Integer Id;
	private String name;
	private String description;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "HospitalId", referencedColumnName = "HospitalId")
	private Set<Doctor> doctors = new HashSet<Doctor>(0);

	public Hospital() {
	}

	public Hospital(String name, String description, Set<Doctor> doctors) {
		this.name = name;
		this.description = description;
		this.doctors = doctors;
	}
	
	public Hospital(String name, String description) {
		this.name = name;
		this.description = description;
	
	}

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

}