package digitalharbor.postulation.hospital.doctor;
// default package
// Generated Mar 11, 2022, 10:21:50 AM by Hibernate Tools 5.6.3.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import digitalharbor.postulation.hospital.hospital.Hospital;


@Entity
@Table(name = "Doctors")
public class Doctor {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DoctorId")
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@ManyToOne
	@JsonBackReference	
	@JoinColumn(name = "HospitalId", referencedColumnName = "HospitalId")
	private Hospital hospital;
	@Column(name = "FirstName")
	private String names;
	@Column(name = "LastNames")
	private String lastNames;
	@Column(name = "DateOfBirth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@Column(name = "Address")
	private String address;
	@Column(name = "PictureFile")
	private String pictureFile;

	public Doctor() {
	}

	public Doctor(Hospital hospital, String names, String lastNames, Date dateOfBirth, String adress,
			String pictureFile) {
		this.hospital = hospital;
		this.names = names;
		this.lastNames = lastNames;
		this.dateOfBirth = dateOfBirth;
		this.address = adress;
		this.pictureFile = pictureFile;
	}
	
	public Doctor(String names, String lastNames, Date dateOfBirth, String adress,
			String pictureFile) {		
		this.names = names;
		this.lastNames = lastNames;
		this.dateOfBirth = dateOfBirth;
		this.address = adress;
		this.pictureFile = pictureFile;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return this.lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPictureFile() {
		return this.pictureFile;
	}

	public void setPictureFile(String pictureFile) {
		this.pictureFile = pictureFile;
	}

}
